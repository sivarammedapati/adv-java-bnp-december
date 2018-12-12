package com;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkAndJoinDemo extends RecursiveTask<Integer>{

	private int [] data;
	
	public ForkAndJoinDemo(int [] data) {
		this.data = data;
	}
	
	@Override
	protected Integer compute() {
		
		int size = data.length;
		System.out.println("ForkAndJoinDemo.compute(): " + Thread.currentThread().getName() + " " + size);
		if(size >= 5) {
			
			ForkAndJoinDemo left = new ForkAndJoinDemo(Arrays.copyOfRange(data, 0, size/2));
			ForkAndJoinDemo right = new ForkAndJoinDemo(Arrays.copyOfRange(data, size/2, size));
			left.fork();
			right.fork();
			
			int result = Integer.sum(left.join(), right.join());
			System.out.println("in if: " + result);
			return result;
		}
		else {
			System.out.println("in else: " + IntStream.of(data).sum());
			return IntStream.of(data).sum();
		}
		
		
	}
	
	public static void main(String[] args) {
	
		int [] numbers = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		int result = pool.invoke(new ForkAndJoinDemo(numbers));
		
		System.out.println("Result: " + result);
		
		

	}

	

}

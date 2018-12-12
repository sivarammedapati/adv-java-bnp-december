package com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Order implements Runnable{
	
	private String name;
	private int delay;
	private CyclicBarrier barrier;
	
	public Order(String name, int delay, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.delay = delay;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		
		try {
			
			//System.out.println(this.name + " starting");
			Thread.sleep(delay);
			barrier.await();
			System.out.println(this.name + " completed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Barrier reached");
				
			}
		});
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 15; i++) {
			
			executorService.execute(new Order("Order " + i, (i + 1) * 1000, barrier));
		}
		
		
		
		
		

	}

}

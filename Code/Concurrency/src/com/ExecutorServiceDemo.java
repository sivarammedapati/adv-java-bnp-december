package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class MyTask implements Runnable, Callable<Integer>{
	
	private int taskId;
	
	public MyTask(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " starting task: " + taskId);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " completing task: " + taskId);
		
	}

	@Override
	public Integer call() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " starting task: " + taskId);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " completing task: " + taskId);
		
		return taskId * 100;
	}
	
}

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		ExecutorService executorService 
				= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
				//= Executors.newCachedThreadPool();
				//= Executors.newSingleThreadExecutor();
				//= Executors.newWorkStealingPool();
		
//		for (int i = 0; i < 10; i++) {
//			executorService.execute(new MyTask(i));
//		}
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			executorService.execute(new MyTask(i));
//		}
		
		List<Future<Integer>> futures = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			
			Callable<Integer> callable = new MyTask(i);
			Future<Integer> future =  executorService.submit(callable);
			futures.add(future);
		}
		
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(5000, TimeUnit.SECONDS);
			for (Future<Integer> future : futures) {
				System.out.println("Result: " + future.get());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ExecutorServiceDemo.main()- completed");

	}

}

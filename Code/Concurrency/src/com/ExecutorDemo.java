package com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
	
	private int taskId;
	
	public Task(int taskId) {
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
	
}

public class ExecutorDemo {

	public static void main(String[] args) {
		
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 15, 30, TimeUnit.SECONDS, workQueue);
		
		for (int i = 0; i < 50; i++) {
			
			executor.execute(new Task(i));
		}
	
		executor.shutdown();
		
		try {
			executor.awaitTermination(5000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ExecutorDemo.main(): executor shutdown" );
		
		
		
	}

}











package com;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {
	
	private Semaphore semaphore = new Semaphore(2);
	
	
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " staring ");
		try {
			
			semaphore.acquire();
			
			System.out.println(Thread.currentThread().getName() + " acquired semphore... ");
			Thread.sleep(5000);
			
			semaphore.release();
			
			System.out.println(Thread.currentThread().getName() + " releases semphore... ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	

	public static void main(String[] args) {
		
		SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
		Thread t1= new Thread(semaphoreDemo);
		t1.start();
		
		Thread t2= new Thread(semaphoreDemo);
		t2.start();
		
		Thread t3= new Thread(semaphoreDemo);
		t3.start();

	}

}

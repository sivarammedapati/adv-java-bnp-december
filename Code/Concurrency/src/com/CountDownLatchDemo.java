package com;

import java.util.concurrent.CountDownLatch;

class Service implements Runnable{
	
	private String name;
	private int delay;
	private CountDownLatch latch;
	
	public Service(String name, int delay, CountDownLatch latch) {
		super();
		this.name = name;
		this.delay = delay;
		this.latch = latch;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println(this.name + " starting");
			Thread.sleep(delay);
			latch.countDown();
			//latch.await();
			System.out.println(this.name + " completed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}

public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new Service("DBService", 2000, latch));
		Thread t2 = new Thread(new Service("MessageService", 4000, latch));
		Thread t3 = new Thread(new Service("EmailService", 1500, latch));
		
		t1.start();t2.start();t3.start();
		
		try {
			latch.await();
		
			//code to start the app
			System.out.println("CountDownLatchDemo.main(): completed....");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}










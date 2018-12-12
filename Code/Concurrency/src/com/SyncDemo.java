package com;

public class SyncDemo implements Runnable {

	private static Counter counter = new Counter();
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			counter.incrementCount();
		}
		
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new SyncDemo());
		t1.start();
		Thread t2 = new Thread(new SyncDemo());
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count: " + counter.getCount());
		
	}

}






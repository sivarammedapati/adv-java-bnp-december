package com;

public class Counter {
	
	private int count =  0;
	private Object mutex = new Object();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	//public synchronized void incrementCount() {
	public  void incrementCount() {
		
		System.out.println(Thread.currentThread().getName() + "-incrementing count: " + this.count);
		
		//this.count++;
		//synchronized (this) {
		synchronized (mutex) {
			
			int temp = this.count;
			temp++;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.count == 5 && Thread.currentThread().getName().equals("Thread-0") ) {
				System.out.println(Thread.currentThread().getName() + " calling wait...");
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " realeased from wait...");
			}
			if(this.count == 6 ) {
				mutex.notifyAll();
			}
			this.count = temp;
		}
		
		System.out.println(Thread.currentThread().getName() + "-incremented count: " + this.count);
	}
}












package com;

public class ThreadLocalDemo implements Runnable{
	
	private double value;
	private ThreadLocal<Double> threadLocal = new ThreadLocal<>();
	
	@Override
	public void run() {
		
		double rnd = Math.random() * 100;
		System.out.println("ThreadLocalDemo.run(): " + rnd);
		
		this.value = rnd;
		threadLocal.set(rnd);
		
		printValues();
	}
	
	private void printValues() {
		System.out.println("ThreadLocalDemo.printValues(): value: " + this.value);
		System.out.println("ThreadLocalDemo.printValues(): thread-local: " + this.threadLocal.get());
	}
	

	public static void main(String[] args) {
		
		ThreadLocalDemo obj = new ThreadLocalDemo();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); t2.join();
			System.out.println("ThreadLocalDemo.main() value: " + obj.value);
			System.out.println("ThreadLocalDemo.main() thread-local: " + obj.threadLocal.get());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}

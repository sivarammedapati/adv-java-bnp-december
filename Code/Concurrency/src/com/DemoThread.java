package com;

class MyRunnable implements Runnable{

	@Override
	public void run() {
		
		MainThread.printThreadInfo();
		
	}
	
}

public class DemoThread extends Thread {

	@Override
	public void run() {
		
		MainThread.printThreadInfo();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Demo Thread over...");
		
	}
	
	public static void main(String[] args) {
		
		MainThread.printThreadInfo();
		
		DemoThread demoThread = new DemoThread();
		demoThread.setName("DemoThread");
		demoThread.setPriority(10);
		demoThread.setDaemon(false);
		demoThread.start();
		
		Thread runnableThread = new Thread(new MyRunnable());
		runnableThread.start();
		

		System.out.println("Main Complete");
	}

}

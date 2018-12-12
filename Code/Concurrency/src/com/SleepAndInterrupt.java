package com;

import java.io.File;

public class SleepAndInterrupt  extends Thread
{
	
	private int fileCount;
	
	private void watchFiles() {
		
		File file = new File("C:\\temp");
		String [] allFiles =  file.list();
		if(fileCount != allFiles.length) {
			System.out.println("Directory changed with file count: " + allFiles.length);
			fileCount = allFiles.length;
		}
		else {
			System.out.println("No changes");
		}
		
	}
	
	@Override
	public void run() {
		while(true) {
			watchFiles();
			
			if(this.isInterrupted()) {
				System.out.println("Thread intruppted...");
				break;
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
				System.out.println("Thread intruppted...");
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		Thread thread = new Thread(new SleepAndInterrupt());
		thread.start();
				
		
		try {
			//Thread.sleep(2000);
			
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
		
		System.out.println("SleepAndInterrupt.main(): completed");
		
		//code to be executed after the thread is over
		try {
			thread.join();
			System.out.println("SleepAndInterrupt child thread completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}




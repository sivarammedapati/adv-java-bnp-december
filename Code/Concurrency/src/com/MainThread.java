package com;

public class MainThread {

	
	public static void printThreadInfo() {
		
		System.out.println("Id: " + Thread.currentThread().getId());
		System.out.println("Name: " + Thread.currentThread().getName());
		System.out.println("Priority: " + Thread.currentThread().getPriority());
		System.out.println("State: " + Thread.currentThread().getState());
		System.out.println("Thread Group: " + Thread.currentThread().getThreadGroup() );
		System.out.println("isBackground: " + Thread.currentThread().isDaemon());
		
	}
	
	public static void main(String[] args) {
		
		MainThread.printThreadInfo();	

	}

}

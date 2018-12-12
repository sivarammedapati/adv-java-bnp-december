package com;

@FunctionalInterface
public interface Simple {


	public void doTask();
	
	
	default void process() {
		
		System.out.println("Simple.process()");
		doTask();
	}
}

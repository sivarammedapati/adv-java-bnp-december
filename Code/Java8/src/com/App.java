package com;


interface Complex{
	
default void process() {
		
		System.out.println("Complex.process()");
		
	}
}

public class App implements Simple, Complex{

	
	public static void main(String[] args) {
		
		Simple obj = new  App();
		obj.process();

	}

	@Override
	public void doTask() {
		System.out.println("App.doTask()");
		
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		Complex.super.process();
	}
	
//	@Override
//	public void process() {
//	
//		System.out.println("App.process()");
//		Simple.super.process();
//	}

}

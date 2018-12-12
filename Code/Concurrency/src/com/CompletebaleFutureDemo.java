package com;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletebaleFutureDemo {

	public static void main(String[] args) {
	
		CompletableFuture<Integer> completableFuture 
					= CompletableFuture.supplyAsync(new Supplier<Integer>() {

						@Override
						public Integer get() {
							
							System.out.println(Thread.currentThread().getName() + "--started");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							throw new RuntimeException();
						}
						
						
					});

//		completableFuture
//		.handle((Integer s, Exception t) -> {return null});
		
	    completableFuture
	    	.thenApply(new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				System.out.println(Thread.currentThread().getName() + "--function");
				return t * 10;
			}
		
	    	}).thenAccept(new Consumer<Integer>() {
			
			@Override
			public void accept(Integer result) {
				System.out.println(Thread.currentThread().getName() + "--consumer");
				System.out.println("Result: " + result);
				
			}
		});
		
		

//		completableFuture.thenAccept(new Consumer<Integer>() {
//
//				@Override
//				public void accept(Integer result) {
//					
//					System.out.println(Thread.currentThread().getName() + "--consumer");
//					System.out.println("Result: " + result);
//				}
//			});
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	

}

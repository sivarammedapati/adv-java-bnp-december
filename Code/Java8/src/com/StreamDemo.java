package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		
		Stream<Integer> stream = numbers
								.parallelStream()
								//.stream()
								.filter((num) -> {
									
									System.out.println("In filter: " + Thread.currentThread().getName());
									return num > 3;
								})
								.map(num -> {
									
									System.out.println("In map: " + Thread.currentThread().getName());
									return num * num;
								});
		
		
								
		stream.forEach( result -> System.out.println(result) );
		
		//System.out.println("First: " + stream.findFirst());
		
//		List<Integer> results = stream.collect(Collectors.toList());
//		results.forEach(System.out::println);
		
		
//		int sum =  stream.reduce(0, (x, y) -> x + y);
//		System.out.println("Sum: " + sum);
		
		
//		int count = stream
//						.map(num -> 1)
//						.reduce(0, (x, y) -> x + y);
//		
//		System.out.println("Count: " + count);
		
		
		
	}

}





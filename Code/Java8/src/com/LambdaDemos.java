package com;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

interface Calculator{
	int compute(int x, int y);
}

public class LambdaDemos {

	public LambdaDemos() {
		// TODO Auto-generated constructor stub
	}
	private static int add(int a, int b) {
		
		System.out.println("LambdaDemos.add()");
		return a + b;
	}
	
	public static void main(String[] args) {
		
		//example1();
		//example2();
		example3();

	}
	
	private static void example3() {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4, 5);
		
		//External Iterator
//		for(Integer num : numbers) {
//			
//			System.out.println(num);
//		}
		
		//Internal Iterator
//		numbers.forEach((num) -> {
//			System.out.println(num);
//		});

		numbers.forEach(System.out::println);
		
		//Supplier<List<String>> supplier = () -> new ArrayList<String>();
		Supplier<List<String>> supplier = ArrayList<String>::new;
		
		
	}

	static void  somfn(Calculator c) {}

	private static void example2() {
		
		//somfn(LambdaDemos::add);
		
		
		Calculator calc = (x, y) -> x * y;
		System.out.println("Result: " + calc.compute(20, 30));
		
		calc = (int x, int y) -> {
			System.out.println("In calc lambda");
			return  x + y;
		};
		System.out.println("Result: " + calc.compute(20, 30));
	
		//calc = (x, y) -> LambdaDemos.add(x, y);
		calc = LambdaDemos::add;
		System.out.println("Result: " + calc.compute(20, 30));
		
	}

	private static void example1() {
		
		File file = new File("C:\\");
//		File [] results =  file.listFiles(new FileFilter() {
//			
//							@Override
//							public boolean accept(File f) {
//								
//								return f.isDirectory();
//							}
//						});
		File [] results =  file.listFiles((f) -> f.isDirectory());
		
		for (File result : results) {
			System.out.println(result);
		}
		
	}

}

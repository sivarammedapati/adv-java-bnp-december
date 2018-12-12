package com;

import java.util.ArrayList;
import java.util.List;

class Test{
	
	<T, U, W> void foo(T arg1, U arg2, W arg3) {}
}


//public class Box<T> {

@ClassInfo(author = "Anil Joseph", version=2)
public class Box<T extends Number> {

	//@ClassInfo(author = "Anil Joseph", version=2)
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		
		//Raw Type(Not to be used)
		Box obj = new Box();
		obj.setData(2);
		System.out.println("Data: " + obj.getData());

		
		Box<Integer> iBox = new Box<>();
		iBox.setData(200);
		System.out.println("Data: " + iBox.getData());
		
//		Box<String> sBox = new Box<>();
//		sBox.setData("Hello");
//		System.out.println("Data: " + sBox.getData());
		
		ArrayList<Number> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();
		
		printList(list1);
		printList(list2);
		
		//printList(list3);
		
		
		
	}
	
	// Upper-bound wildcard
//	public static void printList(List<? extends Number> numbers) {
//		System.out.println(numbers);
//	}
	
	//Wildcard
//	public static void printList(List<?> numbers) {
//		System.out.println(numbers);
//	}
	
	// lower-bound wildcard
	public static void printList(List<? super Integer> numbers) {
		System.out.println(numbers);
	}
	
	
	
	
	
}






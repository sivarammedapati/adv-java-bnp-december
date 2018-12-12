package com;

import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) {
		
		
		try {
			
			Class clazz =  Class.forName("com.Java7");
			System.out.println("Name: " + clazz.getName());
			System.out.println("Name: " + clazz.getSimpleName());
			
			Method [] methods = clazz.getMethods();
			for (Method method : methods) {
				System.out.println(method);
				
			}
			
			//Object creation
			Object obj =  clazz.newInstance();
			
			
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

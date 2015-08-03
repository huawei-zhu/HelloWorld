package com.od.action;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InstanceOfTest {

	
	
	
	public static void main(String[] args) {
		System.out.println(new D() instanceof B);
		System.out.println(C.class.isInstance(new D()));
		
		
	}

}

 abstract class B {
	 abstract String b();
 }
 
 class C extends B {
	 
	 @Override
	 String b() {
		 return null;
	 }
	 
 }
 class D extends B {

	@Override
	String b() {
		return null;
	}
	 
 }

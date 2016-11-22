package com.od.action;

import java.util.function.Supplier;

public class InitializeTime {
	
	private Supplier<String> su = getValue();

	public static void main(String[] args) {
		System.out.println("d::"+new InitializeTime().su.get());
	}
	
	private Supplier<String> getValue(){
		
		class SuFactory implements Supplier<String>{

			public String get() {
				System.out.println("11111111");
				return new String("hello");
			}
		}
		
		if (!SuFactory.class.isInstance(su)) {
			System.out.println("22222222222");
			return new SuFactory();
		}
		System.out.println("33333333333");
		return su;
	}

}

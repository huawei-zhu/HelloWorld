package com.od.action;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MYLambdaTest {

	public static Supplier<String> f1 = Person::getStaticName;
	public Function<Person, String> f2 = Person::getName;
	public static Function<String, String> f3 = Person::getStaticName;
	
	
	public BiFunction<Person, String, String> f4 = Person::getName;
	public BiFunction<Person, String, String> f5 = (Person p, String s) -> p.getName(s);
	
	public void aaa(){
	}
}

class Person {

	public String getName() {
		return "";
	}

	public String getName(String str) {
		return "";
	}

	public static String getStaticName() {
		return "";
	}

	public static String getStaticName(String str) {
		return "";
	}
}

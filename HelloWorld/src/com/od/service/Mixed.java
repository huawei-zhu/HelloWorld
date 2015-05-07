package com.od.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Mixed<T extends Object & Callable> {

	public static void main(String[] args) {
		List<? extends Apple> fruits = new ArrayList<Apple>();
		List<? super Apple> list = new ArrayList<Apple>();
		
//		fruits.add(new Apple());
//		fruits.add(new GreenApple());
//		
//		fruits.add(new Fruit());
//		fruits.add(new Object());
//		Fruit f1 = fruits.get(0);
//		Apple f2 = fruits.get(0);
//		GreenApple f3 = fruits.get(0);
		
//		list.add(new Apple());
//		list.add(new GreenApple());
//
//		list.add(new Fruit());
//		list.add(new Object());
//		
//		Fruit f4 = list.get(0);
//		Apple f5 = list.get(0);
//		Object f6 = list.get(0);

	}
}

class Fruit {

}

class Apple extends Fruit {

}

class GreenApple extends Apple {

}

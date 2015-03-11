package com.od.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFirstTestAction {

	private int i = 2;
	

	public MyFirstTestAction(int i) {
		this.i = i;
	}
	
	private static Function<Integer, MyFirstTestAction> f = MyFirstTestAction::new;
	private static Function<Integer, MyFirstTestAction> f1 = (Integer i) -> new MyFirstTestAction(i);
	private static IntPredicate p1 = (int i) -> i > 10;
	private static IntPredicate p2 = (int i) -> i < 20;
	private static IntPredicate p3 = p1.and(p2);
	
	

	public static void main(String[] args) throws IOException {
		System.out.println(Stream.iterate(1, i -> i + 1).limit(3).reduce(1, Integer::sum));
	}

	public void filter(String s, Function<Integer, MyFirstTestAction> f) {
		List<MyFirstTestAction> list = new ArrayList<>();
		list.add(f.apply(2));
		
	}
}

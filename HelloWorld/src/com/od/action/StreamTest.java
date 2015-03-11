package com.od.action;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("hello", "jack", "luis","even","alan");
		stream.forEach((String s) -> System.out.print(s + " "));
		
		stream = Stream.<String>builder().add("one").add("two").add("three").build();
		Stream<Integer> is = Stream.iterate(1, n -> n+1).limit(5);

		is.map(n -> n*n).peek(e -> System.out.println(e + " ")).reduce(0, Integer::sum);
		
		
	}

}

package com.od.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.<Integer> asList(1, 3, 4, 34, 54, 65, 45);
		Function<Integer, Integer> fun1 = (Integer x) -> new Integer(x * 10);
		Consumer<Integer> cons1 = (Integer c) -> System.out.print(c + ",");
		Consumer<String> cons2 = System.out::println;

		list.stream().map(fun1).forEach(cons1);
		cons2.accept("Hello World");

		Stream<String> stream1 = Stream.of("first", "second", "thrid");
		String[] array1 = { "first", "second", "thrid" };
		stream1 = Stream.of(array1);
		stream1 = Stream.<String> builder().add("first").add("second").build();
		Stream<Integer> stream2 = Stream.<Integer> empty();

		UnaryOperator<Integer> oper1 = (Integer x) -> x + 20;
		Stream<Integer> stream3 = Stream.iterate(2, oper1);

		UnaryOperator<Integer> oper2 = Integer::valueOf;
		Function<Integer, Integer> fun2 = Integer::valueOf;
		BinaryOperator<Integer> oper3 = (Integer x, Integer y) -> x + y;

		IntStream stream4 = Arrays.stream(new int[] { 1, 5, 2, 64 });

		Optional opt1 = Optional.<String> empty();
		System.out.print(opt1.isPresent());
		opt1 = Optional.of("Hello");
		System.out.println(opt1.get());
		opt1 = Optional.ofNullable(null);
		System.out.println(opt1.isPresent());

		int ii = Stream.of(1, 2, 3, 4, 5).peek((Integer x) -> System.out.println("taking element:" + x)).filter((Integer y) -> y % 2 == 1)
				.peek(e -> System.out.println("filter element: " + e)).map((Integer i) -> i * i + 1).peek(e -> System.out.println("filter element: " + e))
				.reduce(0, Integer::sum);
		System.out.println("ii=" + ii);

		Employee e1 = new Employee(23);
		Employee e2 = new Employee(3);
		Employee e3 = new Employee(5);
		Stream.of(e1, e2, e3).forEach((Employee e) -> System.out.println((int) (e.getIncome() * 1.5)));

		Stream<Stream<Integer>> s5 = Stream.of(Stream.of(1, 2, 3), Stream.of(4, 5, 6), Stream.of(7, 8, 9));
		s5.forEach(x -> System.out.println(x));
		
		Stream.of(1, 2, 3).flatMap(n -> Stream.of(4, 5, 6)).forEach(System.out::println);

		
		IntStream stream5 = Arrays.stream(new int[]{1,3,43,5,2});
		System.out.println(stream5.reduce(0, Integer::sum));
		
		Supplier<ArrayList<Integer>> sup1 = ArrayList<Integer>::new;
		BiConsumer<ArrayList<Integer>, Integer> bic1 = (list1, income) -> list1.add(income * income);
		BiConsumer<ArrayList<Integer>, ArrayList<Integer>> combiner = (list2, list3) -> list2.addAll(list3);
		Stream<Integer> stream6 = Stream.of(2,3,5);
		ArrayList<Integer> int1 = stream6.collect(sup1, bic1, combiner);
		System.out.println(int1);
		
		
		
	}
}

class Employee {

	private int income;

	public Employee(int income) {
		super();
		this.income = income;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

}

package com.od.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Mixed<T extends Object & Callable> {

	public static void main(String[] args) {
		
		int i = 23;
		int j = 3333;
		System.out.println(i/(j * 1.0));
	}
}

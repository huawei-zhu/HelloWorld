package com.od.action;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class ConcurrentModifiedExceptionTest {
	
	public static void main(String[] args) {

		
		List<String> list = new Vector<String>();
		list.add("112");
		list.add("222");
		list.add("333");
		list.add("444");

		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
			list.remove(3);
			System.out.println("dddd");
		}
		 System.out.println(list.isEmpty());
	}
}

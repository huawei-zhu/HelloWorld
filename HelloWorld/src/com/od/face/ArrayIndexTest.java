package com.od.face;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ArrayIndexTest {
	
	private static Logger logger = Logger.getLogger(ArrayIndexTest.class);  

	public static void main(String[] args) {
		String[] str = new String[2];
		System.out.println("dd"+str.length);
		if (str.length >= 1) {
			logger.info(str[2]);
		}
		List<String> list = new ArrayList<>();
		list.add("1");
		if (list.size() >= 2) {
			logger.info(list.get(1));
		}
//		logger.info(list.get(2));
	}
}

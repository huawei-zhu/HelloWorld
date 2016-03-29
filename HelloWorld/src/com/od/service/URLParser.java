package com.od.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLParser {

	public static void main(String[] args) throws Exception {

		String str = "https://localhost:80/account/myfiles.do?query=abc";
		String str1 = "hello";
		URL url = new URL(str);

		System.out.println("path:" + url.getPath());
		System.out.println("path:" + url.getPath());
		System.out.println("query:" + url.getQuery());
		
		List<String> li = new ArrayList<String>();
		li.add("a");
		li.add("23");
		li.add("sd");
		li.add("44");
		System.out.println("file:" + li);

	}
	
	public void add() {
		System.out.print("222");
		System.out.print("111");
	}

}

package com.od.service;

import java.net.URL;

public class URLParser {

	public static void main(String[] args) throws Exception {

		String str = "https://localhost:80/account/myfiles.do?query=abc";
		String str1 = "hello";
		URL url = new URL(str);

		System.out.println("path:" + url.getPath());
		System.out.println("path:" + url.getPath());
		System.out.println("path:" + url.getPath());
		System.out.println("query:" + url.getQuery());
		System.out.println("file:" + url.getFile());

	}

}

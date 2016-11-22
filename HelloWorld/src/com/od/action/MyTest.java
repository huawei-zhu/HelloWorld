package com.od.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.regexp.RE;

public class MyTest {

	public static final String EMAIL_MASK  = "^[_a-zA-Z0-9-']+(\\.|[_a-zA-Z0-9-']+)*@{1}[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$";
	
	public static final String EMAIL_MASK1 = "^[_a-z0-9-]+(\\.|[_a-z0-9-]+)*@{1}[a-z0-9-]+(\\.[a-z0-9-]+)$";

	public static void main(String[] args) {
		try {

			Pattern emailRE = Pattern.compile(EMAIL_MASK);
			String value = "bobjpac34.@suddenlink.com";
			
			Matcher matcher = emailRE.matcher(value);
			boolean results = matcher.find();
			System.out.println(results);
			
			RE emailRE1 = new RE(EMAIL_MASK);	
			results = emailRE1.match(value);
			System.out.println(results);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

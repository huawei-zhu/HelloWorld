package com.od.action;

import java.util.concurrent.TimeUnit;

public class DateDemo {

	public static void main(String[] args) {

		long expiryTime = System.currentTimeMillis() + 5 * 1000;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long diff = expiryTime - System.currentTimeMillis();
	
		System.out.println(diff);
	}

}

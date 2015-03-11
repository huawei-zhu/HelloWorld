package com.od.action;

public class IncAndDec {

	private static int a = 0;

	public static void main(String[] args) {
		IncAndDec id = new IncAndDec();
		for (int j = 0; j < 2; j++) {
			new Thread(id.new Inc()).start();
			new Thread(id.new Dec()).start();
		}
		System.out.println("finally results: " + a);
	}

	class Inc implements Runnable {

		public synchronized void run() {
			for (int i = 0; i < 10; i++) {
				a++;
				System.out.println("++" + a);
			}
		}
	}

	class Dec implements Runnable {

		public synchronized void run() {
			for (int i = 0; i < 10; i++) {
				a--;
				System.out.println("--" + a);
			}
		}
	}
}

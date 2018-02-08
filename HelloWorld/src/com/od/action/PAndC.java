package com.od.action;

public class PAndC {

	public static void main(String[] args) {
		System.out.println(1111);
		Runnable r = new Runnable() {
			
			public void run() {
				try {
					System.out.println(3333);
					Thread.sleep(2000);
					System.out.println(444);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(r).start();
		System.out.println(2222);
	}

}

package com.od.action;


interface Playable1 {

}

interface Bounceable1 {

}

public class CopyOfBall implements Playable1, Bounceable1 {
	
	private String myName;

	public static void main(String argc[]) {
		String s = new CopyOfBall().myName;
		CopyOfBall.class.getDeclaredFields()[0].getName();
		Playable1 c = new CopyOfBall();
		System.out.println(c instanceof CopyOfBall);
		System.out.println(c instanceof Playable1);
		System.out.println(c instanceof Bounceable1);
	}

}

package com.od.action;

interface Playable {
	void play();

	int i = 120;

	int in = 120;

}

interface Bounceable {
	void play();

	int i = 23;
}

class Actu {

}

abstract class absMethod extends Actu {
	abstract void method();

}

class A {
	protected int method1(int a, int b) {
		A aa = new A();
		aa.new B();
		return 0;
	}

	class B {
	}
	
}

interface Rollable extends Playable, Bounceable {
	Ball ball = new Ball("PingPang");
}

public class Ball implements Rollable {
	private String name;
	int i = 23;
	short s = 1;

	public Ball() {
	}

	public String getName() {
		s += 1;
		return name;
	}

	public Ball(String name) {
		this.name = name;
	}

	public static void main(String[] argc) {
		new Ball("").play();
	}

	public void play() {
		// ball = new Ball("Football");
		System.out.println(Playable.i);
		System.out.println(ball.getName());
	}
}

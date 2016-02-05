package com.od.action;

public class TestChild {

	public static void main(String argc[]) {
		new<String> ABC<String>().<String> getName();
	}

}

class ABC<T> {

	public <U extends T> ABC() {

	}

	public <U extends T> U getName() {
		U u = null;
		return u;
	}
}

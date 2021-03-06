package com.od.action;

public interface Digit {
	int getValue();
}

enum Decimal implements Digit {
	ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;

	private final int value;

	Decimal() {
		value = ordinal();
	}

	public int getValue() {
		return value;
	}
}

enum Hex implements Digit {
	A, B, C, D, E, F;

	private final int value;

	Hex() {
		value = 10 + ordinal();
	}

	public int getValue() {
		return value;
	}
}
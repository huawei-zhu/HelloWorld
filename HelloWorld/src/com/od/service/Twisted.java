package com.od.service;

public class Twisted {
	private final String name;

	Twisted(String name) {
		this.name = name;
	}

	private String name() {
		return name;
	}

	private void reproduce() {
		new Twisted("reproduce") {
			void printName() {
				System.out.println(super.equals(this));
				System.out.println(super.equals(Twisted.this));
				
				System.out.println(super.name());
			}
		}.printName();
		
		class Third extends Twisted {

			Third(String name) {
				super(name);
			}
			void printName() {
				System.out.println(super.name());
			}
		}
		Third third = new Third("third");
		third.printName();
	}

	public static void main(String[] args) {
		new Twisted("main").reproduce();
	}
}

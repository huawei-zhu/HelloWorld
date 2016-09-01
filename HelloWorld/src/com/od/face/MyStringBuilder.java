package com.od.face;


//java -Xms16m -Xmx32m com.od.face.MyStringBuilder
public class MyStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(16);

		System.out.println(sb.length());
		System.out.println("I will either reach here or die trying");
	}

}

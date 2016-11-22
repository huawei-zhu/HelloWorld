package com.od.face;

import org.apache.commons.lang3.StringUtils;


//java -Xms16m -Xmx32m com.od.face.MyStringBuilder
public class MyStringBuilder {

	public static void main(String[] args) {
		String s = null;
		if (StringUtils.isNotBlank(s)) {
			System.out.println(s.trim());
		}
		System.out.println("I will either reach here or die trying");
	}

}

package com.od.action;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		MapDemo md = new MapDemo();
		AA abc = new AA(md);
	}

}

class BB {
	
	public BB() {
		//String s = Thread.currentThread().getName() + "#" + serviceClass.getClass().getCanonicalName();
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println(ste[ste.length - 1].getClassName() +"#"+ ste[ste.length - 1].getMethodName());
	}
}

class AA {

	public AA(Object serviceClass) {
		new BB();
	}
}

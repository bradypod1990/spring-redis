package com.feng.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {

	private String s = "hello ";
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
//		Class c = Class.forName("com.feng.test.Test2");
//		Test2 c2 = (Test2) c.newInstance();
//		Method methods[]=c.getDeclaredMethods();
//		for(Method m: methods) {
////				m.invoke(c2);
//			System.out.println(m.getModifiers());
//		}
		Test3 t = new Test3();
		t.a(t.s);
		System.out.println(t.s);
	}
	
	public void a (String s) {
		s = "Hello world";
	}
}

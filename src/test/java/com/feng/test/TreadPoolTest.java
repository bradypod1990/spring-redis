package com.feng.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TreadPoolTest {

	
	@Test
	public void testgetCacheTreadPool() {
		ExecutorService es = Executors.newCachedThreadPool();
//		ExecutorService es = Executors.newFixedThreadPool(2);
//		es.execute(new MyTread());
		Runnable m = new MyTread();
		Thread t = new Thread(m);
		t.start();
		Map<String, String> map = new HashMap<String, String>();
	}	
	
	
	@Test
	public void test() {
//		Test4.parentStaticMethod();
//		Child.parentStaticMethod();
//		Child.childStaticMethod();
		int i =0 ;
		System.out.println(++i);
		Boolean flag = false;
		if (flag = true)
		{
		    System.out.println("true");
		}
		else
		{
		    System.out.println("false");
		}
		
		short a = 128;
		byte b = (byte)a;
		System.out.println(a);
		System.out.println(b);
		
	}
	
	@Test
	public void test1() throws Throwable {
		Class cl = Class.forName("com.feng.test.Test2");
		Object obj = cl.newInstance();
		Method[]    methods = cl.getDeclaredMethods();
		if(methods != null && methods.length > 0) {
			System.out.println(methods[0].getName());
			methods[0].invoke(obj);
		}
	}
}

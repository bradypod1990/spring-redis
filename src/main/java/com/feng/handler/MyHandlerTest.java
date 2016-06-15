package com.feng.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyHandlerTest {
	static{
		   int x=5;
		}
		static int x,y;
		
		public static void myMethod( ){
			  y=x++ + ++x;
			 }
	public static void main(String[] args) {
//		HandlerDao hd = new HandlerDaoImpl();
//		InvocationHandler ih = new MyHandler(hd);
//		
//		HandlerDao sub = (HandlerDao) Proxy.newProxyInstance(ih.getClass().getClassLoader(), hd.getClass().getInterfaces(), ih);
//		sub.say();
//		sub.speak("hello");
//		x--;String str2 = "he" + new String("llo");
//		   myMethod( );
//		   System.out.println(x+y+ ++x);
//		   System.out.println( x + ","  + y);
//		String a = "12-234adfs-2342-sdf13";
//		Pattern p = Pattern.compile("\\d*(?=-)");
//		Matcher m = p.matcher(a);
//		while(m.find()) {
//			System.out.println(m.group());
//		}
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		MyHandlerTest m = new MyHandlerTest();
		m.t(list);
		System.out.println(list.size());
	}
	
	public void t (List list) {
		list = new ArrayList();
		list.add(3);
	}
}

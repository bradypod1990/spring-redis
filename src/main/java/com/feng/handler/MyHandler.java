package com.feng.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{

	private Object hd;
	public MyHandler(Object hd) {
		this.hd = hd;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before handler-----");
		method.invoke(hd, args);
		System.out.println("after handler-----");
		return null;
	}

}

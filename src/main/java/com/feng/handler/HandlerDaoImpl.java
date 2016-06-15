package com.feng.handler;

public class HandlerDaoImpl implements HandlerDao {

	@Override
	public void say() {
		System.out.println("saying ");
	}

	@Override
	public void speak(String str) {
		System.out.println("speaking  " + str);
	}

}

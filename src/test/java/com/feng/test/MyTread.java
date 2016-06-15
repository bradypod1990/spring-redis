package com.feng.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyTread implements Runnable {

	@Override
	public void run() {
//		while (true) {
			for (int i = 0; i < 5; i++) {
				System.out.println("----------" + i);
				try {
					 TimeUnit.SECONDS.sleep(1);
//					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < 10; i++) {
				System.out.println("++++++++++++++++" + i);
				try {
					 TimeUnit.MINUTES.sleep(2);
//					Thread.sleep(1000 * 60 * 2L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}

	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
//		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new MyTread());
	}
}

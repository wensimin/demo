package com.demo;

public class VolatileExample {
	public static volatile Long count = 0L;

	public static void main(String[] args) throws InterruptedException {
		Thread a = getLambdaThread("a");
		Thread b = getLambdaThread("b");
		Thread c = getLambdaThread("c");
		Thread d = getLambdaThread("d");
		a.start();
		b.start();
		c.start();
		d.start();
		a.join();
		b.join();
		c.join();
		d.join();
		System.out.println("count :" + count);
	}

	public static Thread getLambdaThread(String name) {
		return new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				count++;
			}
		});
	}

	public static Thread getThread(String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					count++;
				}
			}
		});
	}
}

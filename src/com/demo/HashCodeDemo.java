package com.demo;

import com.demo.utils.TimeUtils;

public class HashCodeDemo {
	public static void main(String[] args) {
		Integer a = 1000000000;
		String b = "10";

		Long acount = TimeUtils.countNano(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				a.hashCode();
			}
		});
		Long bcount = TimeUtils.countNano(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				b.hashCode();
			}
		});
		System.out.println("a:" + acount);
		System.err.println("b:" + bcount);
	}

}

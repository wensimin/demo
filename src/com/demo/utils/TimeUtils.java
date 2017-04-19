package com.demo.utils;


public class TimeUtils {
	public static long countNano(TimeFunc time) {
		Long start = System.nanoTime();
		time.func();
		Long count = System.nanoTime() - start;
		return count;
	}
}

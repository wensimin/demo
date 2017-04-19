package com.demo;

import java.util.Arrays;

public class StringBoxDemo {
	public static void main(String[] args) {
		final char value[]=new char[]{'1','2'};
		System.out.println(Arrays.toString(value));
		value[0]='2';
		System.out.println(Arrays.toString(value));
	}
}

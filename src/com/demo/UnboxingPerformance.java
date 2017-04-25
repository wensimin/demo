package com.demo;

import com.demo.utils.TimeUtils;

public class UnboxingPerformance {
	public static void main(String[] args) {
		System.out.println("int time:"+TimeUtils.countNano(()->{
			for (int i = 0; i < Integer.MAX_VALUE; i++);
		}));
		System.out.println("Integer time:"+TimeUtils.countNano(()->{
			for (Integer i = 0; i < Integer.MAX_VALUE; i++);
		}));
	}
}

package com.demo;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String, String> hashMap=new HashMap<>();
		int i=0;
		while (++i>0) {
			hashMap.put(i+"", i+"");
		}
		
	}
}

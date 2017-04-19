package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.demo.utils.TimeUtils;

public class EachMapDemo {
	public static void main(String[] args) {
		Map<String, String> demoMap = new HashMap<>();
		System.out.println("init time:" + TimeUtils.countNano(() -> {
			int i = 0;
			while (++i < 10000000) {
				demoMap.put(Integer.toString(i), Integer.toString(i));
			}
		}));
		long time = TimeUtils.countNano(() -> {
			for (Entry<String, String> s : demoMap.entrySet()) {
				String key = s.getKey();
				String value = s.getValue();
				key.toString();
				value.toString();
			}
		});

		System.out.println("entry :" + time);

		time = TimeUtils.countNano(() -> {
			for (String s : demoMap.keySet()) {
				String key = s;
				String value = demoMap.get(s);
				key.toString();
				value.toString();
			}
		});

		System.out.println("key :" + time);
	}
}

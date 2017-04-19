package com.demo.constructorReferences;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface StrFunc {
	public void print(Object str);
}

public class Main {
	public static void main(String[] args) {
		StrFunc print = System.out::println;
		List<String> obj = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" });
		obj.stream().map(Integer::new).collect(Collectors.toList()).forEach(print::print);
	}
}

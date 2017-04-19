package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Demo {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("a_a");
		list.add("b_b");
		list.add("c_c");
		list.add("d_d");
		list=list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(list);
		swap(100, 1);
	}
	
	public static void swap(int a,int b){
		b=(a+b)-(a=b);
		System.out.println("a:"+a+" ,b:"+b);
	}
}

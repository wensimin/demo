package com.demo;

import java.util.Optional;

public class OptionalDemo {
	private class Car{
		String name;
	}
	private class Key{
		Car c;
	}
	public class User{
		Key k;
	}
	public static void main(String[] args) {
		OptionalDemo demo = new OptionalDemo();
		User u=demo.new User();
		System.out.println(Optional.ofNullable(u)
				.map(user->u.k)
				.map(k->k.c)
				.map(c->c.name).orElse("name"));
	}
}

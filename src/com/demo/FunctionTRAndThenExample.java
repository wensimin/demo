package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * function接口的使用
 * @author wensimin
 *
 */
public class FunctionTRAndThenExample {

	public static void main(String args[]) {
		// 定义function使获取name Employee - String
		Function<Employee, String> funcEmpToString = e -> e.getName();
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));
		// 定义function截取String 0,1
		Function<String, String> initialFunction = s -> s.substring(0, 1);
		// andThen 组合function
		List<String> empNameListInitials = convertEmpListToNamesList(employeeList,
				funcEmpToString.andThen(initialFunction));
		empNameListInitials.forEach(System.out::println);
	}

	public static List<String> convertEmpListToNamesList(List<Employee> employeeList,
			Function<Employee, String> funcEmpToString) {
		return employeeList.stream().map(funcEmpToString).collect(Collectors.toList());
	}
}

class Employee {
	private String name;

	public Employee(String name, int age) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
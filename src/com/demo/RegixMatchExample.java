package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配示例
 * 
 * @author wensimin
 *
 */
public class RegixMatchExample {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\$\\{(.+?)\\}");
		String s = "asaszujksa${1215},sizxuoh${1}。赛哦知${2}";
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
		}
	}
}

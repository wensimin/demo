package com.demo.dispatcher;

import java.util.List;
import java.util.Map;

public class Partner {
	private List<Type> type;
	private String area;
	private Map<Type, Integer> level;
	private Map<Type, Integer> number;
	private List<Request> requests;

	public List<Type> getType() {
		return type;
	}
	public void setType(List<Type> type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Map<Type, Integer> getLevel() {
		return level;
	}
	public void setLevel(Map<Type, Integer> level) {
		this.level = level;
	}
	public Map<Type, Integer> getNumber() {
		return number;
	}
	public void setNumber(Map<Type, Integer> number) {
		this.number = number;
	}
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
}

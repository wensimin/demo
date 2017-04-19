package com.demo.dispatcher;

import java.util.Date;

public class Request {
	private Type type;
	private String area;
	private Date date;
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}

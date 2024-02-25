package com.jdc.mkt;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private  boolean isMale;
	
	
	public Student(String name, int age, boolean isMale) {
		super();
		this.name = name;
		this.age = age;
		this.isMale = isMale;
	}
	public String getName() {
		return isMale?"Ko "+name:"Ma "+name;
	}
	public int getAge() {
		return age;
	}
	public boolean isMale() {
		return isMale;
	}
	
	
	
}

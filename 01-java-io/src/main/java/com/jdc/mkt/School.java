package com.jdc.mkt;

import java.io.Serializable;

public class School implements Serializable{

	private static final long serialVersionUID = 1L;
	private Student student;
	
	School(){}
	
	public School(Student student){
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}
}

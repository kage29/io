package com.jdc.mkt.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.Student;
import com.jdc.mkt.StudentService;

public class StudentTest {
	static StudentService service;
	
	@BeforeAll
	static void createFile() {
		 service = new StudentService();
	}

	@Test
	@Disabled
	void test() {
		
		service.addStudent();
		service.show();
		service.clear();
	}
	@ParameterizedTest
	@CsvSource("Aung Aung,20,true")
	void insertTest(String name,int age,boolean isMale)  {
		service.addStudent(new Student(name,age,isMale),new Student("sopheia", 12, false));
		service.show();
	}
}

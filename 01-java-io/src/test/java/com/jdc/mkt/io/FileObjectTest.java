package com.jdc.mkt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.School;
import com.jdc.mkt.Student;

public class FileObjectTest {

	static File file;	
	
	@BeforeAll
	 static void createFile() throws IOException {
		file = new File("test.obj");
		if (!file.exists()) {
			file.createNewFile();
			file.setReadOnly();
			
		}
	}

	@Test
	void testFileStream() throws IOException, ClassNotFoundException {
		writeFile();
		readFile();
	}

	private void readFile() throws IOException, ClassNotFoundException {
		file.setReadOnly();
		var in = new ObjectInputStream(new FileInputStream(file));
		
		School school = (School) in.readObject();
		System.out.println(school.getStudent().getName());
		in.close();
	}

	private void writeFile() throws IOException {
		file.setWritable(true);
		var out = new ObjectOutputStream(new FileOutputStream(file));
		
		var school = new School(new Student("Andrew",30,true));
		
		out.writeObject(school);
		out.close();
	}
}

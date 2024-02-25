package com.jdc.mkt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

	private File file;
	private List<Student> list;

	public StudentService() {
		file = new File("students.obj");
		list = new ArrayList<Student>();
		try {
			if (!file.exists()) {
				file.createNewFile();
			} else {
				clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addStudent(Student... s) {
		clear();
		list.addAll(List.of(s));
		writeStudent();
	}

	public void addStudent() {
		try (var read = new BufferedReader(new InputStreamReader(System.in))) {
			String str = null;
			do {
				System.out.println("Type student name !");
				String name = read.readLine();
				System.out.println("Type student age !");
				int age = Integer.parseInt(read.readLine());
				System.out.println("Type student is male !");
				boolean isMale = Boolean.parseBoolean(read.readLine());
				var student = new Student(name, age, isMale);
				list.add(student);
				System.out.println("Do you want to add student more y/other");
				str = read.readLine();

			} while ("y".equalsIgnoreCase(str));
			writeStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> readStudents() {
		clear();
		return list;

	}

	public void writeStudent() {
		try (var write = new ObjectOutputStream(new FileOutputStream(file))) {
			write.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void show() {
		for (Student s : readStudents()) {
			System.out.println("Name :%s\tAge :%s\ttype :%s".formatted(s.getName(), s.getAge(), s.isMale()));
		}
	}

	@SuppressWarnings("unchecked")
	public void clear() {
			try (var read = new ObjectInputStream(new FileInputStream(file))) {
				list.clear();
				List<Student> array = (ArrayList<Student>) read.readObject();
				list.addAll(array);

			} catch (Exception e) {
				System.out.println("Eof error :: " + e.getMessage());
			}
		

	}

	public void createNewFile() throws IOException {
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		}
	}

}

package com.jdc.mkt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileStreamTest {

	static File file;

	@BeforeAll
	static void createFile() throws IOException {
		file = new File("test.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	@Test
	void testFileStream() throws IOException {
		writeFile();
		readFile();
	}

	private void readFile() throws IOException {
		var in = new FileInputStream(file);
		int i = 0;
		while (-1 != (i = in.read())) {
			System.out.print((char)i);
		}
		in.close();
	}

	private void writeFile() throws IOException {
		var out = new FileOutputStream(file);
		String str = "Hello Java";
		char[] chars = str.toCharArray();
		for (char c : chars) {
			out.write((int) c);
		}
		out.close();
	}
}

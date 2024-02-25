package com.jdc.mkt.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileCharacterTest {

	static File file;

	@BeforeAll
	 static void createFile() throws IOException {
		file = new File("test.txt");
		if (!file.exists()) {
			file.createNewFile();
			file.setReadOnly();
			
		}
	}

	@Test
	void testFileStream() throws IOException {
		writeFile();
		readFile();
	}

	private void readFile() throws IOException {
		file.setReadOnly();
		var in = new FileReader(file);
		
		while(in.ready()) {
			System.out.print((char)in.read());
		}
		in.close();
	}

	private void writeFile() throws IOException {
		file.setWritable(true);
		var out = new FileWriter(file);
		String str = "Hello Java";
		out.write(str);
		out.close();
	}
}

package com.jdc.mkt.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileDataStreamTest {

	static File file;

	@BeforeAll
	 static void createFile() throws IOException {
		file = new File("test.dat");
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
		var in = new DataInputStream(new FileInputStream(file));
		
		System.out.println(in.readUTF());
		System.out.println(in.readInt());
		System.out.println(in.readBoolean());
		
		in.close();
	}

	private void writeFile() throws IOException {
		file.setWritable(true);
		var out = new DataOutputStream(new FileOutputStream(file));
		
		out.writeUTF("Hello");
		out.writeInt(30);
		out.writeBoolean(true);
		
		out.close();
	}
}

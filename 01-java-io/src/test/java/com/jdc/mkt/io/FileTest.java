package com.jdc.mkt.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	void fileCreate() throws IOException, URISyntaxException {
		var path = new File("/Users/MKT/Desktop/test/ioTest");	
		path.mkdirs();
		
		var file = new File(path,"test.txt");
			
		assertFalse(file.exists());
		file.createNewFile();
		assertTrue(file.exists());
		file.deleteOnExit();
		assertTrue(file.exists());
		
		assertEquals("test.txt", file.getName());
		assertEquals("/Users/MKT/Desktop/test/ioTest/test.txt", file.getAbsolutePath());
		assertEquals("/Users/MKT/Desktop/test/ioTest", file.getParent());
		
		assertTrue(path.isDirectory());
		assertTrue(file.isFile());
		
		assertTrue(file.canWrite());
		file.setReadOnly();
		assertFalse(file.canWrite());
		
		file.setReadable(false);
		assertFalse(file.canRead());
		file.setReadable(true);
		assertTrue(file.canRead());
		
		assertFalse(file.isHidden());
	}
}

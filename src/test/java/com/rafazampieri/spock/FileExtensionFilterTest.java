package com.rafazampieri.spock;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FileExtensionFilterTest {

	@Test
	public void filter() {
		List<File> fileList = Arrays.asList( 
			new File[]{ new File("a.jpg")
				, new File("b.png") , new File("c.gif")
				, new File("d.txt") , new File("e.jpeg")
			}
		);
		
		FileExtensionFilter filter = new FileExtensionFilter();
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		
		List<File> resultFileList = filter.filter(fileList);
		assertTrue(resultFileList.size() == 2);
		assertTrue(resultFileList.get(0).equals(new File("a.jpg")));
		assertTrue(resultFileList.get(1).equals(new File("e.jpeg")));
	}
	

}

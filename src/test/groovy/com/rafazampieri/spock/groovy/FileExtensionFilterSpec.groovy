package com.rafazampieri.spock.groovy

import spock.lang.Specification

class FileExtensionFilterSpec extends Specification{
	
	def "filter extension files jpg and jpeg"() {
		given: "init file List and add extension jpg and jpeg"
			def fileList = [
				new File("a.jpg"), new File("b.png") 
				, new File("c.gif"), new File("d.txt")
				, new File("e.jpeg")
			]
			FileExtensionFilter filter = new FileExtensionFilter();
			filter << "jpg";
			filter << "jpeg";
		
		when: "execute filter"
			List<File> resultFileList = filter.filter(fileList);
		
		then: "result in 2 files"
			resultFileList.size() == 2
			resultFileList.every{ file -> file.getName().endsWith("jpeg") || file.getName().endsWith("jpg") }
			resultFileList[0] == new File("a.jpg");
			resultFileList[1] == new File("e.jpeg");
	}
}

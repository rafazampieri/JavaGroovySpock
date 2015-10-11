package com.rafazampieri.spock;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExtensionFilter {
	
	private List<String> extensionList = new ArrayList<>();
	
	public void addExtension(String extension){
		extensionList.add(extension);
	}
	
	public List<File> filter(List<File> fileList){
		List<File> resultFileList = new ArrayList<>();
		for (File file : fileList) {
			for (String extension: extensionList) {
				if(file.getName().endsWith( "." + extension )){
					resultFileList.add(file);
					break;
				}
			}
		}
		return resultFileList;
	}

}

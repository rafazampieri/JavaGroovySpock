package com.rafazampieri.spock.groovy

import javax.swing.text.StyledEditorKit.ForegroundAction;

class FileExtensionFilter {
	
	def extensionList = new ArrayList<>();
	
	def addExtension(String extension){
		this << extension
	} 
	
	// add << for this class
	def leftShift(def extension){
		extensionList << extension
	}
	
	def filter(List<File> fileList){
		def resultFileList = fileList.findAll{ file ->
			extensionList.any{ file.getName().endsWith("." + it) }
		}
	}

}

package com.rafazampieri.spock.groovy

import groovy.json.JsonSlurper


class ReadFile {
	
	def readXML(File file){
		new XmlSlurper().parse( file )
	}
	
	def readJson(File file){
		new JsonSlurper().parse( file )
	}
	
	def readTXT(File file){
		file.text
	}

}

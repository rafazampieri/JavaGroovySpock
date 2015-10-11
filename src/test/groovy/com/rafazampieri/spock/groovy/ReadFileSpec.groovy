package com.rafazampieri.spock.groovy

import spock.lang.Specification;

class ReadFileSpec extends Specification{
	
	def "Read XML File"(){
		given: 
			def readFile = new ReadFile()
			
		when: 
			def result = readFile.readXML(new File("src/test/resources/groovy/readFile/file.xml"))
		
		then:
			result.department.size() ==1
			result.department.@name =="sales"
			result.department.employee.size() ==2
			result.department.employee[0].firstName =="Orlando"
			result.department.employee[1].firstName =="Diana"
	}
	
	def "Read JSON File"(){
		given:
			def readFile = new ReadFile()
			
		when:
			def result = readFile.readJson(new File("src/test/resources/groovy/readFile/file.json"))
		
		then: "Department have name and employee"
			result.staff.department.size() ==2
			
		and:
			result.staff.department.name == "sales"
			result.staff.department.employeeList.size() == 2
			result.staff.department.employeeList[0].firstName == "Orlando"
			result.staff.department.employeeList[1].firstName == "Diana"
	}

}

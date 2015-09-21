package com.rafazampieri.spock

import spock.lang.Specification;

class AdderSpec extends Specification{

	def "Adding two numbers to return the sum"() {
		when: "a new Adder class is created"
			def adder = new Adder();
			
		then: "1 plus 1 is 2"
			adder.add(1, 1) == 2
	}
}

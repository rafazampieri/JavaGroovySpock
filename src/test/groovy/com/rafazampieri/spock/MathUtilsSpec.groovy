package com.rafazampieri.spock

import spock.lang.Specification;

class MathUtilsSpec extends Specification{

	def "Adding two numbers to return the sum"() {
		when: "a new MathUtils class is created"
			def mathUtils = new MathUtils();
			
		then: "1 plus 1 is 2"
			mathUtils.add(1, 1) == 2
	}
	
	def "Adding two numbers to return the sum with Parameterized tests"() {
		when: "a new MathUtils class is created"
			def mathUtils = new MathUtils();
	
		then: "1 plus 1 is 2"
			mathUtils.add(a, b) == expected
			
		where: "value A and B with expected result"
			a | b | expected
			1 | 2 | 3
			5 | 6 | 11
	}
}

package com.rafazampieri.spock.algorithm

import spock.lang.Specification;

class SquareAlgSpec extends Specification{
	
	def "teste count perfect square"(){
		given:
			def intMapList = [[a: 3, b: 9], [a: 17, b: 24]]
			
		when:
			def squareAlg = new SquareAlg()
		
		then:
			squareAlg.countPerfectSquareInRange(intMapList[0].a, intMapList[0].b) == 2
			
		and:
			squareAlg.countPerfectSquareInRange(intMapList[1].a, intMapList[1].b) == 0
	}

}

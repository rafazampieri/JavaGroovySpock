package com.rafazampieri.spock.print

import java.security.cert.Extension;

import com.rafazampieri.spock.print.PrintServer.PrintResult;
import com.rafazampieri.spock.print.PrintServer.PrintStatusEnum;

import spock.lang.Specification;


class PrintServerSpec extends Specification {

	def "fake printer"(){
		given: "Init PrintServer and register a Stub Printer"
			String printText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			String expectedErrorDescription = "Unknown error."
			
			Printer printer = Stub(Printer)
			printer.print(printText) >>> [true, false]
			printer.getErrorDescription() >>> [expectedErrorDescription]
			
			def printLogger = Mock(PrintLogger)
			def printServer = new PrintServer( printLogger )
			printServer.register(printer)
			
		when: "print text with success and other with error"
			def result1 = printServer.print(printer, printText)
			def result2 = printServer.print(printer, printText)
			
		then: "print log execute one time"
			result1.status == PrintStatusEnum.SUCCESS	
			result2.status == PrintStatusEnum.ERROR	
			result2.getErrorDescription() == expectedErrorDescription
			1 * printLogger.log(printer, printText)
	}
}

package com.rafazampieri.spock.print;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rafazampieri.spock.print.PrintServer.PrintResult;
import com.rafazampieri.spock.print.PrintServer.PrintStatusEnum;

import static org.mockito.Mockito.*;

public class PrintServerTest {
	
	@Test
	public void printText(){
		String printText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
		String expectedErrorDescription = "Unknown error.";
		
		PrintLogger printLogger = mock(PrintLogger.class);
		Printer printer = mock(Printer.class);
		when(printer.print(printText)).thenReturn(new Boolean(true), new Boolean(false));
		when(printer.getErrorDescription()).thenReturn(expectedErrorDescription);
		PrintServer printServer = new PrintServer(printLogger);
		printServer.register(printer);
		
		PrintResult result1 = printServer.print(printer, printText);
		PrintResult result2 = printServer.print(printer, printText);
		
		assertTrue(result1.getStatus() == PrintStatusEnum.SUCCESS);
		assertTrue(result2.getStatus() == PrintStatusEnum.ERROR);
		assertTrue(result2.getErrorDescription() == expectedErrorDescription);
		verify(printLogger, times(1)).log(printer, printText);
	}
}

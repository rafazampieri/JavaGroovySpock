package com.rafazampieri.spock.print;

import java.util.ArrayList;
import java.util.List;

public class PrintServer {
	
	private PrintLogger printLogger;
	private List<Printer> printers = new ArrayList<>();
	
	public PrintServer(PrintLogger printLogger){
		this.printLogger = printLogger;
	}
	
	public void register(Printer printer){
		printers.add(printer);
	}
	
	public List<Printer> getPrinters(){
		return printers;
	}
	
	public PrintResult print(Printer printer, String text){
		PrintResult result = new PrintResult();
		if( printers.contains(printer) ){
			if( printer.print(text) ){
				result.status = PrintStatusEnum.SUCCESS;
				printLogger.log(printer, text);
			} else {
				result.status = PrintStatusEnum.ERROR;
				result.errorDescription = printer.getErrorDescription();
			}
		} else {
			result.status = PrintStatusEnum.PRINT_NOT_FOUND;
		}
		
		return result;
	}
	
	/* inner class */
	
	public class PrintResult{
		private PrintStatusEnum status;
		private String errorDescription;
		
		public PrintStatusEnum getStatus() {
			return status;
		}
		public String getErrorDescription() {
			return errorDescription;
		}
	}
	public enum PrintStatusEnum{
		SUCCESS, ERROR, PRINT_NOT_FOUND;
	}
}


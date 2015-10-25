package com.rafazampieri.spock.print;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintLogger {
	
	private Map<Printer, List<PrintLog>> logs = new HashMap<>();
	
	public void log(Printer printer, String text){
		List<PrintLog> printLogs = logs.containsKey(printer) ? logs.get(printer) : new ArrayList<PrintLog>();
		printLogs.add( new PrintLog(text) );
	}
	
	public List<PrintLog> getLog(Printer printer){
		if( logs.containsKey(printer) ){
			List<PrintLog> printLogs = new ArrayList<PrintLog>();
			for (PrintLog printLog : logs.get(printer)) {
				printLogs.add(printLog);
			}
			return printLogs;
		} else {
			return new ArrayList<PrintLog>();
		}
	}
	
	public Map<Printer, List<PrintLog>> getLogs() {
		return logs;
	}

	public class PrintLog{
		String text;
		Date printDate = new Date();
		
		public PrintLog(String text) {
			this.text = text;
		}
		public String getText() {
			return text;
		}
		public Date getPrintDate() {
			return printDate;
		}
	}
}

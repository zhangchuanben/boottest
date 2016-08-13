package com.ben.thread;


public class AsyncReaderSocket extends Thread{
	private StringBuffer result;

	public AsyncReaderSocket(String host, int port) {
	}
	
	public void run() {
		
	}
	
	public String getResult() {
		String reader = Thread.currentThread().getName();
		if (reader.startsWith("Reader")) {
			String retval = result.toString();
			result = new StringBuffer();
			return retval;
		} else {
			return "";
		}
	}
	
}

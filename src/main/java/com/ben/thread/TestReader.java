package com.ben.thread;

public class TestReader extends Thread{
	private AsyncReaderSocket ars;
	public static void main(String[] args) {
		AsyncReaderSocket readerSocket = new AsyncReaderSocket("myhost", 8080);
		readerSocket.start();
		new TestReader(readerSocket).start();
	}
	
	
	public TestReader(AsyncReaderSocket ars) {
		super("ReaderThread");
		this.ars = ars;
	}


	@Override
	public void run() {
		System.out.println("Data is "+ ars.getResult());
	}

}

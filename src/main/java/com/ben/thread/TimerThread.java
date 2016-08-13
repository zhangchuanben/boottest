package com.ben.thread;

import java.awt.Component;

public class TimerThread extends Thread{
	private Component comp;
	private int timediff;
	volatile boolean shouldRun;
	
	
	public TimerThread(Component comp, int timediff) {
		this.comp = comp;
		this.timediff = timediff;
		this.shouldRun = true;
		setName("TimerThread("+timediff+" millseconds)");
	}


	@Override
	public void run() {
		while (shouldRun) {
			try {
				comp.repaint();
				sleep(timediff);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

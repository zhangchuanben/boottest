package com.ben.thread;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

public class Animate extends Applet {

	private static final long serialVersionUID = 1L;
	private int count, lastcount;
	private Image[] pictures;
	private TimerThread timer;
	@Override
	public void init() {
		lastcount = 10;
		count = 0;
		pictures = new Image[10];
		MediaTracker tracker = new MediaTracker(this);
		for (int a = 0; a < lastcount; a++) {
			pictures[a] = getImage(getCodeBase(), new Integer(a).toString()+".jpg");
			tracker.addImage(pictures[a], 0);
		}
		tracker.checkAll(true);
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(pictures[count++], 0, 0, null);
		if (count == lastcount) {
			count = 0;
		}
	}
	
	public void start() {
		if (timer == null)
			timer = new TimerThread(this, 2000);
		timer.start();
	}
	
	public void stop () {
		timer.shouldRun = false;
		try {
			timer.join();
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//timer = null;
	}
	
	public void printThreads () {
		Thread[] threads = new Thread[Thread.activeCount()];
		int n = Thread.enumerate(threads);
		for (Thread thread : threads) {
			System.out.println("Thread name is "+thread.getName());
		}
	}
	
}

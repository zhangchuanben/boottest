package com.ben.thread;

import com.ben.thread.annotations.GuardedBy;
import com.ben.thread.annotations.ThreadSafe;

@ThreadSafe
public class PrivateLock {
	@GuardedBy("this")
	private final Object myLock = new Object();
	public void test() {
		synchronized (myLock) {
			
		}
	}
}

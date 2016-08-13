package com.ben.thread;

import com.ben.thread.annotations.Immutable;

@Immutable
public class Point {
	public final int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

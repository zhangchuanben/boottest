package com.ben.thread;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.ben.thread.annotations.ThreadSafe;

@ThreadSafe
public class DelegatingVerhicleTracer {
	private final ConcurrentMap<String, Point> locations;
	private final Map<String, Point> unmodifiableMap;
	public DelegatingVerhicleTracer() {
		locations = new ConcurrentHashMap<String, Point>();
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	
	public Map<String, Point> getLocations() {
		return unmodifiableMap;
	}
	
	public Point getLocation(String id) {
		return locations.get(id);
	}
	
	public void setLocation (String id, int x, int y) {
		if (locations.replace(id, new Point(x, y)) == null) {
			throw new IllegalArgumentException("invalid vehicle name:"+id);
		}
	}
}

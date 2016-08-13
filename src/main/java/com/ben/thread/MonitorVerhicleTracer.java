package com.ben.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.ben.thread.annotations.ThreadSafe;

@ThreadSafe
public class MonitorVerhicleTracer {
	private final Map<String, MutablePoint> locations;

	public MonitorVerhicleTracer(Map<String, MutablePoint> locations) {
		super();
		this.locations = locations;
	}
	public synchronized Map<String, MutablePoint> getLocations() {
		return deepCopy(locations);
	}
	private Map<String, MutablePoint> deepCopy(
			Map<String, MutablePoint> locations) {
		Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();
		for (String id : locations.keySet()) {
			result.put(id, new MutablePoint(locations.get(id)));
		}
		return Collections.unmodifiableMap(result);
	}
	
	public synchronized MutablePoint getLocation(String id) {
		MutablePoint loc = locations.get(id);
		return loc == null ? null : new MutablePoint(loc);
	}
	
	public synchronized void setLocation (String id, int x, int y) {
		MutablePoint loc = locations.get(id);
		if (loc == null) {
			throw new IllegalArgumentException("No such ID:"+id);
		}
		loc.x = x;
		loc.y = y;
	}
}

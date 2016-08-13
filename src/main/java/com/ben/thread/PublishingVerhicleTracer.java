package com.ben.thread;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ben.thread.annotations.ThreadSafe;

@ThreadSafe
public class PublishingVerhicleTracer {
	private final Map<String, SafePoint> locations;
	private final Map<String, SafePoint> unmodifiableMap;
	public PublishingVerhicleTracer(Map<String, SafePoint> locations) {
		super();
		this.locations = new ConcurrentHashMap<String, SafePoint>(locations);
		this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
	}
	public Map<String, SafePoint> getLocations() {
		return unmodifiableMap;
	}
	
	public SafePoint getLocation(String id) {
		return locations.get(id);
	}
	
	public void setLocation(String id , int x, int y) {
		if (!locations.containsKey(id)) {
			throw new IllegalArgumentException("invalid verhicle name:"+id);
		}
		locations.put(id, new SafePoint(x, y));
	}
	
}

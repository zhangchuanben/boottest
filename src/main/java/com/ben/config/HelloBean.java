package com.ben.config;

import org.springframework.stereotype.Component;

@Component("helloWorld")
public class HelloBean {
	private String name;

	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

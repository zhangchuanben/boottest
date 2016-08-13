package com.ben.config;

import org.springframework.stereotype.Component;

@Component("helloWorld")
public class HelloBean {
	private String name;

	public String getName() {
		System.out.println("Step1 Branch Only");
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package com.ben.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="config", locations="classpath:config/config.properties")
public class Config {
	private String firstName;
	private String secondName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	@Override
	public String toString() {
		return "Config [firstName=" + firstName + ", secondName=" + secondName
				+ "]";
	}
	
	
}

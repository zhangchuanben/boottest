package com.ben.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	@Bean(name="helloWorld")
	public HelloBean helloBean() {
		return new HelloBean();
	}
}

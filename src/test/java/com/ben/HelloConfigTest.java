package com.ben;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ben.config.HelloBean;



public class HelloConfigTest extends AbstractTest{
	@Autowired
	@Qualifier("helloWorld")
	private HelloBean hello;
	
	@Test
	public void testHello() {
		hello.setName("hello");
		assertEquals("hello", hello.getName());
	}
}

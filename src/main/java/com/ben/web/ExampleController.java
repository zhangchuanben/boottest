package com.ben.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ben.domain.Config;
import com.ben.service.AccountService;

@Controller
@ConfigurationProperties(prefix="my")
public class ExampleController {
	@Autowired
	private AccountService accountService;
	@Value("${name}")
	private String name;
	@Value("${app.description}")
	private String application;
	private List<String> servers;
	@Autowired
	private Config config;
	
	@RequestMapping("/")
	public String home() {
		return "hello.html";
	}
	
	@RequestMapping("/sayHello")
	public Config sayHello() {
		accountService.sayHello();
		System.out.println(application);
		System.out.println(getServers());
		System.out.println(name);
		return config;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}
}

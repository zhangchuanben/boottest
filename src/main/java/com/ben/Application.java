package com.ben;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("test")
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		//app.setBannerMode(Banner.Mode.OFF);
		System.out.println(System.getProperties());
		app.setWebEnvironment(true);
		app.run(args);
	}
}

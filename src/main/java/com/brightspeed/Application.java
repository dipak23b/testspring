package com.brightspeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.brightspeed"})
public class Application {

	public static void main(String[] args) {
		loadSystemProperties();
		SpringApplication.run(Application.class, args);
	}

	private static void loadSystemProperties() {
		System.setProperty("spring.config.location", "opt/etc/config/");
		System.setProperty("spring.config.name", "application");
	}

}

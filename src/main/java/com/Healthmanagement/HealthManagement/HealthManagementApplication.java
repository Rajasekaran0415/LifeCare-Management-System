package com.Healthmanagement.HealthManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthManagementApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "true");
		SpringApplication.run(HealthManagementApplication.class, args);
	}

}

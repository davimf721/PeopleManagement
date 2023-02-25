package com.peopleManagement.davi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaviApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaviApplication.class, args);

		System.out.println("Server is running at the port: 8080");
	}

}

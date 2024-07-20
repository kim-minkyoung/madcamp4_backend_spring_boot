package com.example.madcamp4_backend.madcamp4_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@SpringBootApplication
public class Madcamp4BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Madcamp4BackendApplication.class, args);
	}
}

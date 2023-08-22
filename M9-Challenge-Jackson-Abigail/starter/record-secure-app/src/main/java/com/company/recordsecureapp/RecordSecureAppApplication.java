package com.company.recordsecureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class RecordSecureAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordSecureAppApplication.class, args);
	}

}

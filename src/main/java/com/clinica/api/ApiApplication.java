package com.clinica.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.clinica.api.datasource.model")
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {SpringApplication.run(ApiApplication.class, args);
	}

}

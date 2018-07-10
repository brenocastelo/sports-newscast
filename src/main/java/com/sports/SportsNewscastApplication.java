package com.sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class SportsNewscastApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsNewscastApplication.class, args);
	}
	
	@Bean
	LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}

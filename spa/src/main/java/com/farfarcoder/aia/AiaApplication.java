package com.farfarcoder.aia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiaApplication.class, args);
	}

	@org.springframework.context.annotation.Bean
	public org.springframework.boot.CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("hello java springboot 3.5.9 java21");
		};
	}

}

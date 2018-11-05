package com.i3.i3dbservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class I3DbServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(I3DbServicesApplication.class, args);
	}
}

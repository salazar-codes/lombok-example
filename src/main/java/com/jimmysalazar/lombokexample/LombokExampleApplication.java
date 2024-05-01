package com.jimmysalazar.lombokexample;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LombokExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(LombokExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LombokExampleApplication.class, args);

		valAndVar();
	}

	public static void valAndVar() {
		/*
		 * Usar val y var de lombok permite mantener versiones antiguas de Java <10
		 * */

		// final String username = "@salazar.codes";
		val username = "@salazar.codes"; // infiere el tipo y variable constante
		var profile = "Software developer";

		log.info("Username {} of type {}", username, username.getClass().getName());
		log.info("Profile: {} of type {}", profile, profile.getClass().getName());

		profile = "Azure developer"; // Permite modificar el valor, más no el tipo
		log.info("Profile: {} of type {}", profile, profile.getClass().getName());
	}
}

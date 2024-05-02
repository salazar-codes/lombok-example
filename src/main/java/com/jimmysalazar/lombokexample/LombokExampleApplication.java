package com.jimmysalazar.lombokexample;

import com.jimmysalazar.lombokexample.model.Person;
import com.jimmysalazar.lombokexample.model.TwitterAccount;
import com.jimmysalazar.lombokexample.service.FileManager;
import lombok.Cleanup;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LombokExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(LombokExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LombokExampleApplication.class, args);


	}

	public static void nonNull() {
		// TwitterAccount account = new TwitterAccount("salazar.codes");
		TwitterAccount account = new TwitterAccount(null);
		log.info("Account {}",account);
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

	public static void cleanUpExample() throws IOException {
		/*
		// try-with-resources llama automaticamente al close
		try (FileManager writer = new FileManager();) {
			writer.write("Good morning!","example.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		*/

		//Con Lombok
		//@Cleanup
		@Cleanup("releaseResources")
		FileManager writer = new FileManager();
		writer.write("Good morning!","example.txt");
	}

	public static void getterAndSetterExample() {
		Person p = new Person();
		p.setAlive(true);
		p.setName("Jimmy");
		p.setLastname("Salazar");
		p.foo();

		log.info("Name {} lastname {} isAlive {}",p.getName(), p.getLastname(), p.isAlive());
	}
}

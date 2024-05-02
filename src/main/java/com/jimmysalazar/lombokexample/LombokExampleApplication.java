package com.jimmysalazar.lombokexample;

import com.jimmysalazar.lombokexample.file.FileManager;
import com.jimmysalazar.lombokexample.model.*;
import com.jimmysalazar.lombokexample.service.ConfigService;
import com.jimmysalazar.lombokexample.service.FileManagerService;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class LombokExampleApplication {

	//private static final Logger log = LoggerFactory.getLogger(LombokExampleApplication.class);

	public static void main(String[] args){
		SpringApplication.run(LombokExampleApplication.class, args);

		//toStringExample();
		//equalsAndHashCodeExample();
		//equalsAndHashCodeWithSuperExample();
		//constructorExample();
		//dataExample();
		//valueExample();
		//builderExample();
		//sneakyThrowsExample();
		//withExample();
		getLazyExample();
	}

	private static void getLazyExample() {
		ConfigService service = new ConfigService();
		String config = service.getConfiguration();
		log.info("Config {}",config);
	}

	private static void withExample() {
		Point p = new Point(10.0f, 20.0f);
		Point p2 = p
				.withY(50.0f) // Clona el objeto solo cambiando el valor del with
				.withX(14.5f);

		log.info("Info point {}",p);
		log.info("Info point 2 {}",p2);
	}

	private static void sneakyThrowsExample(){
		FileManager.createFiles("src/main/resources/test1.properties", "src/main/resources/test2.properties");
	}

	private static void builderExample() {
		// Employee em = new Employee(12,"salazar","jimmy",12.40f, Arrays.asList("méxico"),EmployeeType.EMPLOYEE);
		Employee em = Employee.builder()
				.id(10)
				.name("Jimmy")
				.lastName("Salazar")
				.salary(25.50f)
				.address("Peru")
				.address("Chile")
				//.addresses(Arrays.asList("Perú","Chile"))
				//.employeeType(EmployeeType.EMPLOYEE)
				.build();

		log.info(em.toString());
	}

	public static void valueExample() {
		// Value aparte de permite crear objetos inicializados, los crea de forma final. Inmutable
		Permission permission = new Permission(10,"create",LocalDateTime.now());
		log.info("Permission {}", permission.toString());
	}

	public static void dataExample() {
		Rol rol = new Rol(12);
		rol.setName("ADMIN");
		rol.setCreateTs(LocalDateTime.now());

		log.info("Rol name {}",rol.getName());
		log.info("Rol hashcode {}",rol.hashCode());
		log.info("Rol full info {}",rol.toString());
	}

	private static void constructorExample() {
		User user = new User(10,"hey","qfue","");
		User user2 = new User();
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
		FileManagerService writer = new FileManagerService();
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

	public static void toStringExample() {
		User u = new User();
		u.setId(2);
		u.setUsername("eldev");
		u.setRole("admin");
		u.setPassword("1al6");

		log.info("User {}", u.toString());
	}

	public static void equalsAndHashCodeExample() {
		User u = new User();
		u.setId(2);
		u.setUsername("eldev");
		u.setRole("admin");
		u.setPassword("1al6s");

		User u2 = new User();
		u2.setId(2);
		u2.setUsername("eldev");
		u2.setRole("admin");
		u2.setPassword("1al6");

		// Todos los campos deben ser iguales
		log.info("Equals {}", u.equals(u2));
	}

	public static void equalsAndHashCodeWithSuperExample() {
		UserEmployee u = new UserEmployee();
		u.setId(2);
		u.setUsername("eldev");
		u.setRole("admin");
		u.setPassword("1al6s");
		u.setEmployeeId(123);
		u.setType(EmployeeType.VENDOR);

		UserEmployee u2 = new UserEmployee();
		u2.setId(2);
		u2.setUsername("eldev");
		u2.setRole("customer");
		u2.setPassword("12345");
		u2.setEmployeeId(123);
		u.setType(EmployeeType.EMPLOYEE);

		log.info("Equals {}", u.equals(u2));
	}
}

package io.github.aniket2814.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the CRUD Demo Application.
 * 
 * <p>
 * This project demonstrates basic CRUD operations using Spring Boot, Spring
 * Data JPA, and a relational database.
 * </p>
 *
 * <p>
 * Features included:
 * <ul>
 * <li>Spring Boot auto-configuration</li>
 * <li>Spring Data JPA integration</li>
 * <li>RESTful APIs for CRUD operations</li>
 * </ul>
 * </p>
 * 
 * @author Aniket Rathore
 * @since 2025
 */
@SpringBootApplication
public class CrudDemoApplication {

	/**
	 * Bootstraps the Spring Boot application.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
}

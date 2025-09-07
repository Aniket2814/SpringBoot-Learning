package io.github.aniket2814.cruddemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.github.aniket2814.cruddemo.auth.AuditorAwareImpl;

/**
 * Application-level configuration class.
 *
 * <p>
 * This class holds common Spring beans and configurations required across the
 * entire application.
 * </p>
 *
 * Features:
 * <ul>
 * <li>Registers {@link ModelMapper} as a bean for DTO ↔ Entity mapping</li>
 * <li>Enables JPA Auditing and provides custom {@link AuditorAware}
 * implementation</li>
 * </ul>
 *
 * @author Aniket rathore
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl")
// Enables Spring Data JPA Auditing with custom AuditorAware
public class AppConfig {

	/**
	 * Provides a singleton {@link ModelMapper} bean.
	 * 
	 * <p>
	 * ModelMapper is used to automatically map between DTOs and Entities. Example:
	 * converting PostEntity → PostDTO and vice versa.
	 * </p>
	 *
	 * @return a new ModelMapper instance
	 */
	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	/**
	 * Provides an {@link AuditorAware} implementation.
	 * 
	 * <p>
	 * This tells Spring Data JPA how to fetch the current user for auditing fields
	 * like createdBy and updatedBy. Currently, it returns a hardcoded username
	 * ("Aniket Rathore"). In future, it can be integrated with Spring Security.
	 * </p>
	 *
	 * @return an AuditorAware<String> implementation
	 */
	@Bean
	AuditorAware<String> getAuditorAwareImpl() {
		return new AuditorAwareImpl();
	}
}

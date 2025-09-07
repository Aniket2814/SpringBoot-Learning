package io.github.aniket2814.cruddemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application-level configuration class.
 * 
 * <p>
 * This class defines Spring beans that are required across the application,
 * such as the {@link ModelMapper} used for object mapping.
 * </p>
 * 
 * author: Aniket Rathore since: 2025
 */
@Configuration
public class AppConfig {

	/**
	 * Provides a singleton {@link ModelMapper} bean.
	 * 
	 * <p>
	 * ModelMapper simplifies the process of mapping between DTOs and entity
	 * classes.
	 * </p>
	 *
	 * @return a ModelMapper instance
	 */
	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}

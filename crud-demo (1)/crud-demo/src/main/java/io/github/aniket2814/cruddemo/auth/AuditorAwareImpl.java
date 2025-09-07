package io.github.aniket2814.cruddemo.auth;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * Custom implementation of AuditorAware<String>.
 * 
 * This class tells Spring Data JPA who the current auditor is (i.e., which user
 * performed the action).
 * 
 * Used together with @CreatedBy and @LastModifiedBy annotations to
 * automatically capture the username of the logged-in user.
 * 
 * For now, returning a hardcoded username "Aniket Rathore", but later this can
 * be integrated with Spring Security to get the actual logged-in user's name
 * from SecurityContext.
 * 
 * Example usage in Entity:
 * 
 * @CreatedBy private String createdBy;
 *
 * @LastModifiedBy private String modifiedBy;
 * 
 * @author Aniket Rathore
 */
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO: In real-world applications:
		// 1. Fetch SecurityContext
		// 2. Extract Authentication object
		// 3. Get Principal (the logged-in user)
		// 4. Return the username or userId

		// Currently returning hardcoded user for demo purposes
		return Optional.of("Aniket Rathore");
	}
}

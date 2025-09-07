package io.github.aniket2814.cruddemo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.aniket2814.cruddemo.exceptions.ResourceNotFoundException;

/**
 * Global exception handler for the CRUD Demo application.
 * 
 * <p>
 * This class ensures that all exceptions are handled consistently across REST
 * controllers. It returns a standardized error response using {@link ApiError}.
 * </p>
 * 
 * author: Aniket Rathore since: 2025
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles {@link ResourceNotFoundException} when a requested resource is not
	 * found.
	 *
	 * @param exception the thrown ResourceNotFoundException
	 * @return ResponseEntity containing ApiError with NOT_FOUND status
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException exception) {
		ApiError apiError = new ApiError(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
}

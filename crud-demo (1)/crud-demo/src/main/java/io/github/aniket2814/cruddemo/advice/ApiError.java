package io.github.aniket2814.cruddemo.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * Represents a standardized error response returned by the API. Contains
 * details like timestamp, error message, and HTTP status code.
 * 
 * Used in global exception handling to provide consistent error responses.
 * 
 * author: Aniket Rathore since: 2025
 */
@Data
public class ApiError {

	/** The time when the error occurred */
	private LocalDateTime timeStamp;

	/** A human-readable error message */
	private String error;

	/** The HTTP status code associated with the error */
	private HttpStatus statusCode;

	/**
	 * Constructor to create an ApiError with error message and status code.
	 * Automatically sets the current timestamp.
	 *
	 * @param error      the error message
	 * @param statusCode the HTTP status
	 */
	public ApiError(String error, HttpStatus statusCode) {
		this.error = error;
		this.statusCode = statusCode;
		this.timeStamp = LocalDateTime.now();
	}

	/**
	 * Default constructor which sets the current timestamp.
	 */
	public ApiError() {
		this.timeStamp = LocalDateTime.now();
	}
}

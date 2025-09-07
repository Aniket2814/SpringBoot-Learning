package io.github.aniket2814.cruddemo.exceptions;

/**
 * Custom exception class used to handle scenarios where a requested resource is
 * not found in the application.
 *
 * <p>
 * Extends {@link RuntimeException} so it can be thrown during runtime without
 * mandatory try-catch.
 * </p>
 *
 * Example usage:
 * 
 * <pre>
 * throw new ResourceNotFoundException("Post not found with ID: " + id);
 * </pre>
 *
 * @author Aniket Rathore
 */
public class ResourceNotFoundException extends RuntimeException {

	/** Serial version UID for ensuring compatibility during serialization. */
	private static final long serialVersionUID = -7177144553548829591L;

	/** Default constructor. */
	public ResourceNotFoundException() {
		super();
	}

	/**
	 * Constructor with custom error message.
	 *
	 * @param message the detail message to describe the exception
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
}

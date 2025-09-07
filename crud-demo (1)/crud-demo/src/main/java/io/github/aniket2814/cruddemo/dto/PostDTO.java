package io.github.aniket2814.cruddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for transferring Post data between layers (e.g.,
 * Controller ↔ Service).
 *
 * <p>
 * Contains only the fields required for client-server communication, without
 * exposing the entity directly.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	/** Title of the post */
	private String title;

	/** Description/content of the post */
	private String description;
}

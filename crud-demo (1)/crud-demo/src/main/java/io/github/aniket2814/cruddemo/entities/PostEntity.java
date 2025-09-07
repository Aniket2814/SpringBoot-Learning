package io.github.aniket2814.cruddemo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class that represents the "posts" table in the database.
 *
 * <p>
 * Each instance of this class corresponds to a record in the "posts" table.
 * </p>
 */
@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostEntity extends AuditableEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1459230983226638448L;

	/** Unique identifier for each post (Primary Key). */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Title of the post. */
	private String title;

	/** Description/content of the post. */
	private String description;
}

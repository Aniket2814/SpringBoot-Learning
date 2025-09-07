package io.github.aniket2814.cruddemo.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Base class for auditing entity fields.
 * 
 * Any entity extending this class will automatically have createdDate,
 * updatedDate, createdBy, and updatedBy fields.
 * 
 * This uses Spring Data JPA Auditing.
 * 
 * How it works: - @CreatedDate: Stores timestamp when entity is created
 * - @LastModifiedDate: Stores timestamp when entity is last updated
 * - @CreatedBy: Stores the username/id of creator - @LastModifiedBy: Stores the
 * username/id of last modifier
 * 
 * To enable auditing: - Add @EnableJpaAuditing in your main application class -
 * Provide AuditorAware implementation (e.g., AuditorAwareImpl)
 * 
 * Example: public class PostEntity extends AuditableEntity { private String
 * title; private String content; }
 * 
 * @author: Aniket Rathore
 */
@MappedSuperclass // Makes this class a parent for other entities
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class) // Enables auditing on this entity
public class AuditableEntity {

	/** Timestamp when the entity was first created */
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdDate;

	/** Timestamp when the entity was last updated */
	@LastModifiedDate
	private LocalDateTime updatedDate;

	/** Username/Id of the user who created this record */
	@CreatedBy
	private String createdBy;

	/** Username/Id of the user who last updated this record */
	@LastModifiedBy
	private String updatedBy;
}

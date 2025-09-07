package io.github.aniket2814.cruddemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.aniket2814.cruddemo.entities.PostEntity;

/**
 * Repository interface for PostEntity.
 * 
 * Extends JpaRepository to provide CRUD operations for posts.
 * 
 * @author Aniket Rathore
 * 
 */
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}

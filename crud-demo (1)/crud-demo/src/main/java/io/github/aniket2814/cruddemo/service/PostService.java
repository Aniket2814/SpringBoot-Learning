package io.github.aniket2814.cruddemo.service;

import java.util.List;

import io.github.aniket2814.cruddemo.dto.PostDTO;

/**
 * Service interface that defines the business logic contract for managing posts
 * in the application.
 *
 * <p>
 * This layer sits between the controller and the repository, ensuring proper
 * separation of concerns.
 * </p>
 *
 * Main responsibilities:
 * <ul>
 * <li>Fetch all posts</li>
 * <li>Create a new post</li>
 * <li>Retrieve a post by its ID</li>
 * </ul>
 *
 * @author Aniket Rathore
 */
public interface PostService {

	/**
	 * Retrieves all posts from the system.
	 *
	 * @return list of {@link PostDTO}
	 */
	List<PostDTO> getAllPosts();

	/**
	 * Creates a new post in the system.
	 *
	 * @param inputPost post details to be created
	 * @return the created {@link PostDTO}
	 */
	PostDTO createNewPost(PostDTO inputPost);

	/**
	 * Fetches a post by its ID.
	 *
	 * @param postId the unique identifier of the post
	 * @return the matching {@link PostDTO}
	 */
	PostDTO getPostById(Long postId);

	/**
	 * Updates an existing post with the given ID.
	 *
	 * <p>
	 * This method is responsible for updating the details of a post. It takes the
	 * updated data as a {@link PostDTO} and applies it to the post identified by
	 * the provided ID.
	 * </p>
	 *
	 * @param inputPost the DTO containing updated post data
	 * @param postId    the ID of the post to update
	 * @return the updated {@link PostDTO}
	 * @throws io.github.aniket2814.cruddemo.exceptions.ResourceNotFoundException if
	 *                                                                            given
	 *                                                                            ID
	 */
	PostDTO updatePost(PostDTO inputPost, Long postId);
}
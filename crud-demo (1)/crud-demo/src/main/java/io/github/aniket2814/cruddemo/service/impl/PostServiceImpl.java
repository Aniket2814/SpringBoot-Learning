package io.github.aniket2814.cruddemo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.github.aniket2814.cruddemo.dto.PostDTO;
import io.github.aniket2814.cruddemo.entities.PostEntity;
import io.github.aniket2814.cruddemo.exceptions.ResourceNotFoundException;
import io.github.aniket2814.cruddemo.repositories.PostRepository;
import io.github.aniket2814.cruddemo.service.PostService;
import lombok.RequiredArgsConstructor;

/**
 * Implementation of {@link PostService} that handles all business logic related
 * to posts.
 *
 * <p>
 * This class uses {@link PostRepository} to interact with the database and
 * {@link ModelMapper} to convert between DTOs and Entities.
 * </p>
 *
 * Responsibilities:
 * <ul>
 * <li>Fetching all posts</li>
 * <li>Creating a new post</li>
 * <li>Fetching post by ID with proper exception handling</li>
 * </ul>
 *
 * @author Aniket Rathore
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	/** Repository for performing CRUD operations on posts. */
	private final PostRepository postRepository;

	/** Mapper to convert between Entity and DTO objects. */
	private final ModelMapper modelMapper;

	/**
	 * Fetches all posts from the database.
	 *
	 * @return list of {@link PostDTO}
	 */
	@Override
	public List<PostDTO> getAllPosts() {
		return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
				.collect(Collectors.toList());
	}

	/**
	 * Creates and saves a new post.
	 *
	 * @param inputPost details of the post to be created
	 * @return the saved post as {@link PostDTO}
	 */
	@Override
	public PostDTO createNewPost(PostDTO inputPost) {
		PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
		return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
	}

	/**
	 * Retrieves a post by its ID. Throws {@link ResourceNotFoundException} if post
	 * is not found.
	 *
	 * @param postId unique identifier of the post
	 * @return the matching {@link PostDTO}
	 */
	@Override
	public PostDTO getPostById(Long postId) {
		PostEntity postEntity = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not exist with ID: " + postId));
		return modelMapper.map(postEntity, PostDTO.class);
	}

	/**
	 * Updates an existing Post with the given ID using the provided PostDTO.
	 * 
	 * <p>
	 * The method fetches the post from the database, maps the new values from the
	 * DTO to the existing entity, saves the updated entity, and returns the updated
	 * DTO.
	 * </p>
	 *
	 * @param inputPost the DTO containing updated post data
	 * @param postId    the ID of the post to be updated
	 * @return the updated PostDTO
	 * @throws ResourceNotFoundException if the post with the given ID does not
	 *                                   exist
	 */
	@Override
	public PostDTO updatePost(PostDTO inputPost, Long postId) {
		// Fetch the existing PostEntity from DB or throw exception if not found
		PostEntity olderPost = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not exist with ID: " + postId));

		// Ensure DTO has the correct ID to maintain consistency
		inputPost.setId(postId);

		// Map updated fields from DTO → existing entity
		modelMapper.map(inputPost, olderPost);

		// Save the updated entity to DB
		PostEntity savedPostEntity = postRepository.save(olderPost);

		// Convert back to DTO and return to the client
		return modelMapper.map(savedPostEntity, PostDTO.class);
	}

}

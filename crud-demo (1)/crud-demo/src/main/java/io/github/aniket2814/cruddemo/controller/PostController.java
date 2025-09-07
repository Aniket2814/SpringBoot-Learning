package io.github.aniket2814.cruddemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.aniket2814.cruddemo.dto.PostDTO;
import io.github.aniket2814.cruddemo.service.PostService;
import lombok.RequiredArgsConstructor;

/**
 * REST controller for handling operations related to Posts.
 * 
 * <p>
 * This controller exposes endpoints for retrieving all posts, creating a new
 * post, and fetching a post by its ID.
 * </p>
 *
 * author: Aniket Rathore since: 2025
 */
@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	/**
	 * Fetch all available posts.
	 *
	 * @return a list of {@link PostDTO} objects
	 */
	@GetMapping
	public List<PostDTO> getAllPosts() {
		return postService.getAllPosts();
	}

	/**
	 * Create a new post.
	 *
	 * @param inputPost the details of the new post
	 * @return the created {@link PostDTO}
	 */
	@PostMapping
	public PostDTO createNewPost(@RequestBody PostDTO inputPost) {
		return postService.createNewPost(inputPost);
	}

	/**
	 * Fetch a specific post by its ID.
	 *
	 * @param postId the ID of the post to retrieve
	 * @return the {@link PostDTO} corresponding to the given ID
	 */
	@GetMapping("/{postId}")
	public PostDTO getPostById(@PathVariable Long postId) {
		return postService.getPostById(postId);
	}

	@PutMapping("/{postId}")
	public PostDTO createNewPost(@RequestBody PostDTO inputPost, @PathVariable Long postId) {
		return postService.updatePost(inputPost, postId);
	}
}

package com.emerzonic.service;

import java.util.List;

import com.emerzonic.entity.Post;

public interface PostService {
	
	public List<Post> getAllPosts();

	public void addPost(Post post);

	public Post getPost(int postId);

	public Post updatePost(Post post);

	public void deletePost(int postId);

	public List<Post> searchPosts(String searchTerm);
}

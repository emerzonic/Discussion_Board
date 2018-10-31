package com.emerzonic.dao;

import java.util.List;

import com.emerzonic.entity.Post;

public interface PostDAO {
	
	public List<Post> getAllPosts();

	public void addPost(Post post);

	public Post getPost(int postId);

}

package com.emerzonic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emerzonic.dao.PostDAO;
import com.emerzonic.entity.Post;


@Service
public class PostServiceImpli implements PostService {

	@Autowired
	private PostDAO postDAO;
	
	@Transactional
	@Override
	public List<Post> getAllPosts() {
		return postDAO.getAllPosts();
	}
	
	@Transactional
	@Override
	public void addPost(Post post) {
		postDAO.addPost(post);
	}
	
	
	@Transactional
	@Override
	public Post getPost(int postId) {
		return postDAO.getPost(postId);
	}

	@Transactional
	@Override
	public Post updatePost(Post post) {
		return postDAO.updatePost(post);
	}
	
	
	@Transactional
	@Override
	public void deletePost(int postId) {
		postDAO.deletePost(postId);
	}
	
	
}

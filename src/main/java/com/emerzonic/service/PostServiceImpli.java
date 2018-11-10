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
	
	@Override
	@Transactional
	public List<Post> getAllPosts() {
		return postDAO.getAllPosts();
	}
	
	
	@Override
	@Transactional
	public void addPost(Post post) {
		postDAO.addPost(post);
	}
	
	
	
	@Override
	@Transactional
	public Post getPost(int postId) {
		return postDAO.getPost(postId);
	}


	@Override
	@Transactional
	public Post updatePost(Post post) {
		return postDAO.updatePost(post);
	}
	
	
	
	@Override
	@Transactional
	public void deletePost(int postId) {
		postDAO.deletePost(postId);
	}


	@Override
	@Transactional
	public List<Post> searchPosts(String searchTerm) {
		return postDAO.searchPost(searchTerm);
	}
	
	
}

package com.emerzonic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emerzonic.dao.CommentDAO;



@Service
public class CommentServiceImpli implements CommentService {
	@Autowired
	private CommentDAO commentDAO;
	
	
	@Override
	@Transactional
	public void addComment(Integer postId, String comment) {
		commentDAO.AddComment(postId, comment);
		
	}
		
	
	
	
	

}

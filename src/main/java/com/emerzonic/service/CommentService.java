package com.emerzonic.service;

import com.emerzonic.entity.PostComment;

public interface CommentService {


	public void addComment(Integer postId, String comment);

	public PostComment getComment(int commentId);

	public void updateComment(int postId, PostComment comment);

	public void deleteComment(int commentId);



	

}

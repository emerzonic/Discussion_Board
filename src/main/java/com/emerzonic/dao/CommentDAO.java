package com.emerzonic.dao;

import com.emerzonic.entity.PostComment;

public interface CommentDAO {


	public void AddComment(Integer postId, String comment);

	public PostComment getComment(int commentId);

	public void updateComment(int postId, PostComment comment);

	public void deleteComment(int commentId);

}

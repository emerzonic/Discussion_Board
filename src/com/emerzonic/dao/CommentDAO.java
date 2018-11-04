package com.emerzonic.dao;

import com.emerzonic.entity.PostComment;

public interface CommentDAO {


	void AddComment(Integer postId, String comment);

}

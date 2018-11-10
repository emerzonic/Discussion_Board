package com.emerzonic.util;

import com.emerzonic.entity.Post;
import com.emerzonic.entity.PostComment;

public class PostCommentUtil {
    private Post post;
    private PostComment comment;
    
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public PostComment getComment() {
		return comment;
	}
	public void setComment(PostComment comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "PostCommentUtil [post=" + post + ", comment=" + comment + "]";
	}
	
	
}

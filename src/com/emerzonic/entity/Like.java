package com.emerzonic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_like")
public class Like {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="post_id")
	private Integer postId;
	
	@Column(name="comment_id")
	private Integer commentId;
	
	@Column(name="reply_id")
	private Integer replyId;

	public Like() {}
	
	public Like(int userId, Integer postId, Integer commentId, Integer replyId) {
		this.userId = userId;
		this.postId = postId;
		this.commentId = commentId;
		this.replyId = replyId;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public int getReplyId() {
		return replyId;
	}


	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}


	@Override
	public String toString() {
		return "Like [id=" + id + ", userId=" + userId + ", postId=" + postId + ", commentId=" + commentId
				+ ", replyId=" + replyId + "]";
	}
	
	

}

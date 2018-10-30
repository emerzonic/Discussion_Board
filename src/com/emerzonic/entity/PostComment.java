package com.emerzonic.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class PostComment {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
		
	@Column(name="text")
	private String text;
		
	@Column(name="date")
	private Date date;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="post_id")
	private int postId;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="comment_id")
	private List<Reply> replies;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="comment_id")
	private List<Like> likes;
	
	public PostComment() {}

	public PostComment(String text, int userId, int postId) {
		this.text = text;
		this.date = new Timestamp(System.currentTimeMillis());
		this.userId = userId;
		this.postId = postId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	
	public void add(Reply newReply) {
		if (replies == null) {
			replies = new ArrayList<>();
		}
		replies.add(newReply);
	}
	
	public void toggleLike(Like newLike) {
		if (likes == null) {
			likes = new ArrayList<>();
		}
		likes.add(newLike);
	}

	@Override
	public String toString() {
		return "PostComment [id=" + id + ", text=" + text + ", date=" + date + ", userId=" + userId + ", postId="
				+ postId + "]";
	}	
	
}

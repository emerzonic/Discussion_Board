package com.emerzonic.entity;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javax.persistence.Transient;

@Entity
@Table(name = "comment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "text")
	private String text;

	@Column(name = "created_on", nullable = false, updatable = false)
	private Timestamp createdOn;

	@Transient
	private String dateString;

	@Column(name = "author")
	private String author;

	@Column(name = "post_id")
	private int postId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	private List<Reply> replies;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	private List<Like> likes;

	public PostComment() {
	}

	public PostComment(String text, String author, int postId) {
		this.text = text;
		this.author = author;
		this.postId = postId;
		this.createdOn = new Timestamp(System.currentTimeMillis());
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

	public Timestamp getCreatedOn() {
		return createdOn;
	}


	public String getDateString() {
		if (dateString == null) {
			dateString = DateTimeFormatter.ofPattern("E, MMM. dd yyyy").format(createdOn.toLocalDateTime());
		}
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		return "PostComment [id=" + id + ", text=" + text + ", createdOn=" + createdOn + ", dateString=" + dateString
				+ ", author=" + author + ", postId=" + postId + "]";
	}

}

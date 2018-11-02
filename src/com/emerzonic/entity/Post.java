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

import org.hibernate.annotations.DynamicUpdate;

	@Entity
	@Table(name="post")
	@DynamicUpdate
	public class Post {
			
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="title")
		private String title;
		
		@Column(name="text")
		private String text;
			
		@Column(name="created_on",nullable = false, updatable = false)
		private Timestamp createdOn;
		
		@Transient
		private String dateString;
		
		@Column(name="author")
		private String author;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="post_id")
		private List<PostComment> comments;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="post_id")
		private List<Like> likes;
		
		public Post() {
			
		}

		public Post(String title, String text, String author) {
			this.title = title;
			this.text = text;
			this.author = author;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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

		public void setCreatedOn() {
			this.createdOn = new Timestamp(
		            System.currentTimeMillis()
		        );
		}

		public String getDateString() {
	        if(dateString == null) {
	        	dateString = DateTimeFormatter
	        			.ofPattern("E, MMM. dd yyyy 'at' h:mm a")
	        			.format(createdOn.toLocalDateTime());
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

		public List<PostComment> getComments() {
			return comments;
		}

		public void setComments(List<PostComment> comments) {
			this.comments = comments;
		}

		public List<Like> getLikes() {
			return likes;
		}

		public void setLikes(List<Like> likes) {
			this.likes = likes;
		}
		
		public void add(PostComment newComment) {
			if (comments == null) {
				comments = new ArrayList<>();
			}
			comments.add(newComment);
		}
		
		public void toggleLike(Like newLike) {
			if (likes == null) {
				likes = new ArrayList<>();
			}
			System.out.println("In post");
			likes.add(newLike);
		}

		@Override
		public String toString() {
			return "Post [id=" + id + ", title=" + title + ", text=" + text + ", createdOn=" + createdOn
					+ ", dateString=" + dateString + ", author=" + author + "]";
		}
	
	}
	
	

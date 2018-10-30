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
	@Table(name="reply")
	public class Reply {
		
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
		
		@Column(name="comment_id")
		private int commentId;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="reply_id")
		private List<Like> likes;

		public Reply() {}

		public Reply(String text, int userId, int commentId) {
			this.text = text;
			this.date = new Timestamp(System.currentTimeMillis());
			this.userId = userId;
			this.commentId = commentId;
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

		public int getCommentId() {
			return commentId;
		}

		public void setCommentId(int commentId) {
			this.commentId = commentId;
		}

		public List<Like> getLikes() {
			return likes;
		}

		public void setLikes(List<Like> likes) {
			this.likes = likes;
		}
		
		public void toggleLike(Like newLike) {
			if (likes == null) {
				likes = new ArrayList<>();
			}
			
			//write code to check if user has already like
			likes.add(newLike);
		}

		@Override
		public String toString() {
			return "Reply [id=" + id + ", text=" + text + ", date=" + date + ", userId=" + userId + ", commentId="
					+ commentId + "]";
		}	

}

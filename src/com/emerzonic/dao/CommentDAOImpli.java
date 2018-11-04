package com.emerzonic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emerzonic.entity.Post;
import com.emerzonic.entity.PostComment;
import com.emerzonic.entity.User;

@Repository
public class CommentDAOImpli implements CommentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void AddComment(Integer postId,String comment) {
		Session currentSession = sessionFactory.getCurrentSession();
		//Hardcoding currentUser for now
		int userId = 1;
		User currentUser = currentSession.get(User.class, userId);
		Post post = currentSession.get(Post.class, postId);
		PostComment newComment = new PostComment(comment, currentUser.getUsername(), postId);
		post.add(newComment);
		System.out.println("\n"+newComment.toString());
		currentSession.save(post);
		
	}

}

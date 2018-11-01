package com.emerzonic.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.Fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emerzonic.entity.Post;
import com.emerzonic.entity.PostComment;
import com.emerzonic.entity.User;


@Repository
public class PostDAOImple implements PostDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Post> getAllPosts() {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Post> query = currentSession.createQuery("from Post order by date DESC",Post.class);
		List <Post> posts = query.getResultList();
		return posts;
	}


	@Override
	public void addPost(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		//Hardcoding currentUser for now
		int userId = 1;
		User currentUser = currentSession.get(User.class, userId);
		post.setDate(new Timestamp(System.currentTimeMillis()));
		post.setAuthor(currentUser.getUsername());
		currentSession.save(post);
	}


	@Override
	public Post getPost(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();		
		Query<Post> query = currentSession.createQuery("SELECT p from Post p "
														+ "JOIN FETCH p.comments "
														+ "WHERE p.id=:postId",Post.class);
		query.setParameter("postId", postId);
		Post post = query.getSingleResult();
		return post;
	}

	
	@Override
	public Post updatePost(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(post);
		return getPost(post.getId());
	}

	@Override
	public void deletePost(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Post post = currentSession.get(Post.class, postId);
		
		if (post != null) {
			currentSession.delete(post);
		}
	}



}

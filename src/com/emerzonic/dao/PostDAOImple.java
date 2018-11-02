package com.emerzonic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emerzonic.entity.Post;
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
		Query<Post> query = currentSession.createQuery("from Post order by created_on DESC",Post.class);
		List <Post> posts = query.getResultList();
		return posts;
	}


	@Override
	public void addPost(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		//Hardcoding currentUser for now
		int userId = 1;
		User currentUser = currentSession.get(User.class, userId);
		post.setAuthor(currentUser.getUsername());
		post.setCreatedOn();
		System.out.println("\n"+post.toString());
		currentSession.save(post);
	}

	
	@Override
	public Post getPost(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Post post = currentSession.get(Post.class, postId);
		post.getComments();
		post.setComments(post.getComments());
		System.out.println(post.getComments().toString());
		return post;
	}

	
	@Override
	public Post updatePost(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.createQuery("UPDATE Post set title = :title, text = :text " + "WHERE id = :postId")
		   .setParameter("title",post.getTitle())
		   .setParameter("text",post.getText())
		   .setParameter("postId",post.getId())
		   .executeUpdate();
		
//		currentSession.update(post);
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

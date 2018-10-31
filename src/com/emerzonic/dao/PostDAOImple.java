package com.emerzonic.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emerzonic.entity.Post;
import com.emerzonic.entity.User;


@Repository
public class PostDAOImple implements PostDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Post> getAllPosts() {
		//get curent hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Post> query = currentSession.createQuery("from Post order by date DESC",Post.class);
		//execute query and get result
		List <Post> posts = query.getResultList(); 
		for(Post p: posts)
			System.out.println(p.getLikes().size());

		//return results
		return posts;
	}


	@Override
	@Transactional
	public void addPost(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		//Hardcoding currentUser for now
		int userId = 1;
		User currentUser = currentSession.get(User.class, userId);
		post.setDate(new Timestamp(System.currentTimeMillis()));
		post.setUserId(currentUser.getId());
		currentSession.save(post);
		
		
	}


	@Override
	@Transactional
	public Post getPost(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Post post = currentSession.get(Post.class, postId);
		return post;
	}
}

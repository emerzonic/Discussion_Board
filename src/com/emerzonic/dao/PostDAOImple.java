package com.emerzonic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emerzonic.entity.Post;


@Repository
public class PostDAOImple implements PostDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Post> getAllPosts() {
		//get curent hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create query
		Query<Post> query = session.createQuery("from Post",Post.class);
		//execute query and get result
		List <Post> posts = query.getResultList(); 
		for(Post p: posts)
			System.out.println(p.toString());

		//return results
		return posts;
	}

}

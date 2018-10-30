package com.emerzonic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emerzonic.dao.PostDAO;
import com.emerzonic.entity.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	//inject DAO
	@Autowired
	private PostDAO postDAO;
	
	
	@RequestMapping("/list")
	public String showPosts(Model model) {
		//get posts from DAO
		List<Post> posts = postDAO.getAllPosts();
		
		
		//add posts to modal
		model.addAttribute("posts", posts);
		
		//pass to view
		return "show-posts";
	}

}

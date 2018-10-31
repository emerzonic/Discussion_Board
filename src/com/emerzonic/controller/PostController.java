package com.emerzonic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emerzonic.dao.PostDAO;
import com.emerzonic.entity.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	//inject DAO
	@Autowired
	private PostDAO postDAO;
	
	//get all posts
	@GetMapping("/list")
	public String showPosts(Model model) {
		//get posts from DAO
		List<Post> posts = postDAO.getAllPosts();
		model.addAttribute("posts", posts);
		return "show-posts";
	}
	
	
	//get new post form
	@GetMapping("/newPost")
	public String newPost(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "post-form";
	}
	
	
	//add new post
	@PostMapping("/addPost")
	public String addPost(@ModelAttribute("post") Post post) {
		postDAO.addPost(post);
		return "redirect:/post/list";
	}
	
	
	
	//get post details
	@GetMapping("/detail")
	public String postDetail(@RequestParam("postId")int postId,Model model) {
		Post showPost = postDAO.getPost(postId);
		model.addAttribute("post", showPost);
		return "post-detail";
	}
	
	
	
	//get post to be edited
	@GetMapping("/edit")
	public String edit(@RequestParam("postId")int postId,Model model) {
		Post showPost = postDAO.getPost(postId);
		model.addAttribute("post", showPost);
		return "edit-form";
	}
	
	
	//update post
	@PostMapping("/update")
	public String updatePost(@ModelAttribute("post") Post post, Model model) {
		Post updatedPost = postDAO.updatePost(post);
		model.addAttribute("post", updatedPost);
		return "post-detail";
	}
	
	
	
	
	@GetMapping("/delete")
	public String deletePost(@RequestParam("postId") int postId) {
		postDAO.deletePost(postId);
		return "redirect:/post/list";
	}
}

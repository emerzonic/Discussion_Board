package com.emerzonic.controller;

import java.util.List;

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
	
	
	@GetMapping("/list")
	public String showPosts(Model model) {
		//get posts from DAO
		List<Post> posts = postDAO.getAllPosts();
		model.addAttribute("posts", posts);
		return "show-posts";
	}
	
	
	@GetMapping("/showPostForm")
	public String showPostForm(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "post-form";
	}
	
	
	@PostMapping("/addPost")
	public String addPost(@ModelAttribute("post") Post post) {
		postDAO.addPost(post);
		return "redirect:/post/list";
	}
	
	
	@GetMapping("/getPost")
	public String getPost(@RequestParam("postId") int postId, Model model) {
		Post post = postDAO.getPost(postId);
		model.addAttribute("post", post);
		return "post-detail";
	}
	
	
	@PostMapping("/editPost")
	public String editPost(@ModelAttribute("post") Post post) {
		
		return "redirect:/post/list";
	}
	
	
	@PostMapping("/deletePost")
	public String deletePost(@ModelAttribute("post") Post post) {
		
		return "redirect:/post/list";
	}
}

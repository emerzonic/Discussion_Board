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

import com.emerzonic.entity.Post;
import com.emerzonic.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	//inject PostService
	@Autowired
	private PostService PostService;
	
	
	//get all posts
	@GetMapping("/list")
	public String showPosts(Model model) {
		//get posts from postService
		List<Post> posts = PostService.getAllPosts();
		model.addAttribute("posts", posts);
		return "show-posts";
	}
	
	//search posts
	@PostMapping("/search")
	public String searchPosts(@RequestParam("searchTerm") String searchTerm,Model model)  {
		System.out.println(searchTerm);
		List<Post> posts = PostService.searchPosts(searchTerm);
		model.addAttribute("posts", posts);
		return  "show-posts";
	}
	
	
	//get new post form
	@GetMapping("/new")
	public String newPost(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "post-form";
	}
	
	
	//add new post
	@PostMapping("/addPost")
	public String addPost(@ModelAttribute("post") Post post) {
		PostService.addPost(post);
		return "redirect:/post/list";
	}
	
	
	
	//get post details
	@GetMapping("/detail")
	public String postDetail(@RequestParam("postId")int postId,Model model) {
		Post showPost = PostService.getPost(postId);
		model.addAttribute("post", showPost);
		return "post-detail";
	}
	
	
	
	//get post to be edited
	@GetMapping("/edit")
	public String edit(@RequestParam("postId")int postId,Model model) {
		Post showPost = PostService.getPost(postId);
		model.addAttribute("post", showPost);
		return "edit-form";
	}
	
	
	//update post
	@PostMapping("/update")
	public String updatePost(@ModelAttribute("post") Post post, Model model) {
		Post updatedPost = PostService.updatePost(post);
		model.addAttribute("post", updatedPost);
		return "post-detail";
	}
	
	
	@GetMapping("/delete")
	public String deletePost(@RequestParam("postId") int postId) {
		PostService.deletePost(postId);
		return "redirect:/post/list";
	}
}

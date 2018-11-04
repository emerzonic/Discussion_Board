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
import com.emerzonic.entity.PostComment;
import com.emerzonic.service.CommentService;
import com.emerzonic.service.PostService;

@Controller
@RequestMapping("/post")
public class CommentController {
	//inject PostService
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	
	
	//add new comment
	@PostMapping("/addComment")
	public String addComment(@RequestParam("parentPostId")int postId, 
							 @RequestParam("text") String comment, Model model) {
		commentService.addComment(postId, comment);
		Post post = postService.getPost(postId);
		model.addAttribute("post", post);
		return "post-detail";
	}
	
	
	
//	//get post details
//	@GetMapping("/detail")
//	public String postDetail(@RequestParam("postId")int postId,Model model) {
//		PostComment showPost = PostService.getPost(postId);
//		model.addAttribute("post", showPost);
//		return "post-detail";
//	}
//	
//	
//	
//	//get post to be edited
//	@GetMapping("/edit")
//	public String edit(@RequestParam("postId")int postId,Model model) {
//		Post showPost = PostService.getPost(postId);
//		model.addAttribute("post", showPost);
//		return "edit-form";
//	}
//	
//	
//	//update post
//	@PostMapping("/update")
//	public String updatePost(@ModelAttribute("post") Post post, Model model) {
//		Post updatedPost = PostService.updatePost(post);
//		model.addAttribute("post", updatedPost);
//		return "post-detail";
//	}
//	
//	
//	
//	
//	@GetMapping("/delete")
//	public String deletePost(@RequestParam("postId") int postId) {
//		PostService.deletePost(postId);
//		return "redirect:/post/list";
//	}
}

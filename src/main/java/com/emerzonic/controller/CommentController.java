package com.emerzonic.controller;


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
import com.emerzonic.util.PostCommentUtil;

@Controller
@RequestMapping("/comment")
public class CommentController {
	//inject PostService
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	
	//add new comment
	@PostMapping("/addComment")
	public String addComment(@RequestParam("parentPostId")int postId, @RequestParam("text") String comment, Model model) {
		commentService.addComment(postId, comment);
		Post post = postService.getPost(postId);
		model.addAttribute("post", post);
		return "post-detail";
	}
	
	
	//get comment to be edited
	@GetMapping("/edit")
	public String editComment(@RequestParam("postId")int postId, @RequestParam("commentId")int commentId, Model model) {
		PostComment comment = commentService.getComment(commentId);
		Post post = postService.getPost(postId);
		PostCommentUtil postcomment = new PostCommentUtil();
		postcomment.setPost(post);
		postcomment.setComment(comment);
		post.add(comment);
		model.addAttribute("postcomment", postcomment);
		return "edit-comment";
	}

	
	//update comment mapping
	@PostMapping("/update")
	public String updateComment(@ModelAttribute("postcomment") PostCommentUtil post, Model model) {
		int postId = post.getPost().getId();
		PostComment comment = post.getComment();
		commentService.updateComment(postId, comment);
		Post updatedPost = postService.getPost(postId);
		model.addAttribute("post", updatedPost);
		return "post-detail";
	}

	//delete comment mapping
	@GetMapping("/delete")
	public String deleteComment(@RequestParam("commentId") int commentId, @RequestParam("postId") int postId, Model model) {
		commentService.deleteComment(commentId);
		Post post = postService.getPost(postId);
		model.addAttribute("post", post);
		return "post-detail";
	}
}

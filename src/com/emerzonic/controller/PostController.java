package com.emerzonic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@RequestMapping("/list")
	public String showPosts(Model model) {
		return "show-posts";
	}

}

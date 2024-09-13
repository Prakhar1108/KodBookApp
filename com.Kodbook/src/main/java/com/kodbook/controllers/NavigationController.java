package com.kodbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/openSignup")
	public String openSignup() {
		return "signUp";
	}
	
	@GetMapping("/newPost")
	public String newPost() {
		return "createPost";
	}
}

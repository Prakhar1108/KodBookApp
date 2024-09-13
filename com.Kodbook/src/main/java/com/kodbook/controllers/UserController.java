package com.kodbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook.entities.User;
import com.kodbook.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/signUp")
	public String addUser(@ModelAttribute User usr) {
		boolean status = service.userExist(usr.getUsername(),usr.getEmail());
		if(status==false) {
			service.addUser(usr);
		}
		    return "index";
	}
	
	@GetMapping("/login")
	public String loginAuth(@RequestParam String username,@RequestParam String password) {
		boolean status = service.loginAuth(username, password);
		if(status== true) {
		return "home";
		}
		return  "index";
	}
}

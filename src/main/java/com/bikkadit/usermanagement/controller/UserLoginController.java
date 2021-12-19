package com.bikkadit.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.usermanagement.bindings.LoginForm;
import com.bikkadit.usermanagement.service.UserServiceI;

@RestController
public class UserLoginController {

	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		return userServiceI.loginCheck(loginForm);
	}

}

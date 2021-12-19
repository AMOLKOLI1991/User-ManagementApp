package com.bikkadit.usermanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.usermanagement.bindings.UserForm;
import com.bikkadit.usermanagement.service.UserServiceI;

@RestController
public class UserFormController {

	@Autowired
	private UserServiceI userServiceI;

	@GetMapping("/contries")
	public Map<Integer, String> contries() {
		return userServiceI.getContries();
	}

	@GetMapping("/getStates/{countryId}")
	public Map<Integer, String> getStates(@PathVariable Integer countryId) {
		return userServiceI.getStates(countryId);
	}

	@GetMapping("/getCities/{stateId}")
	public Map<Integer, String> getCities(@PathVariable Integer stateId) {
		return userServiceI.getCities(stateId);
	}

	@GetMapping("/emailCheck/{userEmail}")
	public String emailCheck(@PathVariable String userEmail) {
		boolean emailUnique = userServiceI.emailUnique(userEmail);
		if (emailUnique) {
			return "UNIQUE";
		}
		return "DUPLICATE";
	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserForm userForm) {
		boolean saveUser = userServiceI.saveUser(userForm);
		if (saveUser) {
			return "SUCCESS";
		}
		return "FAIL";

	}
}

package com.bikkadit.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.usermanagement.bindings.UnlockAccountForm;
import com.bikkadit.usermanagement.service.UserServiceI;

@RestController
public class UnlockUserController {

	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping("/unlockAccount")
	public String unlockAccount(@RequestBody UnlockAccountForm unlockAccountForm) {
		boolean unlockAccount = userServiceI.unlockAccount(unlockAccountForm);
		if(unlockAccount) {
			return "ACCOUNT UNLOCKED";
		}
		return "FAILED TO UNLOCK";
		
	}

}

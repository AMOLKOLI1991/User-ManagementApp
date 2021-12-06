package com.bikkadit.usermanagement.service;

import java.util.Map;

import com.bikkadit.usermanagement.bindings.LoginCheck;

public interface UserServiceI {

	public String loginCheck(LoginCheck loginCheck);
	public Map<Integer, String> getContries();
	public Map<Integer, String> getStates();
	public Map<Integer, String> getCities();
	public boolean emailUnique(String email);
	public boolean saveUser(UserForm userForm);
	public boolean isTempPwsValid(String email, String tempPwd);
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm);
	public String forgotPwd(String emailId);
	
	
}

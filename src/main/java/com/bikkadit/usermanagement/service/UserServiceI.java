package com.bikkadit.usermanagement.service;

import java.util.Map;

import com.bikkadit.usermanagement.bindings.LoginForm;
import com.bikkadit.usermanagement.bindings.UnlockAccountForm;
import com.bikkadit.usermanagement.bindings.UserForm;

public interface UserServiceI {

	public String loginCheck(LoginForm loginform);
	public Map<Integer, String> getContries();
	public Map<Integer, String> getStates(Integer countryId);
	public Map<Integer, String> getCities(Integer stateId);
	public boolean emailUnique(String email);
	public boolean saveUser(UserForm userForm);
	public boolean isTempPwsValid(String email, String tempPwd);
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm);
	public String forgotPwd(String emailId);
	
	
}

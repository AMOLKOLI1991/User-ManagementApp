package com.bikkadit.usermanagement.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bikkadit.usermanagement.bindings.LoginCheck;

@Service
public class UserServiceImpl implements UserServiceI{

	@Override
	public String loginCheck(LoginCheck loginCheck) {
	
		return null;
	}

	@Override
	public Map<Integer, String> getContries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean emailUnique(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTempPwsValid(String email, String tempPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String forgotPwd(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}

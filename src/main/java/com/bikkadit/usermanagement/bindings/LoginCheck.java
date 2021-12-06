package com.bikkadit.usermanagement.bindings;

public class LoginCheck {

	private String userEmail;
	
	private String userPassword;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginCheck [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
	
	
}

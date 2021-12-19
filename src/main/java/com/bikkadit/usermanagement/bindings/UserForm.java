package com.bikkadit.usermanagement.bindings;

import java.util.Date;
import com.bikkadit.usermanagement.entities.City;
import com.bikkadit.usermanagement.entities.Country;
import com.bikkadit.usermanagement.entities.States;

public class UserForm {

private String userFirstName;
	
	private String userLastName;
	 
	private String userEmail;
	
	private long userMobNo;
	
	private Date userDob;
	
	private States userState;
	
	private Country userCountry;
	
	private City userCity;
	
	private String userPassword;
	
	private String userGender;
	
	private String accStatus;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserMobNo() {
		return userMobNo;
	}

	public void setUserMobNo(long userMobNo) {
		this.userMobNo = userMobNo;
	}

	public Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public States getUserState() {
		return userState;
	}

	public void setUserState(States userState) {
		this.userState = userState;
	}

	public Country getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(Country userCountry) {
		this.userCountry = userCountry;
	}

	public City getUserCity() {
		return userCity;
	}

	public void setUserCity(City userCity) {
		this.userCity = userCity;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	
	
	
	
	
}

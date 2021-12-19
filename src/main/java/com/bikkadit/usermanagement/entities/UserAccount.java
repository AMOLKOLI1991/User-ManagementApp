package com.bikkadit.usermanagement.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_FIRST_NAME")
	private String userFirstName;
	
	@Column(name="USER_LAST_NAME")
	private String userLastName;
	
	@Column(name="USER_EMAIL",  unique=true)
	private String userEmail;
	
	@Column(name="USER_MOB_NO")
	private long userMobNo;
	
	@Column(name="USER_DOB")
	private Date userDob;
	
	@Column(name="USER_STATE")
	private Integer userState;
	
	@Column(name="USER_COUNTRY")
	private Integer userCountry;
	
	@Column(name="USER_CITY")
	private Integer userCity;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="USER_GENDER")
	private String userGender;
	
	@Column(name="ACTIVE_SW")
	private Character activeSw;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;

	
	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



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



	public Integer getUserState() {
		return userState;
	}



	public void setUserState(Integer userState) {
		this.userState = userState;
	}



	public Integer getUserCountry() {
		return userCountry;
	}



	public void setUserCountry(Integer userCountry) {
		this.userCountry = userCountry;
	}



	public Integer getUserCity() {
		return userCity;
	}



	public void setUserCity(Integer userCity) {
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



	public Character getActiveSw() {
		return activeSw;
	}



	public void setActiveSw(Character activeSw) {
		this.activeSw = activeSw;
	}



	public LocalDate getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public LocalDate getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}


	

	public String getAccStatus() {
		return accStatus;
	}



	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}



	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userMobNo=" + userMobNo + ", userDob=" + userDob + ", userState="
				+ userState + ", userCountry=" + userCountry + ", userCity=" + userCity + ", userPassword="
				+ userPassword + ", userGender=" + userGender + ", activeSw=" + activeSw + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	
}

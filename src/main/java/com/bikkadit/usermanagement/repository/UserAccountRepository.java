package com.bikkadit.usermanagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.usermanagement.entities.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Serializable>{

	public UserAccount findByUserEmailAndUserPassword(String userEmail, String userPassword);
	public UserAccount findByUserEmail(String userEmailString);
	
}

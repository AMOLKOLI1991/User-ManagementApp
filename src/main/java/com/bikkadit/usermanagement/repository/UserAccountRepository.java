package com.bikkadit.usermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.usermanagement.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Serializable>{

}

package com.bikkadit.usermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.usermanagement.entities.States;

public interface StatesRepository extends JpaRepository<States, Serializable>{

}

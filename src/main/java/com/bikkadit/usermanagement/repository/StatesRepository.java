package com.bikkadit.usermanagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.usermanagement.entities.States;

@Repository
public interface StatesRepository extends JpaRepository<States, Serializable>{

	public List<States> findByCountryId(Integer countryId);
}

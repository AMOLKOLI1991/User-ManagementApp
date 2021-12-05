package com.bikkadit.usermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.usermanagement.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable>{

}

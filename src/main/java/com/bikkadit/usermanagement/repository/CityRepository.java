package com.bikkadit.usermanagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.usermanagement.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Serializable>{

	public List<City> findByStateId(Integer stateId);
}

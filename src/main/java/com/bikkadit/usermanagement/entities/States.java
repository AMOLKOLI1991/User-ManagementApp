package com.bikkadit.usermanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="STATES_MASTER")
public class States {

	@Id
	@Column(name="STATE_ID")
	private int stateId;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@Autowired
	@Column(name="COUNTRY_ID")
	private Country country;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "States [stateId=" + stateId + ", stateName=" + stateName + ", country=" + country + "]";
	}
	
	
	

}

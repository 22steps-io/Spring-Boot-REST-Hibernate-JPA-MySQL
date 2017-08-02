package com.steps.org.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id")
        private int countryId;  
	
	@Column(name="country_code")
        private String countryCode;
	
	@Column(name="country_name")	
		private String countryName;
	
	@Column(name="continent")	
		private String continent;
	
	@Column(name="flag")	
		private String flag;

	public String getContinent() {
		return continent;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public int getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getFlag() {
		return flag;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}

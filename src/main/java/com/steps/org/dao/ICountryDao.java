package com.steps.org.dao;

import java.util.List;

import com.steps.org.entity.Country;

public interface ICountryDao {
	List<Country> getAllCountries();
	Country getCountryById(int countryId);
    void addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(int countryId);
    boolean countryExists(String countryName, String continent);
}	

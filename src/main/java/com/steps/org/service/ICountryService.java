package com.steps.org.service;

import java.util.List;

import com.steps.org.entity.Country;

public interface ICountryService {
	 List<Country> getAllCountries();
	 Country getCountryById(int countryId);
     boolean addCountry(Country country);
     void updateCountry(Country country);
     void deleteCountry(int countryId);
}

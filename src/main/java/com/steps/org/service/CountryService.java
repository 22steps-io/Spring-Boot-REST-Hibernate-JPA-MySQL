package com.steps.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steps.org.dao.ICountryDao;
import com.steps.org.entity.Country;

@Service
public class CountryService implements ICountryService {
	
	@Autowired
	private ICountryDao countryDAO;

	@Override
	public List<Country> getAllCountries() {
		return countryDAO.getAllCountries();
	}

	@Override
	public Country getCountryById(int countryId) {
		Country obj = countryDAO.getCountryById(countryId);
		return obj;
	}

	@Override
	public boolean addCountry(Country country) {
		 if (countryDAO.countryExists(country.getCountryName(), country.getContinent())) {
	            return false;
         } else {
        	 countryDAO.addCountry(country);
	            return true;
         }
	}

	@Override
	public void updateCountry(Country country) {
		countryDAO.updateCountry(country);
		
	}

	@Override
	public void deleteCountry(int countryId) {
		countryDAO.deleteCountry(countryId);
		
	}

}

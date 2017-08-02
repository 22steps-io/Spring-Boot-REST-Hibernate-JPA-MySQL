package com.steps.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.steps.org.entity.Country;
import com.steps.org.service.ICountryService;

@Controller
@RequestMapping("user")
public class CountryController {
	
	@Autowired
	private ICountryService countryService;
	
	@GetMapping("country/{id}")
	public ResponseEntity<Country> getArticleById(@PathVariable("id") Integer id) {
		Country country = countryService.getCountryById(id);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
	@GetMapping("countries")
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> list = countryService.getAllCountries();
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
	
	@PostMapping("country")
	public ResponseEntity<Void> addCountry(@RequestBody Country country, UriComponentsBuilder builder) {
                boolean flag = countryService.addCountry(country);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/article/{id}").buildAndExpand(country.getCountryId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("country")
	public ResponseEntity<Country> updateArticle(@RequestBody Country country) {
		countryService.updateCountry(country);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
	@DeleteMapping("country/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable("id") Integer id) {
		countryService.deleteCountry(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}

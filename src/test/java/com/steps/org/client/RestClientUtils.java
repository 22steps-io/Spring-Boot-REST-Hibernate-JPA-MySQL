package com.steps.org.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.steps.org.entity.Country;

public class RestClientUtils {
	public void getCountryByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/country/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Country> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Country.class, 1);
		Country country = responseEntity.getBody();
		System.out.println("Id:" + country.getCountryId() + ", CountryName:" + country.getCountryName() + ", Continent:"
				+ country.getContinent());
	}

	public void getAllCountriesDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/countries";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Country[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Country[].class);
		Country[] countries = responseEntity.getBody();
		for (Country country : countries) {
			System.out.println("Id:" + country.getCountryId() + ", CountryName:" + country.getCountryName()
					+ ", Continent: " + country.getContinent());
		}
	}

	public void addCountryDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/country";
		Country objCountry = new Country();
		objCountry.setCountryCode("JPN");
		objCountry.setCountryName("Japan");
		objCountry.setContinent("Asia");
		objCountry.setFlag("Yes");
		HttpEntity<Country> requestEntity = new HttpEntity<Country>(objCountry, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void updateCountryDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/country";
		Country objCountry = new Country();
		objCountry.setCountryId(10);
		objCountry.setCountryCode(" IND");
		objCountry.setCountryName("India");
		HttpEntity<Country> requestEntity = new HttpEntity<Country>(objCountry, headers);
		restTemplate.put(url, requestEntity);
	}

	public void deleteCountryDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/country/{id}";
		HttpEntity<Country> requestEntity = new HttpEntity<Country>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}

	public static void main(String args[]) {
		RestClientUtils util = new RestClientUtils();
		// util.getCountryByIdDemo();
		util.getAllCountriesDemo();
		// util.addCountryDemo();
		// util.updateCountryDemo();
		// util.deleteCountryDemo();
	}
}

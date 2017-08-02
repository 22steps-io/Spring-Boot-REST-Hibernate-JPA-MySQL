package com.steps.org.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.steps.org.entity.Country;

@Transactional
@Repository
public class CountryDao implements ICountryDao {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAllCountries() {
		String hql = "FROM Country as cntry ORDER BY cntry.countryId";
		return (List<Country>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Country getCountryById(int countryId) {
		return entityManager.find(Country.class, countryId);
	}

	@Override
	public void addCountry(Country country) {
		entityManager.persist(country);
		
	}

	@Override
	public void updateCountry(Country country) {
		Country cntry = getCountryById(country.getCountryId());
		cntry.setCountryCode(country.getCountryCode());
		cntry.setCountryName(country.getCountryName());
		entityManager.flush();
		
	}

	@Override
	public void deleteCountry(int countryId) {
		entityManager.remove(getCountryById(countryId));
		
	}

	@Override
	public boolean countryExists(String countryName, String continent) {
		String hql = "FROM Country as cntry WHERE cntry.countryName = ? and cntry.continent = ?";
		int count = entityManager.createQuery(hql).setParameter(1, countryName)
		              .setParameter(2, continent).getResultList().size();
		return count > 0 ? true : false;
	}
	
}



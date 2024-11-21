package com.springboot.spring_boot_first_app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring_boot_first_app.dtos.CityDTO;
import com.springboot.spring_boot_first_app.dtos.UpdateCityDTO;
import com.springboot.spring_boot_first_app.entities.City;
import com.springboot.spring_boot_first_app.repositories.CityRepository;

import jakarta.transaction.Transactional;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	
	public ArrayList<String> getCities() {
		ArrayList<City> citiesList = (ArrayList<City>) cityRepository.findAll();
		ArrayList<String> response = new ArrayList<String>();
		citiesList.forEach((element) -> response.add(element.getName()));
		
		return response;
	}
	
	public boolean addCity(CityDTO cityDTO) {
		Optional<City> optionalCity = cityRepository.findCityByName(cityDTO.getCityName());
		if(optionalCity.isPresent()) {
			return false;
		} else {
			City city = new City(cityDTO.getCityName());
			cityRepository.save(city);
			return true;
		}
	}
	
	public boolean deleteCity(CityDTO cityDTO) {
		Optional<City> optionalCity = cityRepository.findCityByName(cityDTO.getCityName());
		if(optionalCity.isPresent()) {
			City city = optionalCity.get();
			cityRepository.delete(city);
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional
	public boolean updateCity(UpdateCityDTO updateCityDTO) {
		Optional<City> optionalCity = cityRepository.findCityByName(updateCityDTO.getPreviousName());
		if(optionalCity.isPresent()) {
			cityRepository.updateCityNameByPreviousName(updateCityDTO.getPreviousName(), updateCityDTO.getNewName());
			return true;
		} else {
			return false;
		}
	}
}

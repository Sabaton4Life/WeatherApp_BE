package com.springboot.spring_boot_first_app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring_boot_first_app.dtos.CityDTO;
import com.springboot.spring_boot_first_app.dtos.UpdateCityDTO;
import com.springboot.spring_boot_first_app.services.CityService;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "http://localhost:5173")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping
	private ArrayList<String> getCities() {
		return cityService.getCities();
	}
	
	@PostMapping
	private boolean createCity(@RequestBody CityDTO cityDTO) {
		return cityService.addCity(cityDTO);
	}
	
	@DeleteMapping
	private boolean deleteCity(@RequestBody CityDTO cityDTO) {
		return cityService.deleteCity(cityDTO);
	}
	
	@PutMapping
	private boolean updateCity(@RequestBody UpdateCityDTO updateCityDTO) {
		return cityService.updateCity(updateCityDTO);
	}
	
}

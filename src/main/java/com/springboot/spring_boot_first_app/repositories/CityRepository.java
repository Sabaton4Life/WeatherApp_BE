package com.springboot.spring_boot_first_app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.spring_boot_first_app.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
	Optional<City> findCityByName(String name);
	
	@Query(value = "UPDATE cities SET name=:newName WHERE name=:previousName", nativeQuery = true)
	@Modifying
	void updateCityNameByPreviousName(@Param("previousName") String previousName, @Param("newName") String newName);
}

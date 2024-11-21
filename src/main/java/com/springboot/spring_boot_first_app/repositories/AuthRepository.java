package com.springboot.spring_boot_first_app.repositories;

import org.springframework.stereotype.Repository;

import com.springboot.spring_boot_first_app.entities.City;
import com.springboot.spring_boot_first_app.entities.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AuthRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}

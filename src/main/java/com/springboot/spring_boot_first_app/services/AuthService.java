package com.springboot.spring_boot_first_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.spring_boot_first_app.dtos.UserLoginDTO;
import com.springboot.spring_boot_first_app.dtos.UserRegisterDTO;
import com.springboot.spring_boot_first_app.entities.User;
import com.springboot.spring_boot_first_app.repositories.AuthRepository;

@Service
public class AuthService {
	@Autowired
	private AuthRepository authRepository;
	
	public boolean login(UserLoginDTO userLoginDTO) {
		Optional<User> optionalUser = authRepository.findByUsername(userLoginDTO.getUsername());
		if(optionalUser.isPresent()){
			User registeredUser = optionalUser.get();
			if(registeredUser.getPassword().contentEquals(userLoginDTO.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean register(UserRegisterDTO userRegisterDTO) {
		Optional<User> optionalUser = authRepository.findByUsername(userRegisterDTO.getUsername());
		if(optionalUser.isPresent()) {
			return false;
		} else {
			User user = new User(userRegisterDTO.getUsername(), userRegisterDTO.getPassword());
			authRepository.save(user);
			return true;
		}
	}
}

package com.springboot.spring_boot_first_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring_boot_first_app.dtos.UserLoginDTO;
import com.springboot.spring_boot_first_app.dtos.UserRegisterDTO;
import com.springboot.spring_boot_first_app.services.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login") // corect ar fi GET, POST nu are sens dar POST e mai securizat ca GET si datele de login sunt sensibile si trebuie securizate asa ca folosim POST
	private boolean login(@RequestBody UserLoginDTO userLoginDTO) {
		return authService.login(userLoginDTO);
		
	}
	
	@PostMapping("/register")
	private boolean register(@RequestBody UserRegisterDTO userRegisterDTO ) {
		return authService.register(userRegisterDTO);
		
	}
}

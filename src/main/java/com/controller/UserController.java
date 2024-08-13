package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;
import com.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/newuser")
	public String newUser() {
		return "NewUser";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {
		System.out.println(user.getEmail());
		// db insert
		//dao -> insert ->query -> 
		userRepository.save(user);
		return "NewUser";
	}
}



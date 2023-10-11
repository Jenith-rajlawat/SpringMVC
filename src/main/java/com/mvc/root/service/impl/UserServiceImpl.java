package com.mvc.root.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.root.model.User;
import com.mvc.root.repository.UserRepository;
import com.mvc.root.service.UserService;

@Service
public class UserServiceImpl implements UserService	{

	@Autowired
	private UserRepository userRepo	;
	
	
	@Override
	public void userSignup(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User userLogin(String email, String password) {
		
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User isUserExist(String email) {
		
		return userRepo.findByEmail(email);
	}

}

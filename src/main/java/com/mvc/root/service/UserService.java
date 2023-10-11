package com.mvc.root.service;

import com.mvc.root.model.User;

public interface UserService {

	void userSignup(User user);
	
	User userLogin(String email, String password);
	
	User isUserExist(String email);

}

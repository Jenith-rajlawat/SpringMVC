package com.mvc.root.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.root.model.User;
import com.mvc.root.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping({"/","/login"})
	public String getLogin() {
		return "LoginForm";
	}
	//@ModelAttrubute le line kaam garxa
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		User u= userService.userLogin(user.getEmail(), user.getPassword());
		
		if(u!=null) {
			
			logger.info("--------login success--------");
			
			session.setAttribute("validUser",u);
			session.setMaxInactiveInterval(200);
			//model.addAttribute("fname",u.getFname());
		return "Home";}
		
		logger.info("---------login failed-------");
		model.addAttribute("message","User not found!");
		
		return "LoginForm";
	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "SignupForm";
	}
	//Model model le tio page ma kei namilda or kei message dekhaunu pare tia dekhaidinxa
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User user ,Model model) {
		//check user if already exist
		
		User u=userService.isUserExist(user.getEmail());
		if(u==null) 
			userService.userSignup(user);
		else {
			model.addAttribute("message","User Already Exist!!");
			return "SignupForm";
		}

		return "LoginForm";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();//kills session
		logger.info("--------logout success--------");
		return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
	
		return "Profile";
	}
	
}

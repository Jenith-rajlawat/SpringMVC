package com.mvc.root.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {

	
	@GetMapping("/gallery")
	public String getGallery(Model model,HttpSession session) {
		
		if(session.getAttribute("validUser")==null) {
			
			return "LoginForm";
		}
		
		
		String[] imgNames =new File("src/main/resources/static/Images").list();
		model.addAttribute("imgNameList",imgNames);
		
		
		
		return "GalleryForm";
	}
	
	
	
}

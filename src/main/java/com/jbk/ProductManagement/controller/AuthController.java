package com.jbk.ProductManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.ProductManagement.entity.User;
import com.jbk.ProductManagement.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/login")
	public ModelAndView  loginProcess(@ModelAttribute User user,Model model ) {
	User usr=	service.loginProcess(user);
	if(usr!=null) {
		return new ModelAndView("home");
	}
	else {
		//model.addAttribute("msg", "Invalid Credientials !!");
		return new ModelAndView("login","msg","Invalid Credientials !!");
	}
		
		
		
		
	}

}

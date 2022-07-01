package com.jbk.ProductManagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.ProductManagement.entity.User;
import com.jbk.ProductManagement.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/login")
	public ModelAndView  loginProcess(@ModelAttribute User user,Model model,HttpSession session ) {
	User usr=	service.loginProcess(user);
	if(usr!=null) {
	String username=usr.getUsername();
	String role=usr.getRole();
	session.setAttribute("username", username);
	session.setAttribute("role", role);
		return new ModelAndView("home");
	}
	else {
		//model.addAttribute("msg", "Invalid Credientials !!");
		return new ModelAndView("login","msg","Invalid Credientials !!");
	}
		
		
		
		
	}
	
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpSession httpSession,@RequestParam String username) {
		
		
		httpSession.removeValue(username);
		return new ModelAndView("login","msg","Logout Successfully !!");
		
	}

}

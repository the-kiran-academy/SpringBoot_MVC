package com.jbk.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.ProductManagement.entity.User;
import com.jbk.ProductManagement.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping(value = "/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		 boolean b= service.addUser(user);
		 if(b) {
			return new ModelAndView("addUser","msg","Added Successfully !"); 
		 }else {
				return new ModelAndView("addUser","msg","User Not Added Check User Already Exist !"); 
 
		 }
		
	}
	
	@GetMapping(value = "/listOfUser")
	public ModelAndView listOfUSer() {
	List<User> users=	service.listOfUser();
	if(users.isEmpty()) {
		
		return new ModelAndView("listOfUser","msg","No User Found !!");
	}else{
		System.out.println(users);
		return new ModelAndView("listOfUser","users",users);
	}
		
		
	}

}

package com.jbk.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.ProductManagement.entity.User;
import com.jbk.ProductManagement.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value = "/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		boolean b = service.addUser(user);
		if (b) {
			return new ModelAndView("addUser", "msg", "Added Successfully !");
		} else {
			return new ModelAndView("addUser", "msg", "User Not Added Check User Already Exist !");

		}

	}

	@GetMapping(value = "/listOfUser")
	public ModelAndView listOfUSer(@RequestParam String msg, Model model) {
		List<User> users = service.listOfUser();
		if (users.isEmpty()) {

			return new ModelAndView("listOfUser", "msg", "No User Found !!");
		} else {

			if (!msg.equals("null")) {
				model.addAttribute("msg", msg);
			}

			model.addAttribute("userList", users);
			return new ModelAndView("listOfUser");
		}

	}

	@GetMapping(value = "/deleteUser")
	public String deleteUser(@RequestParam String username) {

		boolean b = service.deleteUser(username);

		if (b) {

			return "redirect:/listOfUser?msg=Deleted !!";
		} else {
			return "redirect:/listOfUser?msg=Not Deleted !!";
		}

	}

	@GetMapping(value = "/profile")
	public ModelAndView editUser(@RequestParam String username) {
		User user = service.profile(username);
		System.out.println(user);
		if (user != null) {
			return new ModelAndView("profile", "user", user);
		} else {
			return new ModelAndView("profile", "msg", "Profile Not Found");
		}

	}

	@PostMapping(value = "/updateUser")
	public ModelAndView updateUser(@ModelAttribute User user,Model model) {
		boolean b = service.updateUser(user);
		if(b) {
			model.addAttribute("msg", "Profile Updated !!");
			model.addAttribute("user", user);
			return new ModelAndView("profile");
		} else {
			model.addAttribute("msg", "Profile Not Updated !!");
			return new ModelAndView("profile");
		}

	}

}

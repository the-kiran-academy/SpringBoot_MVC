package com.jbk.ProductManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping(value = "/")
	public String indexPage() {
		return "login";

	}
	@GetMapping(value = "/homePage")
	public String homePage() {
		return "home";

	}
	
	@GetMapping(value = "/addUserPage")
	public String addUserPage() {
		return "addUser";

	}
	
	@GetMapping(value = "/importUserPage")
	public String importUserPage() {
		return "importUser";

	}
	
	@GetMapping(value = "/addProductFormPage")
	public String addProductFormPage() {
		return "addProduct_form";

	}

}

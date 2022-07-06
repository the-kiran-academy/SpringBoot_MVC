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

import com.jbk.ProductManagement.entity.Product;
import com.jbk.ProductManagement.entity.User;
import com.jbk.ProductManagement.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping(value = "/addProduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		boolean b = service.addProduct(product);
		if (b) {
			return new ModelAndView("addProduct", "msg", "Added Successfully !");
		} else {
			return new ModelAndView("addProduct", "msg", "Product Not Added Check Product Already Exist Or Not!");

		}

	}

	@GetMapping(value = "/listOfProducts")
	public ModelAndView listOfProducts(Model model) {
		List<Product> products = service.listOfProduct();
		if (products.isEmpty()) {

			return new ModelAndView("listOfUser", "msg", "No User Found !!");
		} else {
			model.addAttribute("productList", products);
			return new ModelAndView("listOfProduct");
		}

	}

	@GetMapping(value = "/deleteProduct")
	public ModelAndView deleteUser(@RequestParam String productName, Model model) {

		boolean b = service.deleteProduct(productName);
		List<Product> productList = null;
		if (b) {
			productList = service.listOfProduct();
			model.addAttribute("productList", productList);
			model.addAttribute("msg", "Product Deleted !!");
			return new ModelAndView("listOfProduct");
		} else {
			model.addAttribute("msg", "Product Not Deleted !!");
			model.addAttribute(productList);
			return new ModelAndView("listOfProduct");
		}

	}
	
	@GetMapping(value = "/profiles")
	public ModelAndView getProduct(@RequestParam String productId) {
		Product product = service.findProductById(productId);
	
		if (product != null) {
			return new ModelAndView("productForm_edit", "product", product);
		} else {
			return new ModelAndView("productForm_edit", "msg", "Product Not Found");
		}

	}
	
	@PostMapping(value = "/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute Product product,Model model) {
		boolean b = service.updateProduct(product);
		if(b) {
			model.addAttribute("msg", "Product Updated !!");
			model.addAttribute("product", product);
			return new ModelAndView("productForm_edit");
		} else {
			model.addAttribute("msg", "Product Not Updated !!");
			return new ModelAndView("productForm_edit");
		}

	}

}

package com.jbk.ProductManagement.service;

import java.util.List;

import com.jbk.ProductManagement.entity.Product;


public interface ProductService {
	
	public boolean addProduct(Product product);
	public Product findProductById(String productId);
	public List<Product> listOfProduct();
	public boolean deleteProduct(String ProductId);
	public boolean updateProduct(Product Product);

}

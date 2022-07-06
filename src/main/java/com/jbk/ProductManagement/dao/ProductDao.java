package com.jbk.ProductManagement.dao;

import java.util.List;

import com.jbk.ProductManagement.entity.Product;

public interface ProductDao {
	 public boolean addProduct(Product product);

	public Product findProductById(String productId);

	public List<Product> listOfProduct();

	public boolean deleteProduct(String productId);

	public boolean updateProduct(Product product);

}

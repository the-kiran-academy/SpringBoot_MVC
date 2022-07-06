package com.jbk.ProductManagement.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.ProductManagement.dao.ProductDao;
import com.jbk.ProductManagement.entity.Product;

@Service
public class ProductService_impl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	 public boolean addProduct(Product product) {
		String productId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProcudtId(productId);
		return dao.addProduct(product);
	}

	@Override
	public Product findProductById(String productId) {
		
		return dao.findProductById(productId);
	}

	@Override
	public List<Product> listOfProduct() {
		
		return dao.listOfProduct();
	}

	@Override
	public boolean deleteProduct(String productId) {
		
		return dao.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}

}

package com.jbk.ProductManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement.entity.Product;
import com.jbk.ProductManagement.entity.User;

@Repository
public class ProductDao_impl implements ProductDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addProduct(Product product) {
		Session session = null;
		boolean b = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();

			Product usr = session.get(Product.class, product.getProcudtId());
			if (usr == null) {
				session.save(product);
				transaction.commit();
				b = true;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public Product findProductById(String productId) {
		Session session = null;
		Product product = null;
		try {
			session = sf.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;
	}

	@Override
	public List<Product> listOfProduct() {
		Session session = null;
		List<Product> products = new ArrayList<>();
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}

	@Override
	public boolean deleteProduct(String ProductId) {
		Session session = null;
		boolean b = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = session.load(Product.class, ProductId);
			session.delete(product);

			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = null;
		boolean b = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}

package com.jbk.ProductManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement.entity.User;

@Repository
public class UserDao_impl implements UserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public User loginProcess(User user) {
		Session session = null;
		User usr = null;
		try {
			session = sf.openSession();
			usr = session.get(User.class, user.getUsername());
			if (usr != null) {
				if (user.getPassword().equals(usr.getPassword())) {
					return usr;
				} else {
					usr = null;
				}
			} else {

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usr;

	}

	@Override
	public boolean addUser(User user) {
		Session session = null;
		boolean b = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();

			User usr = session.get(User.class, user.getUsername());
			if (usr == null) {
				session.save(user);
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
	public List<User> listOfUser() {
		Session session = null;
		List<User> users = new ArrayList<>();
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(User.class);
			users = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public boolean deleteUser(String username) {
		Session session = null;
		boolean b = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			User user = session.load(User.class, username);
			session.delete(user);

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
	public User profile(String username) {
		Session session = null;
		User user = null;
		try {
			session = sf.openSession();
			user = session.get(User.class, username);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		Session session = null;
		boolean b = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}

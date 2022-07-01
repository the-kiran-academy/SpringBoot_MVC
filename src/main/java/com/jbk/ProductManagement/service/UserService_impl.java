package com.jbk.ProductManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.ProductManagement.dao.UserDao;
import com.jbk.ProductManagement.entity.User;

@Service
public class UserService_impl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User loginProcess(User user) {
		User usr = dao.loginProcess(user);
		return usr;
	}

	@Override
	public boolean addUser(User user) {
		boolean b = dao.addUser(user);
		return b;
	}

	@Override
	public List<User> listOfUser() {
		List<User> users = dao.listOfUser();
		return users;
	}

	@Override
	public boolean deleteUser(String username) {

		return dao.deleteUser(username);
	}

	@Override
	public User profile(String username) {
		return dao.profile(username);
	}

	@Override
	public boolean updateUser(User user) {

		return dao.updateUser(user);
	}

}

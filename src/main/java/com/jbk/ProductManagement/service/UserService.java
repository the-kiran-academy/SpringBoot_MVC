package com.jbk.ProductManagement.service;

import java.util.List;

import com.jbk.ProductManagement.entity.User;

public interface UserService {

	public User loginProcess(User user);
	public boolean addUser(User user);
	public List<User> listOfUser();
}

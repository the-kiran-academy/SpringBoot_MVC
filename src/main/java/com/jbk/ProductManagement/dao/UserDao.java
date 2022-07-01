package com.jbk.ProductManagement.dao;

import java.util.List;

import com.jbk.ProductManagement.entity.User;

public interface UserDao {
	public User loginProcess(User user);
	public boolean addUser(User user);
	public List<User> listOfUser();
	public boolean deleteUser(String username);
	public User profile(String username);
	public boolean updateUser(User user);


}

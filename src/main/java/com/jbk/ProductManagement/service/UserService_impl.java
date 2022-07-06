package com.jbk.ProductManagement.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

	@Override
	public int uploadUserSheet(CommonsMultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("WEB-INF/uploaded");
		System.out.println("path=" + path);
		String fileName = file.getOriginalFilename();
		System.out.println("file name=" + fileName);
		int count=0;
		try {
			byte[] data = file.getBytes();
			FileOutputStream fos = new FileOutputStream(new File(path + File.separator + fileName));
			fos.write(data);//uploaded
			
			List<User> list=readExcel(path + File.separator + fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return count;
	}

	private List<User> readExcel(String filePath) {
		
		return null;
	}

}

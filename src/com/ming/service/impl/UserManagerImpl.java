package com.ming.service.impl;

import java.util.List;

import com.ming.dao.UserDao;
import com.ming.entity.User;
import com.ming.service.UserManager;

public class UserManagerImpl implements UserManager {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}
	
	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}
	

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean delUser(String id) {

		return userDao.delUser(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

}

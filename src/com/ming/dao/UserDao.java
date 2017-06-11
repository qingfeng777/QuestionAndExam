package com.ming.dao;

import java.util.List;

import com.ming.entity.User;

public interface UserDao {

	public User getUser(int id);
	
	public User getUserByName(String name);

	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public void updateUser(User user);

	
}

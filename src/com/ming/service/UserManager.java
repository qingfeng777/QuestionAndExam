package com.ming.service;

import java.util.List;

import com.ming.entity.Teacher;
import com.ming.entity.User;

public interface UserManager {

	public User getUser(int i);

	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public void updateUser(User user);

	public User getUserByName(String name);

}

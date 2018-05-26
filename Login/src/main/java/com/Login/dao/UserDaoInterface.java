package com.Login.dao;

import java.util.List;

import com.Login.entity.User;

public interface UserDaoInterface {

	public List<User> getUsers();
	public User getUser(String userId);
	public User createUser(User user);
	public User updateUser(User user);
	
	public void deleteUser(User user);
	
}

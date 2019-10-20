package com.ga.dao;


import java.util.List;

import com.ga.entity.User;

public interface UserDao {


	public List<User> listUsers();
	public User signup(User user);
	public User login(User user);
	public User addSong(String username, Long songId);
	public User getUserByUsername(String username);
	
}

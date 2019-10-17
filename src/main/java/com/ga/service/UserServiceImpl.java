package com.ga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ga.dao.UserDao;
import com.ga.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	@Override
	public User signup(User user) {
		return userDao.signup(user);
	}
	
	@Override
	public Long login(User user) {
		return userDao.login(user).getUserId();
	}
	
	 @Override
	    public User addSong(String username, int songId) {
	        return userDao.addSong(username, songId);
	    }
}

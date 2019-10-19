package com.ga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ga.dao.UserProfileDao;
import com.ga.entity.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileDao userProfileDao;

	@Override
	public UserProfile createUserProfile(String username, UserProfile newProfile) {
		return userProfileDao.createUserProfile(username, newProfile);
	}

	@Override
	public UserProfile getUserProfile(String username) {
		return userProfileDao.getUserProfile(username);
	}	


}

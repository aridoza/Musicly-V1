package com.ga.dao;

import com.ga.entity.UserProfile;

public interface UserProfileDao {
	
	public UserProfile createUserProfile(String username, UserProfile newProfile);
	
	public UserProfile getUserProfile(String username);

}

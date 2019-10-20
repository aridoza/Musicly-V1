package com.ga.service;

import com.ga.entity.UserProfile;

public class UserProfileServiceStub implements UserProfileService{


    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
       UserProfile userProfile = new UserProfile();
       
       userProfile.setEmail("test@test.com");
    
       return userProfile;
    }   

	@Override
	public UserProfile getUserProfile(String username) {
		UserProfile userProfile = new UserProfile();

		userProfile.setEmail("test@test.com");

		return userProfile;
	}
}

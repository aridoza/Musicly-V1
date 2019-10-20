package com.ga.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ga.entity.UserProfile;
import com.ga.service.UserProfileServiceStub;

public class UserProfileControllerTest {

	private UserProfileController userProfileController;

	private UserProfile userProfile;

	@Before
	public void initializeUserProfileController() {
		userProfileController = new UserProfileController();
		userProfileController.setUserProfileService(new UserProfileServiceStub());
	}
	
	@Before
	public void initializeUserProfile() {
		userProfile = new UserProfile();

		userProfile.setProfileId(1L);
		userProfile.setEmail("test@test.com");
		userProfile.setAddress("Test City");
		userProfile.setMobile("111-111-1111");
	}

	@Test
	public void createUserProfile_SaveUserProfile_Success() {
		UserProfile userProfile = new UserProfile();

		userProfile.setEmail("test@test.com");

		UserProfile newProfile = userProfileController.createUserProfile("test", userProfile);

		assertNotNull(newProfile);
		assertEquals(newProfile.getEmail(), userProfile.getEmail());
	}

	@Test
	public void getUserProfile_UserProfile_Success() {

		UserProfile newProfile = userProfileController.getUserProfile("batman");

		assertNotNull(newProfile);
		assertEquals(newProfile.getEmail(), userProfile.getEmail());
	}
}
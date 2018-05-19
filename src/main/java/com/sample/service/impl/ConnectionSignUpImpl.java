package com.sample.service.impl;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.sample.entity.User;

public class ConnectionSignUpImpl implements ConnectionSignUp {

	private final SignupServiceImpl signupService;

	public ConnectionSignUpImpl(SignupServiceImpl signupService) {
		this.signupService = signupService;
	}

	/**
	 * Returned value is used as primary key of UserConnection table
	 */
	@Override
	public String execute(Connection<?> connection) {
		UserProfile profile = connection.fetchUserProfile();
		User user = signupService.createUser(profile);
		return user.getUserId();
	}
}

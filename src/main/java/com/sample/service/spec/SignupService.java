package com.sample.service.spec;

import org.springframework.social.connect.UserProfile;

import com.sample.entity.User;

public interface SignupService {

	User createUser(UserProfile userProfile);

}

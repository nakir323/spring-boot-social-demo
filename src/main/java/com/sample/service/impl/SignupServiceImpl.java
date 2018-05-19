package com.sample.service.impl;

import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.UserRepository;
import com.sample.entity.User;
import com.sample.service.spec.SignupService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SignupServiceImpl implements SignupService {

	private final UserRepository userRepository;

	@Transactional
	@Override
	public User createUser(UserProfile userProfile) {
		String userId = "";
		boolean userIdDecided = false;

		while (!userIdDecided) {
			userId = RandomStringUtils.randomAlphanumeric(8);
			User user = userRepository.findOne(userId);
			if (Objects.isNull(user)) {
				userIdDecided = true;
			}
		}

		User newUser = new User();
		newUser.setUserId(userId);
		newUser.setUsername(RandomStringUtils.randomAlphanumeric(32));
		newUser.setDisplayName(userProfile.getUsername());
		newUser.setEncodedPassword(RandomStringUtils.randomAlphanumeric(32));
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}

}
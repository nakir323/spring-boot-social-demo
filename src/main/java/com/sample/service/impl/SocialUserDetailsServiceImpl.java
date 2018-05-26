package com.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import com.sample.data.SocialUserData;
import com.sample.entity.User;
import com.sample.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SocialUserDetailsServiceImpl implements SocialUserDetailsService {

	private final UserRepository userRepository;

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
		User user = userRepository.findOne(userId);
		return new SocialUserData(user);
	}

}
package com.sample.data;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.social.security.SocialUser;

import com.sample.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SocialUserData extends SocialUser {

	private static final long serialVersionUID = -6777354505894674279L;
	private User user;

	public SocialUserData(User user) {
		super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

	@Override
	public String getUserId() {
		return String.valueOf(user.getUserId());
	}
}

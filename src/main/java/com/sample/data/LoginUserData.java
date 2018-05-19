package com.sample.data;

import org.springframework.security.core.authority.AuthorityUtils;

import com.sample.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserData extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = -5892147272020536048L;
	private User user;

	public LoginUserData(User user) {
		super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

}

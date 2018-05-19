package com.sample.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

import com.sample.service.impl.ConnectionSignUpImpl;
import com.sample.service.impl.SignupServiceImpl;
import com.sample.service.spec.UserContext;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

	private final DataSource dataSource;
	private final SignupServiceImpl signupService;
	private final UserContext userContext;

	public SocialConfig(DataSource dataSource, SignupServiceImpl signupService, UserContext userContext) {
		this.dataSource = dataSource;
		this.signupService = signupService;
		this.userContext = userContext;
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText()); // TODO change Encryptor
		repository.setConnectionSignUp(new ConnectionSignUpImpl(signupService));
		return repository;
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Twitter twitter(UsersConnectionRepository usersConnectionRepository) {
		return usersConnectionRepository.createConnectionRepository(userContext.getUserId().get())
				.findPrimaryConnection(Twitter.class).getApi();
	}

}
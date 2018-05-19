package com.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialAuthenticationToken;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private Twitter twitter;

	@GetMapping(path = "/")
	String showMainPage(HttpServletRequest request, Map<String, Object> model) {
		writeTweetIdIfLoggedInWithTwitter();
		return "main/main";
	}

	private void writeTweetIdIfLoggedInWithTwitter() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof SocialAuthenticationToken) {
			long tweetId = twitter.timelineOperations().getUserTimeline().get(0).getId();
			System.out.println(tweetId);
			// when you want to tweet
			// twitter.timelineOperations().updateStatus("Hello!!");
		}
	}

}
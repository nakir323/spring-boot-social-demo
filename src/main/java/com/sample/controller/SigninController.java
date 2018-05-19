package com.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {

	@GetMapping(path = "/signin")
	String showMainPage(HttpServletRequest request, Map<String, Object> model) {
		return "main/signin";
	}

}
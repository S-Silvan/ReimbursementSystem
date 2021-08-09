package com.ers.service;

import javax.servlet.http.HttpServletRequest;

public interface OAuthService {
	boolean login(String userid, String password, HttpServletRequest request);
	boolean authorize(HttpServletRequest request);
	boolean logout(HttpServletRequest request);
}

package com.ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.OAuthService;
import com.ers.service.OAuthServiceImplementation;

public class OAuthController {
	private OAuthService oAuthService=new OAuthServiceImplementation();
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("employee-id");
		String password=request.getParameter("employee-password");
		boolean result=oAuthService.login(userId, password, request);
		System.out.println(result);
	}
	public void authorize() {
		
	}
	public void logout() {
		
	}
}

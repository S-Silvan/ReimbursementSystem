package com.ers.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ers.dao.OAuthDao;
import com.ers.dao.OAuthDaoImplementation;
import com.ers.model.Employee;
import com.ers.util.LoggerUtil;

public class OAuthServiceImplementation implements OAuthService{
	private OAuthDao oAuthDao=new OAuthDaoImplementation();
	
	@Override
	public Employee login(String userid, String password) {
		LoggerUtil.getLog().info("Login "+userid);
		Employee employee=oAuthDao.login(userid, password);
		return employee;
	}
	
	@Override
	public boolean logout(HttpServletRequest request) {
		LoggerUtil.getLog().info("Logout");
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("employee", null);
		return true;
	}
}

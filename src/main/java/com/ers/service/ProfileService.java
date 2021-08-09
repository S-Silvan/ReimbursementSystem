package com.ers.service;

import javax.servlet.http.HttpServletRequest;

import com.ers.model.Employee;

public interface ProfileService extends OAuthService{
	Employee getEmployeeProfile(HttpServletRequest request);
	boolean updateProfile(Employee employee);
}

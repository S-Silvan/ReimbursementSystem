package com.ers.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ers.dao.ProfileDao;
import com.ers.dao.ProfileDaoImplementation;
import com.ers.model.Employee;
import com.ers.util.LoggerUtil;

public class ProfileServiceImplementation extends OAuthServiceImplementation implements ProfileService {
	private ProfileDao profileDao=new ProfileDaoImplementation();

	@Override
	public Employee getEmployeeProfile(HttpServletRequest request) {
		LoggerUtil.getLog().info("Read profile");
		HttpSession httpSession=request.getSession();
		Employee employee=(Employee)httpSession.getAttribute("employee");
		return employee;
	}

	@Override
	public boolean updateProfile(Employee employee) {
		LoggerUtil.getLog().info("Update profile");
		boolean isUpdated=profileDao.updateEmployee(employee);
		return isUpdated;
	}

}

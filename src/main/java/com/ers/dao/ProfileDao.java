package com.ers.dao;

import com.ers.model.Employee;

public interface ProfileDao extends OAuthDao{
	boolean updateEmployee(Employee employee);
	Employee readOneEmployee(Integer employeeId);
}

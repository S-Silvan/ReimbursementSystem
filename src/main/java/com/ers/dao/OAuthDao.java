package com.ers.dao;

import com.ers.model.Employee;

public interface OAuthDao {
	Employee login(String email,String password);
	boolean authorize(Employee e);
}

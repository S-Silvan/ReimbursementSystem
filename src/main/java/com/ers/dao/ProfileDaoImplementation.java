package com.ers.dao;

import org.hibernate.Transaction;

import com.ers.model.Employee;

public class ProfileDaoImplementation extends OAuthDaoImplementation implements ProfileDao {
	@Override
	public boolean updateEmployee(Employee employee) {
		Transaction transaction=null;
		boolean isUpdated=false;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.update(employee);
			transaction.commit();
			isUpdated=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public Employee readOneEmployee(Integer employeeId) {
		Employee employee=null;
		try {
			session=sessionFactory.openSession();
			employee=(Employee) session.get(Employee.class, employeeId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

}

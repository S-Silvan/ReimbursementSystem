package com.ers.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ers.model.Employee;
import com.ers.util.HibernateUtil;

public class OAuthDaoImplementation implements OAuthDao {
	protected SessionFactory sessionFactory=HibernateUtil.getSessionFactory(); 
	protected Session session=null;
	
	@Override
	public Employee login(String email, String password) {
		Employee employee=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			Disjunction disjunction=Restrictions.disjunction(Restrictions.eq("email", email),
															Restrictions.eq("password", password));
			criteria.add(disjunction);
			List<Employee> employees=criteria.list();
			if(!employees.isEmpty())
				employee=employees.get(0);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return employee;
	}
	
	@Override
	public boolean authorize(Employee employee) {
		boolean result=false;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			Disjunction disjunction=Restrictions.disjunction(Restrictions.eq("email", employee.getEmail()),
															Restrictions.eq("id",employee.getId()));
			criteria.add(disjunction);
			List<Employee> employees=criteria.list();
			if(!employees.isEmpty())
				result=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return result;
	}

}

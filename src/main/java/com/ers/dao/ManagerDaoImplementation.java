package com.ers.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;

public class ManagerDaoImplementation extends ProfileDaoImplementation implements ManagerDao {
	@Override
	public int insertEmployee(Employee employee) {
		Transaction transaction=null;
		int key=0;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			key=(int)session.save(employee);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return key;
	}
	
	@Override
	public List<ReimbursementRequest> readPendingReimbursementRequest() {
		List<ReimbursementRequest> reimbursementRequestList=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(ReimbursementRequest.class);
			Criterion criterian1=Restrictions.eq("status","Pending");
			criteria.add(criterian1);
			reimbursementRequestList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return reimbursementRequestList;
	}

	@Override
	public List<ReimbursementRequest> readResolvedReimbursementRequest() {
		List<ReimbursementRequest> reimbursementRequestList=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(ReimbursementRequest.class);
			criteria.add(Restrictions.not(Restrictions.eq("status","Pending")));
			reimbursementRequestList=criteria.list();
			for(ReimbursementRequest rd:reimbursementRequestList)
				rd.getEmployee();
		}catch(Exception e){
			e.printStackTrace();
		}
		return reimbursementRequestList;
	}

	@Override
	public boolean updateReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		Transaction transaction=null;
		boolean result=false;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			ReimbursementRequest reimbursementRequestD=session.load(ReimbursementRequest.class, reimbursementRequest.getId());
			reimbursementRequestD.setStatus(reimbursementRequest.getStatus());
			session.update(reimbursementRequestD);
			transaction.commit();
			result=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Employee> readAllEmployee() {
		List<Employee> employeeList=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			employeeList=criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

}

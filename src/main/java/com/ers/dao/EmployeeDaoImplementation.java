package com.ers.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ers.model.ReimbursementRequest;

public class EmployeeDaoImplementation extends ProfileDaoImplementation implements EmployeeDao{
	@Override
	public int insertReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(reimbursementRequest);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ReimbursementRequest> readPendingReimbursementRequest(Integer userId) {
		List<ReimbursementRequest> reimbursementRequestList=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(ReimbursementRequest.class);
			Conjunction conjunction=Restrictions.conjunction(Restrictions.eq("status","Pending"),
																Restrictions.eq("employee.id",userId));
			criteria.add(conjunction);
			reimbursementRequestList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return reimbursementRequestList;
	}

	@Override
	public List<ReimbursementRequest> readResolvedReimbursementRequest(Integer userId) {
		List<ReimbursementRequest> reimbursementRequestList=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(ReimbursementRequest.class);
			Conjunction conjunction=Restrictions.conjunction(Restrictions.not(Restrictions.eq("status","Pending")),
					Restrictions.eq("employee.id",userId));
			
			criteria.add(conjunction);
			reimbursementRequestList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return reimbursementRequestList;
	}
}

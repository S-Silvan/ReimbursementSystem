package com.ers.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ers.model.ReimbursementRequest;
import com.ers.util.HibernateUtil;

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
		}finally {
			if(session!=null)
				session.close();
		}
		return 0;
	}

	@Override
	public List<ReimbursementRequest> readPendingReimbursementRequest(Integer userId) {
		List<ReimbursementRequest> reimbursementRequestList=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(ReimbursementRequest.class);
			Criterion criterian1=Restrictions.eq("reimbursement_request_status","Pending");
			Criterion criterian2=Restrictions.eq("employee_employee_id",userId);
			criteria.add(criterian1);
			criteria.add(criterian2);
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
			Disjunction disjunction=Restrictions.disjunction();
			disjunction.add(Restrictions.eq("reimbursement_request_status","Accepted"));
			disjunction.add(Restrictions.eq("reimbursement_request_status","Cancelled"));
			disjunction.add(Restrictions.eq("employee_employee_id",userId));
			criteria.add(disjunction);
			reimbursementRequestList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return reimbursementRequestList;
	}
}

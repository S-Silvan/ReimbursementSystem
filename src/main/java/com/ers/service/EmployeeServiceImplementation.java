package com.ers.service;

import java.util.List;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImplementation;
import com.ers.model.ReimbursementRequest;

public class EmployeeServiceImplementation extends ProfileServiceImplementation implements EmployeeService {
	private EmployeeDao employeeDao=new EmployeeDaoImplementation();
	
	@Override
	public boolean submitReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		int result=employeeDao.insertReimbursementRequest(reimbursementRequest);
		return result!=0;
	}

	@Override
	public List<ReimbursementRequest> getPendingReiumbursementRequest(Integer userId) {
		List<ReimbursementRequest> pendingReimbursementRequests=employeeDao.readPendingReimbursementRequest(userId);
		return pendingReimbursementRequests;
	}
	
	@Override
	public List<ReimbursementRequest> getResolvedReimbursementRequest(Integer userId) {
		List<ReimbursementRequest> resolvedReimbursementRequests=employeeDao.readResolvedReimbursementRequest(userId);
		return resolvedReimbursementRequests;
	}
}

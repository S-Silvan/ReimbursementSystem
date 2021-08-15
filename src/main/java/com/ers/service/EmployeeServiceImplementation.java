package com.ers.service;

import java.util.List;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImplementation;
import com.ers.model.ReimbursementRequest;
import com.ers.util.LoggerUtil;

public class EmployeeServiceImplementation extends ProfileServiceImplementation implements EmployeeService {
	private EmployeeDao employeeDao=new EmployeeDaoImplementation();
	
	@Override
	public boolean submitReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		LoggerUtil.getLog().info("Reimbursment request submit of employee");
		int result=employeeDao.insertReimbursementRequest(reimbursementRequest);
		return result!=0;
	}

	@Override
	public List<ReimbursementRequest> getPendingReiumbursementRequest(Integer userId) {
		LoggerUtil.getLog().info("Read pending reimbursement request of employee");
		List<ReimbursementRequest> pendingReimbursementRequests=employeeDao.readPendingReimbursementRequest(userId);
		return pendingReimbursementRequests;
	}
	
	@Override
	public List<ReimbursementRequest> getResolvedReimbursementRequest(Integer userId) {
		LoggerUtil.getLog().info("Read resolved reimbursement request of employee");
		List<ReimbursementRequest> resolvedReimbursementRequests=employeeDao.readResolvedReimbursementRequest(userId);
		return resolvedReimbursementRequests;
	}
}

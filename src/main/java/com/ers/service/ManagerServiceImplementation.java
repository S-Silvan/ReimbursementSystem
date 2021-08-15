package com.ers.service;

import java.util.List;

import com.ers.dao.ManagerDao;
import com.ers.dao.ManagerDaoImplementation;
import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;
import com.ers.util.LoggerUtil;

public class ManagerServiceImplementation extends ProfileServiceImplementation implements ManagerService {
	private ManagerDao managerDao=new ManagerDaoImplementation();
	
	@Override
	public boolean insertEmployee(Employee employee) {
		LoggerUtil.getLog().info("Insert employee of manager");
		int result=managerDao.insertEmployee(employee);
		return result!=0;
	}

	@Override
	public boolean updateReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		LoggerUtil.getLog().info("Update reimbursement request of manager");
		boolean isUpdated=managerDao.updateReimbursementRequest(reimbursementRequest);
		return isUpdated;
	}
	
	@Override
	public List<ReimbursementRequest> getPendingReiumbursementRequest() {
		LoggerUtil.getLog().info("Read pending reimbursement request of manager");
		List<ReimbursementRequest> pendingReimbursementRequests=managerDao.readPendingReimbursementRequest();
		return pendingReimbursementRequests;
	}
	
	@Override
	public List<ReimbursementRequest> getResolvedReimbursementRequest() {
		LoggerUtil.getLog().info("Read resolved reimbursement request of manager");
		List<ReimbursementRequest> resolvedReimbursementRequests=managerDao.readResolvedReimbursementRequest();
		return resolvedReimbursementRequests;
	}
	
	@Override
	public List<ReimbursementRequest> getReimbursementRequestOfOneEmployee(Integer employeeId){
		LoggerUtil.getLog().info("Read reimbursement request of one employee");
		List<ReimbursementRequest> reimbursementRequestOfOneEmployee=managerDao.readReimbursementRequestOfOneEmployee(employeeId);
		return reimbursementRequestOfOneEmployee;
	}

	@Override
	public List<Employee> readAllEmployee() {
		LoggerUtil.getLog().info("Read all employee");
		List<Employee> employees=managerDao.readAllEmployee();
		return employees;
	}

}

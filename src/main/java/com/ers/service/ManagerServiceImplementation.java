package com.ers.service;

import java.util.List;

import com.ers.dao.ManagerDao;
import com.ers.dao.ManagerDaoImplementation;
import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;

public class ManagerServiceImplementation extends ProfileServiceImplementation implements ManagerService {
	private ManagerDao managerDao=new ManagerDaoImplementation();
	
	@Override
	public boolean insertEmployee(Employee employee) {
		int result=managerDao.insertEmployee(employee);
		return result!=0;
	}

	@Override
	public boolean updateReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		boolean isUpdated=managerDao.updateReimbursementRequest(reimbursementRequest);
		return isUpdated;
	}
	
	@Override
	public List<ReimbursementRequest> getPendingReiumbursementRequest() {
		List<ReimbursementRequest> pendingReimbursementRequests=managerDao.readPendingReimbursementRequest();
		return pendingReimbursementRequests;
	}
	
	@Override
	public List<ReimbursementRequest> getResolvedReimbursementRequest() {
		List<ReimbursementRequest> resolvedReimbursementRequests=managerDao.readResolvedReimbursementRequest();
		return resolvedReimbursementRequests;
	}
	
	@Override
	public List<ReimbursementRequest> getReimbursementRequestOfOneEmployee(Integer employeeId){
		List<ReimbursementRequest> reimbursementRequestOfOneEmployee=managerDao.readReimbursementRequestOfOneEmployee(employeeId);
		return reimbursementRequestOfOneEmployee;
	}

	@Override
	public List<Employee> readAllEmployee() {
		List<Employee> employees=managerDao.readAllEmployee();
		return employees;
	}

}

package com.ers.service;

import java.util.List;

import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;

public interface ManagerService extends ProfileService{
	boolean insertEmployee(Employee employee);
	boolean updateReimbursementRequest(ReimbursementRequest reimbursementRequest);
	List<ReimbursementRequest> getPendingReiumbursementRequest();
	List<ReimbursementRequest> getResolvedReimbursementRequest();
	List<Employee> readAllEmployee();
}

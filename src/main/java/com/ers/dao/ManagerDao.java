package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;

public interface ManagerDao{
	int insertEmployee(Employee employee);
	boolean updateReimbursementRequest(ReimbursementRequest reimbursementRequest);
	List<Employee> readAllEmployee();
	List<ReimbursementRequest> readPendingReimbursementRequest();
	List<ReimbursementRequest> readResolvedReimbursementRequest();
	List<ReimbursementRequest> readReimbursementRequestOfOneEmployee(Integer employeeId);
}

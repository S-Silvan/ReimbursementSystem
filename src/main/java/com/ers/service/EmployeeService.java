package com.ers.service;

import java.util.List;

import com.ers.model.ReimbursementRequest;

public interface EmployeeService extends ProfileService {
	boolean submitReimbursementRequest(ReimbursementRequest reimbursementRequest);
	List<ReimbursementRequest> getPendingReiumbursementRequest(Integer userId);
	List<ReimbursementRequest> getResolvedReimbursementRequest(Integer userId);
}

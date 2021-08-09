package com.ers.dao;

import java.util.List;

import com.ers.model.ReimbursementRequest;

public interface EmployeeDao extends ProfileDao{
	int insertReimbursementRequest(ReimbursementRequest reimbursementRequest);
	List<ReimbursementRequest> readPendingReimbursementRequest(Integer userId);
	List<ReimbursementRequest> readResolvedReimbursementRequest(Integer userId);
}

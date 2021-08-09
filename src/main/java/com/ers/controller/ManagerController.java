package com.ers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;
import com.ers.service.ManagerService;
import com.ers.service.ManagerServiceImplementation;

public class ManagerController extends ProfileController{
	private ManagerService managerService=new ManagerServiceImplementation();
	
	public void displayPendingReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		List<ReimbursementRequest> pendingReimbursementRequest=managerService.getPendingReiumbursementRequest();
		request.setAttribute("pendingReimbursementRequestList", pendingReimbursementRequest);
		RequestDispatcher rd=request.getRequestDispatcher("/ReimbursementSystem/view-pending-reimbursement-requests.jsp");
		rd.forward(request, response);
	}
	
	public void displayResolvedReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ReimbursementRequest> resolvedReimbursementRequest=managerService.getResolvedReimbursementRequest();
		request.setAttribute("resolvedReimbursementRequestList", resolvedReimbursementRequest);
		RequestDispatcher rd=request.getRequestDispatcher("/ReimbursementSystem/view-resolved-reimbursement-requests.jsp");
		rd.forward(request, response);
	}
	
	public void resolveReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("reimbursement-request-id"));
		String status=request.getParameter("updated-status");
		
		ReimbursementRequest reimbursementRequest=new ReimbursementRequest();
		reimbursementRequest.setId(id);
		reimbursementRequest.setStatus(status);
		
		managerService.updateReimbursementRequest(reimbursementRequest);
	}
	
	public void displayReimbursementRequestOfOneEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void displayAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList=managerService.readAllEmployee();
		request.setAttribute("employeeList", employeeList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/ReimbursementSystem/employees.jps");
		rd.forward(request, response);
	}
}

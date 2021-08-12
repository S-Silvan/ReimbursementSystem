package com.ers.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;
import com.ers.service.EmployeeService;
import com.ers.service.EmployeeServiceImplementation;

public class EmployeeController extends ProfileController{
	private EmployeeService employeeService=new EmployeeServiceImplementation();
	
	public void displayDashboard(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/employee/view-dashboard.jsp");
		rd.forward(request, response);
	}
	
	public void displayPendingReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {		
		Employee employee=(Employee)request.getSession().getAttribute("employee");
		
		RequestDispatcher rd=request.getRequestDispatcher("/employee/view-pending-reimbursement-requests.jsp");
		List<ReimbursementRequest> pendingReimbursementRequests=employeeService.getPendingReiumbursementRequest(employee.getId());
		request.setAttribute("pendingReimbursementRequests", pendingReimbursementRequests);
		rd.forward(request,response);
	}
	
	public void displayResolvedReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=(Employee)request.getSession().getAttribute("employee");
		
		RequestDispatcher rd=request.getRequestDispatcher("/employee/view-resolved-reimbursement-requests.jsp");
		List<ReimbursementRequest> resolvedReimbursementRequests=employeeService.getResolvedReimbursementRequest(employee.getId());
		request.setAttribute("resolvedReimbursementRequests", resolvedReimbursementRequests);
		rd.forward(request,response);
	}
	
	public void displayReimbursementRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/employee/view-reimbursement-request-form.jsp");
		rd.forward(request, response);
	}
	
	public void submitReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=(Employee)request.getSession().getAttribute("employee");
		
		Double amount=Double.valueOf(request.getParameter("amount"));
		String type=request.getParameter("type");
		String remark=request.getParameter("remark");
		
		ReimbursementRequest reimbursementRequest=new ReimbursementRequest();
		reimbursementRequest.setAmount(amount);
		reimbursementRequest.setType(type);
		reimbursementRequest.setRemark(remark);
		reimbursementRequest.setRequestDateTime(LocalDateTime.now());
		reimbursementRequest.setStatus("Pending");
		reimbursementRequest.setEmployee(employee);
		
		employeeService.submitReimbursementRequest(reimbursementRequest);
		displayPendingReimbursementRequest(request, response);
	}
}

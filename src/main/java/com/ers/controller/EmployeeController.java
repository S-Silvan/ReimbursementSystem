package com.ers.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Employee;
import com.ers.model.ReimbursementRequest;
import com.ers.service.EmployeeService;
import com.ers.service.EmployeeServiceImplementation;

public class EmployeeController extends ProfileController{
	private EmployeeService employeeService=new EmployeeServiceImplementation();
	
	public void displayLoginForm(HttpServletResponse response) throws IOException{
		response.sendRedirect("/ReimbursementSystem/login.html");
	}
	
	public void displayPendingReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {		
		HttpSession httpSession=request.getSession();
		Employee employee=(Employee)httpSession.getAttribute("employee");
		
		RequestDispatcher rd=request.getRequestDispatcher("/ReimbursementSystem/pending_reimbursement_request.jsp");
		List<ReimbursementRequest> pendingReimbursementRequests=employeeService.getPendingReiumbursementRequest(employee.getId());
		request.setAttribute("pendingReimbursementRequests", pendingReimbursementRequests);
		rd.forward(request,response);
	}
	
	public void displayResolvedReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		Employee employee=(Employee)httpSession.getAttribute("employee");
		
		RequestDispatcher rd=request.getRequestDispatcher("/ReimbursementSystem/resolved_reimbursement_request.jsp");
		List<ReimbursementRequest> resolvedReimbursementRequests=employeeService.getResolvedReimbursementRequest(employee.getId());
		request.setAttribute("resolvedReimbursementRequests", resolvedReimbursementRequests);
		rd.forward(request,response);
	}
	
	public void displayReimbursementRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/ReimbursementSystem/reimbursement_request_form.jsp");
		rd.forward(request, response);
	}
	
	public void submitReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		Employee employee=(Employee)httpSession.getAttribute("employee");
		
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
	}
}

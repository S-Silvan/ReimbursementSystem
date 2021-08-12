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
	
	public void displayDashboard(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/manager/view-dashboard.jsp");
		rd.forward(request, response);
	}
	
	public void displayPendingReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ReimbursementRequest> pendingReimbursementRequest=managerService.getPendingReiumbursementRequest();
		request.setAttribute("pendingReimbursementRequestList", pendingReimbursementRequest);
		RequestDispatcher rd=request.getRequestDispatcher("/manager/view-pending-reimbursement-requests.jsp");
		rd.forward(request, response);
	}
	
	public void displayResolvedReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ReimbursementRequest> resolvedReimbursementRequest=managerService.getResolvedReimbursementRequest();
		request.setAttribute("resolvedReimbursementRequestList", resolvedReimbursementRequest);
		RequestDispatcher rd=request.getRequestDispatcher("/manager/view-resolved-reimbursement-requests.jsp");
		rd.forward(request, response);
	}
	
	public void updateReimbursementRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("reimbursement-request-id"));
		String status=request.getParameter("status");
		
		ReimbursementRequest reimbursementRequest=new ReimbursementRequest();
		reimbursementRequest.setId(id);
		reimbursementRequest.setStatus(status);
		
		managerService.updateReimbursementRequest(reimbursementRequest);
		displayResolvedReimbursementRequest(request, response);
	}
	
	public void displayReimbursementRequestOfOneEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/manager/view-reimbursement-requests_of_one_employee.jsp");
		List<ReimbursementRequest> reimbursementRequestsOfOneEmployee=managerService.getReimbursementRequestOfOneEmployee(Integer.parseInt(request.getParameter("employee-id")));
		request.setAttribute("reimbursementRequestsOfOneEmployee", reimbursementRequestsOfOneEmployee);
		rd.forward(request,response);
	}
	
	public void displayAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList=managerService.readAllEmployee();
		request.setAttribute("employeeList", employeeList);
		System.out.println(employeeList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/manager/view-employees.jsp");
		rd.forward(request, response);
	}
	
	public void displayEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/manager/view-employee-register-form.jsp");
		rd.forward(request, response);
	}
	
	public void submitEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=new Employee();
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setDepartment(request.getParameter("department"));
		employee.setPhoneNumber(request.getParameter("phone-number"));
		employee.setRole("Employee");
		employee.setPassword(request.getParameter("password"));
		
		managerService.insertEmployee(employee);
		
		displayAllEmployee(request, response);
	}
}

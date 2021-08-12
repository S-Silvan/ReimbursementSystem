package com.ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
	"/submit-reimbursement-request","/submit-login","/submit-user-register",
	"/submit-employee-update-profile","/submit-manager-update-profile",
	"/update-reimbursement-request",
	"/view-employee-dashboard","/view-manager-dashboard",
	"/view-employee-pending-reimbursement-requests","/view-employee-resolved-reimbursement-requests",
	"/view-manager-pending-reimbursement-requests","/view-manager-resolved-reimbursement-requests",
	"/view-employees",
	"/view-employee-form","/view-reimbursement-request-form",
	"/view-employee-profile","/view-employee-edit-profile-form",
	"/view-manager-profile","/view-manager-edit-profile-form",
	"/logout"
	})
public class Route extends HttpServlet {
	EmployeeController employeeController=new EmployeeController();
	ManagerController managerController=new ManagerController();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath=request.getServletPath();
		
		System.out.println(servletPath);
		
		switch(servletPath) {
			case "/submit-login":
				employeeController.login(request, response);
				break;
			case "/submit-reimbursement-request":
				employeeController.submitReimbursementRequest(request, response);
				break;
			case "/submit-user-register":
				managerController.submitEmployee(request, response);
				break;
			case "/submit-employee-update-profile":
				employeeController.updateProfile(request, response);
				break;
			case "/submit-manager-update-profile":
				managerController.updateProfile(request, response);
				break;
			case "/view-manager-dashboard":
				managerController.displayDashboard(request,response);
				break;
			case "/view-manager-pending-reimbursement-requests":
				managerController.displayPendingReimbursementRequest(request, response);
				break;
			case "/view-manager-resolved-reimbursement-requests":
				managerController.displayResolvedReimbursementRequest(request, response);
				break;
			case "/view-employees":
				managerController.displayAllEmployee(request, response);
				break;
			case "/view-employee-form":
				managerController.displayEmployeeForm(request, response);
				break;
			case "/view-manager-profile":
				managerController.displayProfile(request, response);
				break;
			case "/view-manager-edit-profile-form":
				managerController.displayProfileEditForm(request, response);
				break;
			case "/view-employee-dashboard":
				employeeController.displayDashboard(request,response);
				break;
			case "/view-employee-pending-reimbursement-requests":
				employeeController.displayPendingReimbursementRequest(request, response);
				break;
			case "/view-employee-resolved-reimbursement-requests":
				employeeController.displayResolvedReimbursementRequest(request, response);
				break;
			case "/view-reimbursement-request-form":
				employeeController.displayReimbursementRequestForm(request, response);
				break;
			case "/view-employee-profile":
				employeeController.displayProfile(request, response);
				break;
			case "/view-employee-edit-profile-form":
				employeeController.displayProfileEditForm(request, response);
				break;
			case "/update-reimbursement-request":
				managerController.updateReimbursementRequest(request, response);
				break;
			case "/logout":
				employeeController.logout(request, response);
				break;
		}
	}
}

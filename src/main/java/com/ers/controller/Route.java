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
	"/view-employees","/view-reimbursement-request-of-one-employee",
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
				employeeController.authorize(request,response,"Employee");
				employeeController.submitReimbursementRequest(request, response);
				break;
			case "/submit-user-register":
				employeeController.authorize(request,response,"Manager");
				managerController.submitEmployee(request, response);
				break;
			case "/submit-employee-update-profile":
				employeeController.authorize(request,response,"Employee");
				employeeController.updateProfile(request, response);
				break;
			case "/submit-manager-update-profile":
				employeeController.authorize(request,response,"Manager");
				managerController.updateProfile(request, response);
				break;
			case "/view-manager-dashboard":
				employeeController.authorize(request,response,"Manager");
				managerController.displayDashboard(request,response);
				break;
			case "/view-manager-pending-reimbursement-requests":
				employeeController.authorize(request,response,"Manager");
				managerController.displayPendingReimbursementRequest(request, response);
				break;
			case "/view-manager-resolved-reimbursement-requests":
				employeeController.authorize(request,response,"Manager");
				managerController.displayResolvedReimbursementRequest(request, response);
				break;
			case "/view-employees":
				employeeController.authorize(request,response,"Manager");
				managerController.displayAllEmployee(request, response);
				break;
			case "/view-reimbursement-request-of-one-employee":
				employeeController.authorize(request,response,"Manager");
				managerController.displayReimbursementRequestOfOneEmployee(request, response);
				break;
			case "/view-employee-form":
				employeeController.authorize(request,response,"Manager");
				managerController.displayEmployeeForm(request, response);
				break;
			case "/view-manager-profile":
				employeeController.authorize(request,response,"Manager");
				managerController.displayProfile(request, response);
				break;
			case "/view-manager-edit-profile-form":
				employeeController.authorize(request,response,"Manager");
				managerController.displayProfileEditForm(request, response);
				break;
			case "/view-employee-dashboard":
				employeeController.authorize(request,response,"Employee");
				employeeController.displayDashboard(request,response);
				break;
			case "/view-employee-pending-reimbursement-requests":
				employeeController.authorize(request,response,"Employee");
				employeeController.displayPendingReimbursementRequest(request, response);
				break;
			case "/view-employee-resolved-reimbursement-requests":
				employeeController.authorize(request,response,"Employee");
				employeeController.displayResolvedReimbursementRequest(request, response);
				break;
			case "/view-reimbursement-request-form":
				employeeController.authorize(request,response,"Employee");
				employeeController.displayReimbursementRequestForm(request, response);
				break;
			case "/view-employee-profile":
				employeeController.authorize(request,response,"Employee");
				employeeController.displayProfile(request, response);
				break;
			case "/view-employee-edit-profile-form":
				employeeController.authorize(request,response,"Employee");
				employeeController.displayProfileEditForm(request, response);
				break;
			case "/update-reimbursement-request":
				employeeController.authorize(request,response,"Manager");
				managerController.updateReimbursementRequest(request, response);
				break;
			case "/logout":
				employeeController.logout(request, response);
				break;
		}
	}
}

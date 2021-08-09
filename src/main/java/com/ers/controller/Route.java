package com.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/submit-reimbursement-request","/submit-login","/submit-user-register"
	"/view-pending-reimbursement-request"})
public class Route extends HttpServlet {
	EmployeeController employeeController=new EmployeeController();
	ManagerController managerController=new ManagerController();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer url=request.getRequestURL();
		String contextPath=url.substring(url.lastIndexOf("/")+1,url.length());
		switch(contextPath) {
			case "submit-login":
				employeeController.login(request, response);
				break;
			case "submit-reimbursement-request":
				employeeController.submitReimbursementRequest(request, response);
				break;
			case "submit-user-register":
				break;
		}
	}
}

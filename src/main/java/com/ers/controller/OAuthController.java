package com.ers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.service.OAuthService;
import com.ers.service.OAuthServiceImplementation;

public class OAuthController {
	private OAuthService oAuthService=new OAuthServiceImplementation();
	
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("employee-id");
		String password=request.getParameter("employee-password");
		Employee employee=oAuthService.login(userId, password);
		System.out.println(employee);
		if(employee!=null) {
			request.getSession(true).setAttribute("employee", employee);
			request.getSession().setMaxInactiveInterval(0);
			
			RequestDispatcher rd=null;
			if(employee.getRole().equalsIgnoreCase("manager"))
				rd=request.getRequestDispatcher("/view-manager-dashboard");
			else 
				rd=request.getRequestDispatcher("/view-employee-dashboard");
			rd.forward(request, response);
		}else {
			response.sendRedirect("/ReimbursementSystem/oauth/login.html");
		}
	}
	public void authorize(String role) {
		
	}
	public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("employee");
		response.sendRedirect("/ReimbursementSystem/oauth/login.html");
	}
}

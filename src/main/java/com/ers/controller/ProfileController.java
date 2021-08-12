package com.ers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Employee;
import com.ers.service.ProfileService;
import com.ers.service.ProfileServiceImplementation;

public class ProfileController extends OAuthController{
	private ProfileService profileService=new ProfileServiceImplementation();
	
	public void displayProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=(Employee)request.getSession().getAttribute("employee");
		
		request.setAttribute("employee", employee);
		RequestDispatcher rd=null;
		if(employee.getRole().equalsIgnoreCase("manager"))
			rd=request.getRequestDispatcher("/manager/view-profile.jsp");
		else
			rd=request.getRequestDispatcher("/employee/view-profile.jsp");
		rd.forward(request, response);
	}
	
	public void displayProfileEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		Employee employee=(Employee)httpSession.getAttribute("employee");
		
		request.setAttribute("profile-details", employee);
		RequestDispatcher rd=null;
		if(employee.getRole().equalsIgnoreCase("manager"))
			rd=request.getRequestDispatcher("/manager/view-profile-edit-form.jsp");
		else
			rd=request.getRequestDispatcher("/employee/view-profile-edit-form.jsp");
		rd.forward(request, response);
	}
	
	public void updateProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee sEmployee=(Employee)request.getSession().getAttribute("employee");
		
		Employee employee=new Employee();
		employee.setId(sEmployee.getId());
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setDepartment(sEmployee.getDepartment());
		employee.setPhoneNumber(request.getParameter("phone-number"));
		employee.setRole(sEmployee.getRole());
		employee.setPassword(request.getParameter("password"));
		
		profileService.updateProfile(employee);
		displayProfile(request, response);
	}
}

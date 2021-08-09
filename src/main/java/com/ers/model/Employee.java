package com.ers.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Integer id;
	@Column(name="employee_name")
	private String name;
	@Column(name="employee_email")
	private String email;
	@Column(name="employee_phone_number")
	private String phoneNumber;
	@Column(name="employee_password")
	private String password;
	@Column(name="employee_role")
	private String role;
	@Column(name="employee_department")
	private String department;
	@OneToMany(mappedBy="employee")
	private List<ReimbursementRequest> reimbursementList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<ReimbursementRequest> getReimbursementList() {
		return reimbursementList;
	}
	public void setReimbursementList(List<ReimbursementRequest> reimbursementList) {
		this.reimbursementList = reimbursementList;
	}
	
	@Override
	public String toString() {
		return "Id:"+id+", Name:"+name+", Phone number:"+phoneNumber+", email"+email+", department:"+department+", role"+role;
	}
}

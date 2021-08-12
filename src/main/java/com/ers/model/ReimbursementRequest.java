package com.ers.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_requests")
public class ReimbursementRequest {
	@Id
	@GeneratedValue
	@Column(name="reimbursement_request_id")
	private Integer id;
	@Column(name="reimbursement_request_amount")
	private Double amount;
	@Column(name="reimbursement_request_status")
	private String status;
	@Column(name="reimbursement_request_type")
	private String type;
	@Column(name="reimbursement_request_remark")
	private String remark;
	@Column(name="reimbursement_request_timestamp")
	private LocalDateTime requestDateTime;
	@Column(name="reimbursement_response_timestamp")
	private LocalDateTime responseDateTime;
	@ManyToOne(fetch=FetchType.EAGER)
	private Employee employee;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public LocalDateTime getRequestDateTime() {
		return requestDateTime;
	}
	public void setRequestDateTime(LocalDateTime requestDateTime) {
		this.requestDateTime = requestDateTime;
	}
	public LocalDateTime getResponseDateTime() {
		return responseDateTime;
	}
	public void setResponseDateTime(LocalDateTime responseDateTime) {
		this.responseDateTime = responseDateTime;
	}
	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	public Employee getEmployee() {
		return employee;
	}
}

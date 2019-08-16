package com.sand.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="maatic_employee")

public class Employee {
	
	@Id
	@Column(name="employee_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@Column(name="employee_Name")
	private String empName;
	
	@Column(name="employee_Phone")
	private String empPhone;
	
	@Column(name="employee_Username")
	private String empUsername;
	
	@Column(name="employee_Password")
	private String empPassword;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + ", empUsername="
				+ empUsername + ", empPassword=" + empPassword + "]";
	}

	
	
	
//	@Column(name="employee_action")
//	private String action;
	
	
	
	
	
	

}

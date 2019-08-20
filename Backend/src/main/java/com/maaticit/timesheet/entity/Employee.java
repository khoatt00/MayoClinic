package com.maaticit.timesheet.entity;

//import javax.persistence.Entity;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="maatic_employee")

public class Employee {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	@Column(name="employee_name")
	private String name;
	
//	@Column(name="employee_phone")
	private String phone;
	
//	@Column(name="employee_username")
	private String username;
	
//	@Column(name="employee_password")
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", username=" + username + ", password="
				+ password + "]";
	}
	
}

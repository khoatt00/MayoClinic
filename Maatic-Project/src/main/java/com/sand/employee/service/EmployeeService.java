package com.sand.employee.service;

import java.util.List;

import com.sand.employee.model.Employee;
import com.sand.employee.model.Login;

public interface EmployeeService {
	
	Employee validateEmployee(Login login) ;

	void addEmployee(Employee employee);
	

}

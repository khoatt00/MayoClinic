package com.sand.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sand.employee.model.Employee;
import com.sand.employee.model.Login;

public interface EmployeeDao extends CrudRepository<Employee,Integer>{
	//Employee validateEmployee(Login login);
	
	
	
	

}

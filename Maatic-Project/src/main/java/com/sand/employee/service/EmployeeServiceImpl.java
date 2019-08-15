package com.sand.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sand.employee.model.Employee;
import com.sand.employee.model.Login;
import com.sand.employee.repository.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	

	@Override
	public Employee validateEmployee(Login login) {
		Employee e1=new Employee();
		List<Employee> list=(List<Employee>) employeeDao.findAll();
		
		for(Employee e:list) {
			
			if((login.getUserName().equals(e.getEmpUsername()))&&( login.getPassword().equals(e.getEmpPassword())) ){
				e1=e;
				break;
			}
			else {
				System.out.println("n**********UserNmae or password Wrong**********");
			}
			
		}
		
		return e1;
	

	}


	@Override
	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
		
	}
	
	
	
	

}

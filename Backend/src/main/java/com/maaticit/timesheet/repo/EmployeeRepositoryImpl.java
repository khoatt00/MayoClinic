package com.maaticit.timesheet.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.maaticit.timesheet.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private List<Employee> list=new ArrayList<>();
	
	@Override
	public void save(Employee employee) {
		
		list.add(employee);
	}

}

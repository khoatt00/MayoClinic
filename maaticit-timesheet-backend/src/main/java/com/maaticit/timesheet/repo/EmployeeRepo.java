package com.maaticit.timesheet.repo;

import java.util.List;

import com.maaticit.timesheet.model.Employee;

public interface EmployeeRepo {
	void save(List<Employee> employee);

}

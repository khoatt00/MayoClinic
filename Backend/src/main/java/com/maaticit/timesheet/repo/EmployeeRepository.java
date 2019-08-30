package com.maaticit.timesheet.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maaticit.timesheet.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}

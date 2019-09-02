package com.maaticit.timesheet.repo;

import org.springframework.data.repository.CrudRepository;

import com.maaticit.timesheet.entity.TimesheetFile;


public interface FileRepository extends CrudRepository<TimesheetFile,Integer> {

}

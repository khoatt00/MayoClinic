package com.maaticit.timesheet.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maaticit.timesheet.entity.TimesheetFile;

@Repository
public interface FileRepository extends CrudRepository<TimesheetFile,Integer> {

	

}

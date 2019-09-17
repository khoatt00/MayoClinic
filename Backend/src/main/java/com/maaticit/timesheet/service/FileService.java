package com.maaticit.timesheet.service;

import java.util.List;

import com.maaticit.timesheet.dto.TimesheetFileDto;
import com.maaticit.timesheet.entity.TimesheetFile;

public interface FileService {
	TimesheetFile saveFile(TimesheetFile timesheetFile);

	List<TimesheetFileDto> getFilePath();

}

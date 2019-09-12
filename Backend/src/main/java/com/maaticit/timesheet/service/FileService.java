package com.maaticit.timesheet.service;

import com.maaticit.timesheet.dto.TimesheetFileDto;
import com.maaticit.timesheet.entity.TimesheetFile;

public interface FileService {
	TimesheetFile saveFile(TimesheetFile timesheetFile);

	TimesheetFileDto getFilePath();

}

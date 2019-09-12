package com.maaticit.timesheet.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maaticit.timesheet.dto.TimesheetFileDto;
import com.maaticit.timesheet.entity.TimesheetFile;
import com.maaticit.timesheet.repo.FileRepository;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileRepository fileRepository;
	

	private void mapTimesheetFileDetails(Object source, Object destination) {
		BeanUtils.copyProperties(source, destination);
	}


	@Override
	public TimesheetFile saveFile(TimesheetFile timesheetFile) {
		return fileRepository.save(timesheetFile);
	}


	@Override
	public TimesheetFileDto getFilePath() {
		int id=1;
		TimesheetFile file=fileRepository.findById(id).get();
		TimesheetFileDto dtoFile=new TimesheetFileDto();
		mapTimesheetFileDetails(file, dtoFile);
		return dtoFile;
	}

}

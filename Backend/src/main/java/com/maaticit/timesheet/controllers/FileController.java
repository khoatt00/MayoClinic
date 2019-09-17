package com.maaticit.timesheet.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maaticit.timesheet.dto.TimesheetFileDto;
import com.maaticit.timesheet.entity.Response;
import com.maaticit.timesheet.entity.TimesheetFile;
import com.maaticit.timesheet.service.FileService;

@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	FileService fileService;

	@Autowired
	ServletContext context;

	@Value("${maatic.timesheet.upload.path}")
	private String path;

	@RequestMapping(value = "user/timesheet", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> saveFile(@RequestParam("file") MultipartFile file) {
		TimesheetFile timesheetFile = new TimesheetFile();
		String timesheetUploadPath = path + "/userprofile/" + timesheetFile.getFileId();

		boolean isExist = new File(timesheetUploadPath).exists();
		if (!isExist) {
			new File(context.getRealPath(timesheetUploadPath)).mkdir();

		}
		String filename = file.getOriginalFilename();
		String modifiedFileName = FilenameUtils.getBaseName(filename) + "_" + System.currentTimeMillis() + "."
				+ FilenameUtils.getExtension(filename);
		File serverFile = new File(timesheetUploadPath + File.separator + modifiedFileName);
		System.out.println(serverFile);
		try {
			FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();

		}

		timesheetFile.setFile(modifiedFileName);
		timesheetFile.setFilePath(serverFile.toString());
		TimesheetFile tFile = fileService.saveFile(timesheetFile);
		if (tFile != null) {
			return new ResponseEntity<Response>(new Response("file is saved successfully"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("file is not saved"), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="user/timesheet",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TimesheetFileDto> getFilePath() {
		return fileService.getFilePath();
		
		
	}

}

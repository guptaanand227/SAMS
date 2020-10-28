package com.yswu.service;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

public interface StudentAssignentListService {

	public JSONArray getAssignmentService();
	
	public String getUploadAssignmentService(MultipartFile file,String faculty_username,String task_id,String student_username);
	
}

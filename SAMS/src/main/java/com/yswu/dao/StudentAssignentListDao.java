package com.yswu.dao;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

public interface StudentAssignentListDao {
	
	public JSONArray getAssignmentDao();
	
	public String getUploadAssignmentDao(MultipartFile file,String faculty_username,String task_id,String student_username);

}

package com.yswu.serviceImpl;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yswu.dao.StudentAssignentListDao;
import com.yswu.service.StudentAssignentListService;

@Service("studentAssignentListService")
public class StudentAssignentListServiceImpl implements StudentAssignentListService {

	@Autowired
	StudentAssignentListDao studentAssignentListDao;

	@Override
	public JSONArray getAssignmentService() {

		return studentAssignentListDao.getAssignmentDao();
	}

	@Override
	public String getUploadAssignmentService(MultipartFile file, String faculty_username, String task_id,String student_username) {

		return studentAssignentListDao.getUploadAssignmentDao(file, faculty_username, task_id,student_username);
	}

}

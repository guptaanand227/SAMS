package com.yswu.serviceImpl;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yswu.dao.FacultyDao;
import com.yswu.service.FacultyService;

@Service("facultyService")
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyDao facultyDao;

	@Override
	public JSONArray getAssignmentService() {

		return facultyDao.getAssignmentDao();
	}

	@Override
	public String updateStatusService(String task_id, String question, String last_date) {

		return facultyDao.updateStatusDao(task_id, question, last_date);
	}

	@Override
	public String deleteStatusService(String task_id, String question, String last_date) {

		return facultyDao.deleteStatusDao(task_id, question, last_date);
	}

	@Override
	public String createStatusService(String question,String dateID) {

		return facultyDao.createStatusDao(question, dateID);
	}
	
	@Override
	public JSONArray getDownloadAssignmentService() {

		return facultyDao.getDownloadAssignmentDao();
	}

	@Override
	public byte[] getDownloadAssignmentDataService(String stutaskID) {

		return facultyDao.getDownloadAssignmentDataDao(stutaskID);
	}

}

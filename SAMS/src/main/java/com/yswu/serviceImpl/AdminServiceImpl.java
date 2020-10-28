package com.yswu.serviceImpl;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yswu.dao.AdminDao;
import com.yswu.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Override
	public JSONArray getAssignmentService() {

		return adminDao.getAssignmentDao();
	}

	@Override
	public String updateStatusService(String task_id, String question, String last_date) {

		return adminDao.updateStatusDao(task_id, question, last_date);
	}

}

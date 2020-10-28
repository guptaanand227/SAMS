package com.yswu.service;

import org.json.JSONArray;

public interface AdminService {

	public JSONArray getAssignmentService();

	public String updateStatusService(String task_id, String question, String last_date);

}

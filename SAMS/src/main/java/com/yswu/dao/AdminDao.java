package com.yswu.dao;

import org.json.JSONArray;

public interface AdminDao {
	
	public JSONArray getAssignmentDao();

	public String updateStatusDao(String task_id, String question, String last_date);

}

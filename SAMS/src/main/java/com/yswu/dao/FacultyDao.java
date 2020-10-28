package com.yswu.dao;

import org.json.JSONArray;

public interface FacultyDao {

	public JSONArray getAssignmentDao();

	public String updateStatusDao(String task_id, String question, String last_date);

	public String deleteStatusDao(String task_id, String question, String last_date);
	
	public String createStatusDao(String question,String dateID);
	
	public JSONArray getDownloadAssignmentDao();
	
	public byte[] getDownloadAssignmentDataDao(String stutaskID);

}

package com.yswu.service;

import org.json.JSONArray;

public interface FacultyService {

	public JSONArray getAssignmentService();

	public String updateStatusService(String task_id, String question, String last_date);
	
	public String deleteStatusService(String task_id, String question, String last_date);
	
	public String createStatusService(String question,String dateID);
	
	public JSONArray getDownloadAssignmentService();
	
	public byte[] getDownloadAssignmentDataService(String stutaskID);

}

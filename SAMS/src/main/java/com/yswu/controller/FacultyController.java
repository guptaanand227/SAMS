package com.yswu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yswu.service.FacultyService;

@Controller
@RequestMapping("/Faculty")
public class FacultyController {

	@Autowired
	FacultyService facultyService;

	@RequestMapping("/Dashboard")
	public String getLogin() {
		return "faculty/dashboard";
	}

	@RequestMapping(value = { "/AssignmentListing" }, method = RequestMethod.POST)
	public void getAssignmentList(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			out.print(facultyService.getAssignmentService());

		} catch (Exception e) {
			System.out.println("Exception in getAssignment : " + e);
		}

	}

	@RequestMapping(value = { "/UpdateAssignment" }, method = RequestMethod.POST)
	public void UpdateAssignment(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			String task_id = request.getParameter("task_id");
			String question = request.getParameter("question");
			String last_date = request.getParameter("ldate");

			out.print(facultyService.updateStatusService(task_id, question, last_date));

		} catch (Exception e) {
			System.out.println("Exception in getAssignment : " + e);
		}

	}

	@RequestMapping(value = { "/DeleteAssignment" }, method = RequestMethod.POST)
	public void DeleteAssignment(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			String task_id = request.getParameter("task_id");
			String question = request.getParameter("question");
			String last_date = request.getParameter("ldate");

			out.print(facultyService.deleteStatusService(task_id, question, last_date));

		} catch (Exception e) {
			System.out.println("Exception in getAssignment : " + e);
		}

	}

	@RequestMapping(value = { "/CreateAssignment" }, method = RequestMethod.POST)
	public void CreateAssignment(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			String question = request.getParameter("question");
			String dateID = request.getParameter("dateID");

			out.print(facultyService.createStatusService(question, dateID));

		} catch (Exception e) {
			System.out.println("Exception in CreateAssignment : " + e);
		}

	}

	@RequestMapping(value = { "/DownloadAssignmentListing" }, method = RequestMethod.POST)
	public void getDownloadAssignmentList(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			out.print(facultyService.getDownloadAssignmentService());

		} catch (Exception e) {
			System.out.println("Exception in getDownloadAssignment : " + e);
		}

	}

	@RequestMapping(value = { "/DownloadAssignment" }, method = RequestMethod.POST)
	public void getDownloadAssignment(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;
		String status = "Error~None";

		try {

			out = response.getWriter();

			String stutaskID = request.getParameter("stutaskID");

			byte[] data = facultyService.getDownloadAssignmentDataService(stutaskID);

			if (data != null) {
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.sss");
				String dat = dateFormat.format(new Date());
				System.out.println(dat);

				String file_name = "C:\\" + dat + ".txt";

				File file = new File(file_name);
				response.setContentType("text/plain");
				response.setHeader("Content-Disposition", "inline; filename=\"" + file_name + "\"");

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(data);
				fileOutputStream.close();
				
				status = "Success~"+dat;

			}

			

		} catch (Exception e) {
			System.out.println("Exception in getDownloadAssignment : " + e);
			status = "Exception~None";
		}
		
		out.print(status);

	}

}

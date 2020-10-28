package com.yswu.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yswu.service.StudentAssignentListService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	StudentAssignentListService studentAssignentListService;

	@RequestMapping("/Dashboard")
	public String getLogin() {
		return "student/dashboard";
	}

	@RequestMapping(value = { "/AssignmentListing" }, method = RequestMethod.POST)
	public void getAssignmentList(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			out.print(studentAssignentListService.getAssignmentService());

		} catch (Exception e) {
			System.out.println("Exception in getAssignment : " + e);
		}

	}

	@RequestMapping(value = { "/UploadAssignment" }, method = RequestMethod.POST)
	public void getUploadAssignment(@RequestParam("uploadfile") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			String faculty_username = request.getParameter("facultyU");
			String task_id = request.getParameter("taskID");

			String student_username = request.getSession().getAttribute("username").toString();

			out.print(studentAssignentListService.getUploadAssignmentService(file, faculty_username, task_id,
					student_username));

		} catch (Exception e) {
			System.out.println("Exception in getAssignment : " + e);
		}

	}

}

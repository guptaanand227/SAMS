package com.yswu.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yswu.service.AdminService;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@RequestMapping("/Dashboard")	
	public String getLogin() {
		return "admin/dashboard";
	}
	
	@RequestMapping(value = { "/AssignmentListing" }, method = RequestMethod.POST)
	public void getAssignmentList(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter out = null;

		try {

			out = response.getWriter();

			out.print(adminService.getAssignmentService());

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

			out.print(adminService.updateStatusService(task_id, question, last_date));

		} catch (Exception e) {
			System.out.println("Exception in getAssignment : " + e);
		}

	}
	
}

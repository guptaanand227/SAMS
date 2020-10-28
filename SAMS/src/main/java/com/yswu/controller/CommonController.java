package com.yswu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yswu.service.LoginHomeService;

@Controller
@RequestMapping("/Common")
public class CommonController {
	

	@Autowired
	LoginHomeService loginHomeService;
	
	@RequestMapping("/Login")	
	public String getLogin() {
		return "common/login";
	}
	
	@RequestMapping(value = { "/LoginHomeStatus" }, method = RequestMethod.POST)
	public void getLoginHomeStatus(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("usertype");

		String status = loginHomeService.getLoginHomeStatusService(username, password, userType);

		String result = "Same";		

		if (status.equals("matched") && userType.equals("Student")) {
			result = "Student";			
		} else if (status.equals("matched") && userType.equals("Faculty")) {
			result = "Faculty";			
		} else if (status.equals("matched") && userType.equals("Admin")) {
			result = "Admin";			
		}

		out.print(result);
	}

	@RequestMapping("/Logout")
	public String getLogoutHome(HttpServletRequest request, HttpServletResponse response) {

		try {

			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}

		} catch (Exception e) {
			System.out.println("Exception in LoginController RequestMapping=Logout : " + e);
		}

		return "common/Login";
	}

}

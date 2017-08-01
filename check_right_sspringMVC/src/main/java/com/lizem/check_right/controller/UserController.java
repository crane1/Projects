package com.lizem.check_right.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.lizem.check_right.bean.Student;

public class UserController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("user");
		
		String userJson = "{}";
		if(stu != null){
			userJson = "{"
					+ "\"id\":" + stu.getId() + ","
					+ "\"name\":\"" + stu.getName() + "\""
					+ "}";
			out.write(userJson);
		}else{
			return new ModelAndView("login");
		}
		return null;
	}

}

package com.lizem.check_right.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.lizem.check_right.bean.Student;
import com.lizem.check_right.service.ILoginService;

public class LoginController extends AbstractController{

	ILoginService loginService;
	
	public ILoginService getLoginService() {
		return loginService;
	}
	
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = (String)request.getParameter("pwd");
		
		Student stu = loginService.checkUserExist(id, pwd);
		HttpSession session = request.getSession();
		session.setAttribute("user", stu);
		
		PrintWriter out = response.getWriter();
		if(stu != null){
			modelAndView.setViewName("welcome");
		}else{
			out.write("id or pwd is false");
		}
		return modelAndView;
	}

}

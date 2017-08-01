package com.lizm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.service.CommodService;
import com.lizm.service.MessageService;

@SuppressWarnings("serial")
public class InsertOneContextServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String commodId = req.getParameter("commodId");
		String context = req.getParameter("context");
		
		System.out.println("context:" + context);
		int result = new CommodService().InsertContextOne(commodId, context);
		
		String path = req.getContextPath();
		resp.sendRedirect(path + "/ListCommod.action");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}

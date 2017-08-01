package com.lizm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.service.CommodService;
import com.lizm.service.MessageService;

@SuppressWarnings("serial")
public class InsertOneCommodServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String commod = req.getParameter("commod");
		String descript = req.getParameter("descript");
		
		System.out.println("commod:" + commod);
		int result = new CommodService().InsertCommodOne(commod, descript);
		
		String path = req.getContextPath();
		resp.sendRedirect(path + "/ListCommod.action");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}

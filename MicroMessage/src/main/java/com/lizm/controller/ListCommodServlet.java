package com.lizm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.beans.Commod;
import com.lizm.beans.Message;
import com.lizm.service.CommodService;
import com.lizm.service.MessageService;

public class ListCommodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String commod = req.getParameter("commod");
		String descript = req.getParameter("descript");
		
		System.out.println("commod------------:" + commod);
		
		
		List<Commod> commodList = new CommodService().queryCommodList(commod, descript);
		
		System.out.println("commodList----------------:" + commodList);
		
		req.setAttribute("commodList", commodList);
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

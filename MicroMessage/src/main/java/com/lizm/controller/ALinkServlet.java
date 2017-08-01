package com.lizm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.beans.Commod;
import com.lizm.beans.Message;
import com.lizm.service.CommodService;
import com.lizm.service.MessageService;

@SuppressWarnings("serial")
public class ALinkServlet extends HttpServlet {
	
	CommodService commodService = new CommodService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String page = req.getParameter("page");
		if(page != null && !"".equals(page)){
			if(page.equals("insert")){
				
				req.getRequestDispatcher("/WEB-INF/jsp/back/insert.jsp").forward(req, resp);
			} else if(page.equals("update")){
				
				String id = req.getParameter("id");
				
				Commod commod = commodService.queryCommodById(id);
				
				if(commod != null){
					req.setAttribute("commod", commod);
					req.getRequestDispatcher("/WEB-INF/jsp/back/update.jsp").forward(req, resp);
				}else{
					out.write("要修改的不存在");
					return;
				}
			} else if (page.equals("insertContext")){
				
				String id = req.getParameter("id");
				System.out.println("--------------------id:" + id);
				Commod commod = commodService.queryCommodById(id);
				
				if(commod != null){
					req.setAttribute("commod", commod);
					req.getRequestDispatcher("/WEB-INF/jsp/back/insertContext.jsp").forward(req, resp);
				}else{
					out.write("要新增内容的指令不存在");
					return;
				}
			}
		}
	}

}

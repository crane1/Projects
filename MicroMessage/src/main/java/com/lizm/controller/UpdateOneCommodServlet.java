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
public class UpdateOneCommodServlet extends HttpServlet {

	private CommodService commodService= new CommodService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		System.out.println("id:----------" + id);
		
		Commod commod = commodService.queryCommodById(id);
		
		if(commod != null){
			String name = req.getParameter("name");
			String descript = req.getParameter("descript");
			commod.setName(name);
			commod.setDescript(descript);
			
			int result = commodService.UpdateCommodOne(commod);
			if(result == 1){
				String path = req.getContextPath();
				resp.sendRedirect(path + "/ListCommod.action");
			}else{
				out.write("后台出错");
			}
		}else{
			out.write("要修改的数据不存在");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}

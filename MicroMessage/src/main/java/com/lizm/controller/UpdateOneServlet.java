package com.lizm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.beans.Message;
import com.lizm.service.MessageService;

@SuppressWarnings("serial")
public class UpdateOneServlet extends HttpServlet {

	private MessageService messageService= new MessageService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		
		Message message = messageService.queryMesgById(id);
		
		if(message != null){
			String commod = req.getParameter("commod");
			String descript = req.getParameter("descript");
			String context = req.getParameter("context");
			message.setCommod(commod);
			message.setDescript(descript);
			message.setContext(context);
			
			int result = messageService.UpdateOne(message);
			if(result == 1){
				String path = req.getContextPath();
				resp.sendRedirect(path + "/List.action");
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

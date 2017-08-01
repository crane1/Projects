package com.lizem.check_right.service;

import com.lizem.check_right.bean.Student;
import com.lizem.check_right.dao.ILoginDAO;
import com.lizem.check_right.dao.LoginDAOImp;

public class LoginServiceImp implements ILoginService{
	private ILoginDAO loginDAO;
	
	public ILoginDAO getLoginDAO() {
		return loginDAO;
	}
	
	public void setLoginDAO(ILoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public Student checkUserExist(int id, String pwd) {
		return loginDAO.checkUserExist(id, pwd);
	}
	
}

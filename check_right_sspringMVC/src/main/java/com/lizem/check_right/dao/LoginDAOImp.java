package com.lizem.check_right.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lizem.check_right.bean.Student;
import com.lizem.check_right.tools.DButil;

public class LoginDAOImp implements ILoginDAO{
	DButil db;
	
	public DButil getDb() {
		return db;
	}

	public void setDb(DButil db) {
		this.db = db;
	}

	@Override
	public Student checkUserExist(int id, String pwd) {
		
		String sql = "select name, pwd from student where id = " + id; 
		
		ResultSet res = db.excuteQuery(sql);
		Student stu = null;
		try {
			if(res.next()){
				if(pwd.equals(res.getString("pwd"))){
					stu = new Student();
					stu.setId(id);
					stu.setName(res.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
	}

}

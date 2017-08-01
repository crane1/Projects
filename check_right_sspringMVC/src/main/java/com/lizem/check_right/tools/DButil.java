package com.lizem.check_right.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Temporal;

import org.junit.Test;

public class DButil {
	private String driver;
	private String url;
	private String username;
	private String pwd;
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private Connection conn;
	
	public void getConn(){
		try {
			Class.forName(driver); //加载驱动
			conn = DriverManager.getConnection(url,username, pwd); //获取链接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet excuteQuery(String sql){
		ResultSet res = null;
		getConn();
		try {
			Statement statement = conn.createStatement();
			res = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@Test
	public void testDB(){
		String sql = "select name, pwd from student where id = 1"; 
		ResultSet excuteQuery = excuteQuery(sql);
		try {
			if(excuteQuery.next()){
				System.out.println("name:" + excuteQuery.getString("name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

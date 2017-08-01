package com.lizm.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lizm.beans.Commod;
import com.lizm.db.DBAccess;

public class CommodDao {
	public Commod queryCommodById(int id){
		Commod commod = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSeesion();
			commod = sqlSession.selectOne("Commod.queryCommodById", id);
			System.out.println("commod" + commod);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
		return commod;
	}
	
	public List<Commod> queryCommodList(Commod commod){
		List<Commod> commodList = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSeesion();
			commodList = sqlSession.selectList("Commod.queryCommodList", commod);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
		return commodList;
	}
	
	public int InsertOne(Commod commod){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.insert("Commod.InsertOne", commod);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
		return result;
	}
	
	public int UpdateOne(Commod commod){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.update("Commod.UpdateOne", commod);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
		return result;
	}
	
	
	@Test
	public void testDao(){
		
		Commod commod = new CommodDao().queryCommodById(7);
		System.out.println(commod);
	}
}

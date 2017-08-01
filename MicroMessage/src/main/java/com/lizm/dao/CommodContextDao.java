package com.lizm.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lizm.beans.Commod;
import com.lizm.beans.CommodContext;
import com.lizm.db.DBAccess;

public class CommodContextDao {
	public Commod queryCommodById(int id){
		Commod commod = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSeesion();
			commod = sqlSession.selectOne("Commod.queryCommodById", id);
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
	
	public int InsertOne(CommodContext commodContext){
		int result = 0;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSeesion();
			result = sqlSession.insert("CommodContext.InsertOne", commodContext);
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
		
		List<Commod> commod = new CommodContextDao().queryCommodList(new Commod(1,null,"吗"));
		System.out.println(commod);
	}
}

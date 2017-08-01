package com.lizm.service;

import java.util.List;

import com.lizm.beans.Commod;
import com.lizm.beans.CommodContext;
import com.lizm.dao.CommodContextDao;
import com.lizm.dao.CommodDao;

public class CommodService {
	private CommodDao commodDao = new CommodDao();
	private CommodContextDao commodContextDao = new CommodContextDao();
	
	public Commod queryCommodById(String id){
		Commod commod = null;
		if(id != null && !"".equals(id)){
			commod = commodDao.queryCommodById(Integer.parseInt(id));
		}
		
		return commod;
	}
	
	public List<Commod> queryCommodList(String name, String descript){
		Commod commod = new Commod();
		commod.setName(name);
		commod.setDescript(descript);
		return commodDao.queryCommodList(commod);
	}
	
	public int InsertCommodOne(String name, String descript){
		Commod commod = new Commod();
		commod.setName(name);
		commod.setDescript(descript);
		return commodDao.InsertOne(commod);
	}
	
	public int UpdateCommodOne(Commod commod){
		return commodDao.UpdateOne(commod);
	}
	
	public int InsertContextOne(String commodId, String context){
		CommodContext commodContext = new CommodContext();
		commodContext.setCommodId(Integer.parseInt(commodId));
		commodContext.setContext(context);
		return commodContextDao.InsertOne(commodContext);
	}
	
}

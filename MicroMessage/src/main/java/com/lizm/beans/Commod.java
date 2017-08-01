package com.lizm.beans;

import java.util.List;

public class Commod {
	private int id;
	private String name;
	private String descript;
	private List<CommodContext> contextList;
	
	
	public Commod() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commod(int id, String name, String descript) {
		super();
		this.id = id;
		this.name = name;
		this.descript = descript;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public List<CommodContext> getContextList() {
		return contextList;
	}

	public void setContextList(List<CommodContext> contextList) {
		this.contextList = contextList;
	}

	@Override
	public String toString() {
		return "Commod [id=" + id + ", name=" + name + ", descript=" + descript
				+ ", contextList=" + contextList + "]";
	}
	
	
}

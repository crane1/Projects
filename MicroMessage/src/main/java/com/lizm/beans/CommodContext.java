package com.lizm.beans;

public class CommodContext {
	private int id;
	private int commodId;
	private String context;
	public CommodContext() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommodContext(int id, int commodId, String context) {
		super();
		this.id = id;
		this.commodId = commodId;
		this.context = context;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommodId() {
		return commodId;
	}
	public void setCommodId(int commodId) {
		this.commodId = commodId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "CommodContext [id=" + id + ", commodId=" + commodId
				+ ", context=" + context + "]";
	}
	
}

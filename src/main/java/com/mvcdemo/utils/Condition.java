package com.mvcdemo.utils;

import java.util.HashMap;
/**
 * 
 * @author Doumi
 * 条件类，用于条件查询
 */
public class Condition {
	//查询条件
	private HashMap<String,Object> queryKey;

	//排序条件
	private String orderByClause;
	
	//选取数据条数
	private String limitClause;
	
	public Condition(){
		orderByClause ="";
		limitClause = "";
		queryKey = new HashMap<String, Object>();
	}

	public Condition(HashMap<String,Object> queryKey){
		orderByClause ="";
		limitClause = "";
		this.queryKey = queryKey;
	}
	public String getLimitClause() {
		return limitClause;
	}
	public void setLimitClause(String limitClause) {
		this.limitClause = limitClause;
	}
	public void setQueryKey(String key,Object value){
		this.queryKey.put(key, value);
	}
	public void setQueryKey(HashMap<String, Object> queryKey){
		this.queryKey=queryKey;
	}
	public HashMap<String,Object> getQueryKey(){
		return queryKey;
	}
	
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
}

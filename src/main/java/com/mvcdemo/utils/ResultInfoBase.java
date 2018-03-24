package com.mvcdemo.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class ResultInfoBase {
	private boolean status;
	private String msg;
	private Object queryData;
	public Object getQueryData() {
		return queryData;
	}
	public void setQueryData(Object queryData) {
		this.queryData =queryData;
	}
	//初始�?
	public ResultInfoBase(){
		status = false;
		msg="";
	}
	
	public ResultInfoBase(String msg){
		status = false;
		this.msg=msg;
	}
	public void turnStatus(){
		status=!status;
	}
	public void setMsg(String msg){
		this.msg=msg;
	}
	public String getMsg(){
		return msg;
	}
	public boolean getStatus(){
		return status;
	}
}

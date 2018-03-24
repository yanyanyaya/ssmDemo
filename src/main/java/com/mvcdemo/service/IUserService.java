package com.mvcdemo.service;

import java.util.List;

import com.mvcdemo.model.User;
import com.mvcdemo.utils.ResultInfoBase;

public interface IUserService {

	public User getUserById(int userId);  
	  
    public void insertUser(User user);  
  
    public void addUser(User user);  
    public ResultInfoBase getAllUser();  
	
}

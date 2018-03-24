package com.mvcdemo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mvcdemo.mapper.IUserDao;
import com.mvcdemo.model.User;
import com.mvcdemo.service.IUserService;
import com.mvcdemo.utils.ResultInfoBase;

@Service("userService") 
public class UserServiceImpl implements IUserService {

		@Resource  
	    private IUserDao userDao; 
		
	      
	    public User getUserById(int userId) {  
	        return userDao.queryByPrimaryKey(userId);  
	    }  
	  
	    public void insertUser(User user) {  
	        userDao.insertUser(user);  
	    }  
	  
	    public void addUser(User user) {  
	        userDao.insertUser(user);  
	    }  
	  
	    @Override
	    public ResultInfoBase getAllUser() {  
	    	List<User> users= userDao.getAllUser();
	    	ResultInfoBase resultInfo = new ResultInfoBase("显示失败");
	    	resultInfo.setQueryData(users);
	    	resultInfo.setMsg("显示成功");
	    	resultInfo.turnStatus();
	    	return resultInfo;
	    }  
}

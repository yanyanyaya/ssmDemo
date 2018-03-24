package com.mvcdemo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdemo.model.User;
import com.mvcdemo.service.IUserService;
import com.mvcdemo.utils.ResultInfoBase;
import com.mvcdemo.utils.VerifyCodeUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource  
    private IUserService userService;
	
	private ResultInfoBase resultInfo;
	
	String message = "Welcome to Spring MVC!";
	
		@RequestMapping("/hello")
		public ModelAndView helloMvc(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
			ModelAndView mv = new ModelAndView("home");//指定视图
			//向视图中添加所要展示或使用的内容，将在页面中使用
		    mv.addObject("message", message);
		    mv.addObject("name", name);
		    return mv;
		}
		 
	    @RequestMapping("/userList")
	    @ResponseBody
	    public Map<String,Object> userList(){  
	        resultInfo =  userService.getAllUser();  
	        
	        Map<String,Object> result = new HashMap<String,Object>();
			result.put("info", resultInfo);
	        return result;  
	    }  
	      
	    @RequestMapping("/showUser")  
	    public String showUser(HttpServletRequest request,Model model){  
	        int userId = Integer.parseInt(request.getParameter("id"));  
	        User user = userService.getUserById(userId);  
	        model.addAttribute("user", user);  
	        return "showUser";  
	    }  
	    
	    @RequestMapping(value="/verifyCode")
		public void initCode(HttpServletRequest request,HttpServletResponse response){
	        response.setHeader("Pragma", "No-cache"); 
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setDateHeader("Expires", 0); 
	        response.setContentType("image/jpeg"); 
			String verifyCode = VerifyCodeUtil.generateVerifyCode(4); 
		    //存入会话session 
		    HttpSession session = request.getSession(true); 
		    //删除以前的
		    session.removeAttribute("verCode");
		    session.setAttribute("verCode", verifyCode.toLowerCase()); 
		    //生成图片 
		    int w = 300, h = 100;  
		    try{	  
		    	OutputStream os = response.getOutputStream();
		        VerifyCodeUtil.outputImage(w, h,os, verifyCode); 
	    		os.flush();
	    		os.close();
	    		os=null;
	    		response.flushBuffer();
		    }catch(IOException e){
		        e.printStackTrace();
		    }
		}
	      
	    @RequestMapping("/addUserUI")  
	    public String addUserUI(){  
	        return "addUser";  
	    }  
	      
	    @RequestMapping("/addUser")  
	    public String addUser(HttpServletRequest request,Model model){  
	        User user = new User();  
	        user.setName(String.valueOf(request.getParameter("name")));  
	        user.setPassword(String.valueOf(request.getParameter("password")));  
	        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));  
	        userService.addUser(user);  
	        return "redirect:/user/userList";  
	    }  
	
}

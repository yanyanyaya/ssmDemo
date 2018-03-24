<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'userList.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  </head>  
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script>
	var ip = "http://127.0.0.1:8080";
 jQuery(function($){
    	var urlStr ="<%=request.getContextPath()%>/user/userList";
		<%-- <%=request.getContextPath()%> --%>
    	//alert("Before Call:"+urlStr);
    	$.ajax({
    		method: "GET",
    		url: urlStr,
    		success:function(data,status,jqXHR){
    			debugger;
    			//alert("Success:"+data);
    			var data = data.info;
    			if(data.status){
    				var users = data.queryData;
    				debugger;
    				
    				for(var i = 0;i<users.length;i++){
    					var user = users[i];
    					
    					var  new_Obj1 = $(" <li  class= 'uname'> <span>用户名称</span> <em class='name"+i+"'></em> </li><li  class= 'uage'> <span>用户年龄</span> <em class='age"+i+"'></em> </li>").clone();
    					
    					$(new_Obj1).appendTo("ul");
	    				$(".name"+i).text(user.name);
	    				$(".age"+i).text(user.age);
    					}
    				debugger;
	    			}else{
	    				console.log("获取数据失败");
	    			}
    					
    		},// ~ end for			
    		 error:function(){
   	    	  console.log("dengluno");
   	      }
    	}); //end ajax
 });
</script>   
  <body>
  	<ul >
       
          
        <br/>
     </ul>
    </div>  
  </body>  
</html> 
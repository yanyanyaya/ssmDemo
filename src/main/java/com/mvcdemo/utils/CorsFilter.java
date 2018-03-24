package com.mvcdemo.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

 
public class CorsFilter implements Filter {  
  
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);  
  
    public void init(FilterConfig filterConfig) {}  
    
  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        HttpServletResponse response = (HttpServletResponse) res;  
        req = (HttpServletRequest) req;
        //req = new CustomeizedRequest((HttpServletRequest) req);
        HttpServletRequest reqs = (HttpServletRequest) req; 
        Enumeration<String> headers = reqs.getHeaderNames(); 
        
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8090");  
        response.setHeader("Access-Control-Allow-Credentials", "true");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");  
        chain.doFilter(req, res);  
    }  
    
    public void destroy() {}
    
   
}  
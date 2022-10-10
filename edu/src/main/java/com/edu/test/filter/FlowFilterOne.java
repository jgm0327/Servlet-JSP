package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterOne implements Filter{

	public void init(FilterConfig config) {
		System.out.println("init() 호출 .......... one");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter() 호출 전 ......... one");
		chain.doFilter(request, response);
		System.out.println("doFilter() 호출 후 ......... one");
		
	}
	
	public void destroy() {
		System.out.println("destroy() 호출 .......... one");
	}
}

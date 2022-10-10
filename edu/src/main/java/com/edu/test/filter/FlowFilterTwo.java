package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter{
	String charset;

	public void init(FilterConfig config) {
		System.out.println("init() 호출 .......... two");
		charset = config.getInitParameter("en");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		System.out.println("doFilter() 호출 전 ......... two");
		chain.doFilter(request, response);
		System.out.println("doFilter() 호출 후 ......... two");
		
	}
	
	public void destroy() {
		System.out.println("destroy() 호출 .......... two");
	}
}

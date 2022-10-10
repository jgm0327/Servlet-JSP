package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "timer", urlPatterns = "/third")
public class FlowFilterThree implements Filter{
	public void init(FilterConfig config) {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		System.out.println("수행 시간 :" + executeTime + "ms");
		
	}

	public void destroy() {}
}

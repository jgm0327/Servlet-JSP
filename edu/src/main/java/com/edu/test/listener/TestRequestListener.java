package com.edu.test.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TestRequestListener implements ServletRequestListener{

	public TestRequestListener() {
		System.out.println("TestRequestListener 객체 생성");
	}
	
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("HttpServletRequest 객체 초기화");
	}
	
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("HttpServletRequest 객체 삭제");
	}
}

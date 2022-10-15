<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	InitialContext ic = new InitialContext();

	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
	
	Connection conn = ds.getConnection();
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from test");
	
	while(rs.next()){
		out.print("<br>" + rs.getString("id") + ":" + rs.getString(2));
	}
	
	rs.close();
	stmt.close();
	conn.close();

%>
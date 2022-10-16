<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource var="myoracle2"
driver="oracle.jdbc.driver.OracleDriver"
url="jdbc:oracle:thin:@localhost:1521:xe"
user="scott"
password="tiger"/>

<sql:query dataSource="${myoracle2 }" var="result">
	select * from dept
</sql:query>

<table border="1">
	<tr>
		<th>DEPTNO</th><th>DNAME</th><th>Location</th>
	</tr>
	<c:forEach var="row" items="${result.rows }">
		<tr>
			<td><c:out value="${row.deptno }"/></td>
			<td><c:out value="${row.dname }"/></td>
			<td><c:out value="${row.loc }"/></td>
		</tr>
	</c:forEach>
</table>
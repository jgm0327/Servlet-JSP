<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		Enumeration<String> list = request.getHeaderNames();
		while(list.hasMoreElements()){
			String key = list.nextElement();
			out.print("<br>" + key + " : " + request.getHeader(key));
		}
	%>
	<hr>
	${header }
</body>
</html>
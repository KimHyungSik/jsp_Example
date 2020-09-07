<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int cnt = 5;
String cnt_ = null;

cnt_ = request.getParameter("cnt");
if(cnt_ != null && !cnt_.equals(""))
	 cnt = Integer.parseInt(request.getParameter("cnt"));

%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for(int i = 0; i < cnt; i++){%>
		안녕 Servlet!!<br/>
	<%} %>
	
</body>
</html>
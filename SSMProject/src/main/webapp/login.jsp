<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<%
		HttpSession httpSession = request.getSession();
		out.print("sessionID:"+httpSession.getId()+"<br/>");
		String username=httpSession.getAttribute("username").toString();
	%>
	<h3>
		欢迎,<%=username%>
	</h3>
</body>
</html>
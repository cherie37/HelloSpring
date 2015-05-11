<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<f:form action="${pageContext.request.contextPath}/login" method="post">
		<font color="red"><c:forEach items="${msg}" var="item">
    		${item}<br>
			</c:forEach></font>	
		Username : <input name="username" />
		Password : <input name="password" type="password" />
		Date : <input name="date" />
		<input type="submit" value="login" />
	</f:form>


</body>
</html>
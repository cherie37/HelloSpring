<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Welcome</title>
</head>
<body>
	<center>
		<font color="green" size="30">Welcome ${username}<br></font>
		<fmt:formatDate value="${date}" pattern="dd-MMMM-yyyy"/>
	</center>
</body>
</html>
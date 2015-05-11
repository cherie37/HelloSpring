<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h2>Spring MVC Hello Wolrd</h2>
	<f:form action="${pageContext.request.contextPath}/hello" method="post">
		Name : <input name="name"/>
		<input type="submit" value="submit"/>
			
	</f:form>

</body>
</html>
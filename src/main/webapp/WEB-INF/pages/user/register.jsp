<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>User Register</title>
<style type="text/css">
.errors {
	color: red;
	padding-left: 10px;
}

form {
	margin-left: 30px;
	margin-top: 20px;
}

td {
	padding: 3px;
}
</style>


</head>
<body>
<script type="text/javascript">
	function buttonCancel(){
		document.userForm.action = "${pageContext.request.contextPath}/usersave";
		document.userForm.method = "get";
		user.id="0";
		return true;
	}
	
</script>
	<c:choose>
		<c:when test="${user.id ne null}">
			<c:set var="actionName">userUpdate/${user.id}</c:set>
		</c:when>
		<c:otherwise>
			<c:set var="actionName">user</c:set>
		</c:otherwise>
	</c:choose>


	<f:form name="userForm" action="${pageContext.request.contextPath}/${actionName}"
		modelAttribute="user" method="post">
		<table>
			<tr>
				<td><spring:message code="user.firstname" /> :</td>
				<td><f:input path="firstName" /> <f:errors path="firstName"
						cssClass="errors" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.lastname" />:</td>
				<td><f:input path="lastName" /> <f:errors path="lastName"
						cssClass="errors" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.username" /> :</td>
				<td><f:input path="username" /> <f:errors path="username"
						cssClass="errors" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.password" /> :</td>
				<td><f:password path="password" /> <f:errors path="password"
						cssClass="errors" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.re-password" /> :</td>
				<td><f:password path="repassword" /> <f:errors
						path="repassword" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Birthday :</td>
				<td><f:input path="birthday" /></td>
			</tr>

			<tr>
				<td><spring:message code="user.department" /> :</td>
				<td><f:select path="department.deptId" items="${department}"
						itemValue="deptId" itemLabel="dName" /></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/usersave"><spring:message
							code="user.clear.session" /></a></td>
				<td><input type="submit"
					value="<spring:message code="user.button.submit"/>"/></td>
				
				<td><input type="submit" onclick="return buttonCancel();"
					value="<spring:message code="user.button.cancel"/>"></td>



			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/user?locale=th">
						Thai </a> <a href="${pageContext.request.contextPath}/user?locale=en">
						Eng </a></td>
				<td><spring:message code="user.count" /> :
					${cookie.hitCounter.value}</td>
			</tr>
		</table>

		<table>
			<h3>User</h3>
			<tr>
				<h4>
					<td>Firstname</td>
					<td>Lastname</td>
					<td>Edit</td>
					<td>Delete</td>
				</h4>
			</tr>
			<tr>

				<c:forEach items="${allUser}" var="items">
					<td>${items.firstName}</td>
					<td>${items.lastName}</td>
					<td><a
						href="${pageContext.request.contextPath}/userUpdate/${items.id}">Update</a></td>
					<td><a
						href="${pageContext.request.contextPath}/userDelete/${items.id}">
							Delete</a></td>
					<br>
					</tr><tr>
				</c:forEach>

				
		</table>
	</f:form>




</body>
</html>
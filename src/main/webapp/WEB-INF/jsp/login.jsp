<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Login Form</title>
</head>
<body>
	<br />
	<form:form method="POST" action="/classes" modelAttribute="user">
		<form:label path="username">Username</form:label>
		<form:input type="text" path="username" />

		<form:label path="password">Password</form:label>
		<form:input type="password" path="password" />

		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>
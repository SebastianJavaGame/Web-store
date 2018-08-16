<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sing up</title>
</head>
<body>
	<form:form modelAttribute="client">
		<form:input path="email" type="text" placeholder="email"/>
		<form:input path="name" type="text" placeholder="name"/>
		<form:input path="last_name" type="text" placeholder="last_name"/>
		<form:input path="address" type="text" placeholder="address"/>
		<form:input path="postcode" type="text" placeholder="postcode"/>
		<input type="submit" value="Send"/>
	</form:form>
</body>
</html>
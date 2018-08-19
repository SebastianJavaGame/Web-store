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
		
	
		<div>
		<form:input path="email" type="text" placeholder="email"/><br/>
		<form:errors path="email"/>
		</div>
		
		<div>
		<form:input path="loginDate.password" type="password" placeholder="password"/><br/>
		<form:errors path="loginDate.password"/>
		</div>
		
		<div>
		<form:input path="name" type="text" placeholder="name"/><br/>
		<form:errors path="name"/>
		</div>
		
		<div>
		<form:input path="last_name" type="text" placeholder="last_name"/><br/>
		<form:errors path="last_name"/>
		</div>
		
		<div>
		<form:input path="address" type="text" placeholder="address"/><br/>
		<form:errors path="address"/>
		</div>
		
		<div>
		<form:input path="postcode" type="text" placeholder="postcode"/><br/>
		<form:errors path="postcode"/>
		</div>
		
		<div>
		<input type="submit" value="Send"/><br/>
		</div>
	
	</form:form>
</body>
</html>
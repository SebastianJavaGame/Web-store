<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${clients}" var="client">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${client.id}</h3>
					<p>${client.name}</p>
					<p>${client.last_name}</p>
					<p>${client.address}</p>
					<p>${client.email}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>
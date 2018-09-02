<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WebStore</title>
	<link rel="stylesheet" href="<c:url value="resources/styles/style.css"/>"/>
</head>
<body>
	<div id="wrapper">
		<c:if test="${admin == true}">
			<header id="topSide">
				<div class="option">
					<a href="/scislak/products"><p>View shop</p></a>
				</div>
				<div class="option">
					<a href="/scislak/adminHome"><p>Add product</p></a>
				</div>
				<div class="option">
					<a href="#"><p>Delete product</p></a>
				</div>
				<div class="option">
					<a href="#"><p>Add admin</p></a>
				</div>
				<div class="option">
					<a href="#"><p>Delete admin</p></a>
				</div>
				<div id="logout">
					<a href="<c:url value="/j_spring_security_logout"/>"><p>Logout</p></a>
				</div>
				<div style="clear: both"></div>
			</header>
		</c:if>
		<c:if test="${admin == false}">
			<header id="topSide">
				<div class="option">
					<a href="/scislak/products"><p>Shop</p></a>
				</div>
				<div class="option">
					<a href="/scislak/clientHome"><p>Atual orders</p></a>
				</div>
				<div class="option">
					<a href="#"><p>History orders</p></a>
				</div>
				<div id="logout">
					<a href="<c:url value="/j_spring_security_logout"/>"><p>Logout</p></a>
				</div>
				<div style="clear: both"></div>
			</header>
		</c:if>
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.id}</h3>
						<p>${product.name}</p>
						<p>${product.category}</p>
						<p>${product.netto}</p>
						<p>${product.brutto}</p>
						<p>${product.vat}</p>
					</div>
				</div>
			</div>
		</c:forEach>
</body>
</html>
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
		<div id="infoProductHead">
			<table>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Category</th>
					<th>Netto</th>
					<th>Brutto</th>
					<th>Vat</th>
				</tr>
			</table>
		</div>
		<c:forEach items="${products}" var="product">
					<div class="caption">
						<table id="infoProduct">
							<tr>
								<td><img width="100px" height="100px"></img></td>
								<td>${product.name}</td>
								<td>${product.category}</td>
								<td>${product.netto}</td>
								<td>${product.brutto}</td>
								<td>${product.vat}</td>
							</tr>
						</table>
					</div>
		</c:forEach>
</body>
</html>
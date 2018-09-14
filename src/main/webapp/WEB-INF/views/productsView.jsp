<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

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
			<form:form action="" method="post" modelAttribute="objectCategory">
				<table>
					<tr>
						<th></th>
						<th></th>
						<th>
							<form:select path="category">
								<option value="" label="All"/>
								<form:options items="${listOfCategory}"/>
							</form:select>
						</th>
						<th></th>
						<th></th>
						<th></th>
						<th>
							<input type="submit" name="addFilter" value="Search"/>
						</th>
					</tr>
					<tr>
						<th>Image</th>
						<th>Name</th>
						<th>Category</th>
						<th>Netto</th>
						<th>Brutto</th>
						<th>Vat</th>
						<c:if test="${admin == false}">
						<th>Buy</th>
						</c:if>
					</tr>
				</table>
			</form:form>
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
								<c:if test="${admin == false}">
								<td>
									<form action="" method="post">
										<input type="text" name="count" size="10" value="1">
										<input type="hidden" name="index" value=${product.id}>
										<input type="submit" name="addProduct" value="Add to buy list"/>
									</form>
								</td>
								</c:if>
							</tr>
						</table>
					</div>
		</c:forEach>
</body>
</html>
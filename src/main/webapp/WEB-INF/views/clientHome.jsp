<%@page import="javax.persistence.criteria.Order"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mój sklep</title>
	<link rel="stylesheet" href="<c:url value="resources/styles/style.css"/>"/>
</head>
<body>
	<div id="wrapper">
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
		<section>
			<div id="clientStore">
				<div id="clientColumn">
					<header>
						<div id="divAvatar">
							<img  id="avatar" alt="Twoje zdjęcie" src="<c:url value="resources/images/avatar.jpg"/>"/>
						</div>
						<section>
							<div class="date">
								<p class="atribute">Name</p>
								<p class="value">${client.name}</p>
							</div>
							<div class="date">
								<p class="atribute">E-mail</p>
								<p class="value">${client.email}</p>
							</div>
							<div class="date">
								<p class="atribute">Adres</p>
								<p class="value">${client.address}</p>
							</div>
							<div class="date">
								<p class="atribute">Postcode</p>
								<p class="value">${client.postcode}</p>
							</div>
						</section>
					</header>
				</div>
				<div id="ordersList">
					<table style="width:100%">
						<tr>
							<th><p>OBJECT</p></th>
							<th><p>CATEGORY</p></th>
							<th><p>BRUTTO</p></th>
							<th><p>COUNT</p></th>
							<th><p>TOTAL</p></th>
						</tr>
						<c:forEach items="${orders}" var="order">
							<tr>
								<th>${order.product.name}</th>
								<th>${order.product.category}</th>
								<th>${order.product.brutto}zł</th>
								<th>${order.count}</th>
								<th>${order.product.brutto * order.count}zł</th>
							</tr>
						</c:forEach>
						<tr class="result">
							<th><p>SUMMARY</p></th>
							<th><p>-</p></th>
							<th><p>-</p></th>
							<th><p>${totalCount}</p></th>
							<th><p>${totalPrice}zł</p></th>
						</tr>
					</table>
				</div>
			</div>
		</section>
		<div style="clear: both"></div>
		<footer>sebek2088s4@tlen.pl</footer>
	</div>
</body>
</html>
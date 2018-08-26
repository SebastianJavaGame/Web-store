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
				<a href="#"><p>Shop</p></a>
			</div>
			<div class="option">
				<a href="#"><p>Atual orders</p></a>
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
							<th><p>COUNT</p></th>
							<th><p>VAT23%%</p></th>
							<th><p>NETTO</p></th>
							<th><p>TOTAL</p></th>
						</tr>
						<tr>
							<th><p>Chleb razowy czarny</p></th>
							<th><p>2</p></th>
							<th><p>0.10</p></th>
							<th><p>2.00</p></th>
							<th><p>4.20</p></th>
						</tr>
						<tr class="result">
							<th><p>RESULT</p></th>
							<th><p>2</p></th>
							<th><p>0.20</p></th>
							<th><p>4.00</p></th>
							<th><p>4.20</p></th>
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
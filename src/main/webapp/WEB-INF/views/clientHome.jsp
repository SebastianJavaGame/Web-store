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
			<div id="shop">
				<a href="#"><p>Shop</p></a>
			</div>
			<div id="logout">
				<a href="<c:url value="/j_spring_security_logout" />"><p>Logout</p></a>
			</div>
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
					<p>Zamówienie 13027 - Chlep razowy - 2.50zł</p>
				</div>
			</div>
		</section>
		<footer></footer>
	</div>
</body>
</html>
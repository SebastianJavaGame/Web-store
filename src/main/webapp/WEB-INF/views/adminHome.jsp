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
	<script src="<c:url value="resources/javascript/script.js"/>"></script>
</head>
<body>
	<div id="wrapper">
		<header id="topSide">
			<div class="option">
				<a href="/scislak/productsAdmin"><p>View shop</p></a>
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
					<form:form modelAttribute="product">
		
						<div>
						<form:input path="name" type="text" placeholder="name"/><br/>
						<form:errors path="name"/>
						</div>
						
						<div>
						<form:input path="category" type="text" placeholder="category"/><br/>
						<form:errors path="category"/>
						</div>
						
						<div>
						<form:input path="netto" type="" placeholder="netto"/><br/>
						<form:errors path="netto"/>
						</div>
						
						<div>
						<form:input path="brutto" type="text" placeholder="brutto"/><br/>
						<form:errors path="brutto"/>
						</div>
						
						<div>
						<input type="submit" value="Send"/><br/>
						</div>
					
					</form:form>
				</div>
			</div>
		</section>
		<div style="clear: both"></div>
		<footer>sebek2088s4@tlen.pl</footer>
	</div>
</body>
</html>
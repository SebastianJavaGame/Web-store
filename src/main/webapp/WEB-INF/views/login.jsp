<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
	<section>
		<div>
			<h1>Produkty</h1>
			<p>Dodaj produkty</p>
		</div>
	</section>
<div>
    <div>
		<div>
    		<div>
			  	<div>
			    	<h3>Zaloguj się</h3>
			 	</div>
			  	<div>
			  	<c:if test="${not empty error}">
					<div>
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
					</div>
				</c:if>
			    	<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
                    <fieldset>
			    	  	<div>
			    		    <input placeholder="E-mail" name='j_username' type="text">
			    		</div>
			    		<div>
			    			<input placeholder="Hasło" name='j_password'  type="password" value="">
			    		</div>
			    		<input type="submit" value="Zaloguj się">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>

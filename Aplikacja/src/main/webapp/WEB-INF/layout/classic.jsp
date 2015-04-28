<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html >
<html>
<head>

<%@	taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@	taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript" 
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"> </script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<div class="container">

		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/" />'>Błotnix</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' :''}"><a href='<spring:url value="/" />'>Home</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' :''}"><a href='<spring:url value="/users.html" />'>Users</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'register' ? 'active' :''}"><a href='<spring:url value="/register.html" />'>Register</a></li>
						</security:authorize>
						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'login' ? 'active' :''}"><a href='<spring:url value="/login.html" />'>Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'account' ? 'active' :''}"><a href='<spring:url value="/account.html" />'>My account</a></li>
							<li><a href='<spring:url value="/logout" />'>Logout</a></li>
						</security:authorize>
						<li><a href='<spring:url value="/zasoby.html" />'>zasoby</a></li>
						<li><a href='<spring:url value="/harmonogram.html" />'>harmonogram</a></li>
						<li><a href='<spring:url value="/raporty.html" />'>raporty</a></li>
						<li><a href='<spring:url value="/pliki.html" />'>pliki</a></li>
						<li><a href='<spring:url value="/kontakt.html" />'>kontakt</a></li>
						<li><a href='<spring:url value="/trzy.html" />'>trzy</a></li>
						<li><a href='<spring:url value="/cztery.html" />'>cztery</a></li>
					<li class="${param.page == 'chatroom' ? 'active' : ''}"><a href="<c:url value="/chatroom.html" />">New Chatroom</a></li>
					<li class="${param.page == 'list' ? 'active' : ''}"><a href="<c:url value="/chatroom/list.html" />">Chatroom List</a></li>
					<li class="${param.page == 'about' ? 'active' : ''}"><a href="<c:url value="/about.html" />">About</a></li>
					</ul>

				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>

		<tiles:insertAttribute name="body" />
		<br> <br>
		<center>
			<tiles:insertAttribute name="footer" />
		</center>

	</div>

</body>
</html>
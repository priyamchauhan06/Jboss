<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ThirdPartyResources/Materialize/css/materialize.min.css">
<title>clientinfo</title>
</head>
<body bgcolor="black">
	<nav>
		<div class="nav-wrapper grey darken-4" id="loginmenu">
			<a class="brand-logo"
				href="${pageContext.request.contextPath}/index.jsp">ServerInfo</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a
					href="${pageContext.request.contextPath}/home/clientinfo">Client
						Info</a></li>
				<li><a
					href="${pageContext.request.contextPath}/home/serverinfo">Server
						Info</a></li>
				<li><a href="${pageContext.request.contextPath}/home/jvminfo">Jvm
						Info</a></li>

			</ul>

		</div>

	</nav>
<div class="container">
	<br>
	<br>
	<br>
	<br>

	<table class="highlight centered white">
		<thead>
			<tr>
				<th>Client Ip</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=request.getAttribute("ClientIP")%></td>
			</tr>
		</tbody>
	</table>
</div>
	<script
		src="${pageContext.request.contextPath}/ThirdPartyResources/Materialize/js/materialize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/ThirdPartyResources/jquery/jquery-3.3.1.min.js"></script>

</body>
</html>
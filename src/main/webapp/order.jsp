<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ordermap.model.ServiceProvider" %>
<% request.setAttribute("products", ServiceProvider.getOrderService().showAllProducts()); %>
<% request.setAttribute("orders", ServiceProvider.getOrderService().) %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customers</title>
		<meta charset="iso-8859-1" />
		<link rel="stylesheet" type="text/css" href="products.css">
	</head>
	
	<body>
		<div id="results">
			<form action="Customers" method="post">
				<table>
					<tr><th>Id</th><th>Name</th><th>Account</th><th>Address</th></tr>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.productID}</td>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td>${product.stock}</td>
							
							<td><button name="toDelete" value="${product.productID}" type="submit">delete</button></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<div id="results2">
			<form action="Order" method="post">
				<table>
					<tr><th>Id</th><th>Name</th><th>Account</th><th>Address</th></tr>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.name}</td>
							<td>${product.price}</td>
							
							<td><button name="toDelete" value="${product.productID}" type="submit">delete</button></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</body>
</html>
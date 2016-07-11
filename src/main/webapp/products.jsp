<%@page import="ordermap.model.ServiceProvider"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setAttribute("products", ServiceProvider.getOrderService().showAllProducts()); %>

<!DOCTYPE html>
<html>
	<head>
		<title>Customers</title>
		<meta charset="iso-8859-1" />
		<link rel="stylesheet" type="text/css" href="products.css">
	</head>
	
	<body>
		<div id="results">
			<form action="Products" method="post">
				<table>
					<tr><th>Id</th><th>Stock</th><th>Name</th><th>Price</th></tr>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.productID}</td>
							<td>${product.stock}</td>
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
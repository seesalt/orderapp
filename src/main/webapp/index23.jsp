<%@page import="java.util.*"%>
<%@page import="ordermap.model.ServiceProvider"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setAttribute("products", ServiceProvider.getOrderService().returnAllProducts()); %>
<!--  @taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" -->
<html>
	<head>
		<script src="https://code.jquery.com/jquery-2.2.3.js"></script>
		<script src="my_jquery_functions.js"></script>
		<style>
		body {margin:0;}
		
		ul {
		    list-style-type: none;
		    margin: 0;
		    padding: 0;
		    overflow: hidden;
		    background-color: #333; 
		    position: fixed;
		    top: 0;
		    width: 100%;
		}
		
		li {
		    float: left;
		}
		
		li a {
		    display: block;
		    color: white;
		    text-align: center;
		    padding: 14px 16px;
		    text-decoration: none;
		}
		
		li a:hover:not(.active) {
		    background-color: #111;
		}
		
		.active {
		    background-color: #4CAF50;
		}
		</style>
	</head>
		<body>
		
			<ul>
	  			<li><a class="active" href="index.jsp">Home</a></li>
	  			<li><a href="register.jsp">Register</a></li>
			</ul>

			
			<div style="padding:20px;margin-top:30px;background-color:#1abc9c;height:1500px;" id="login">
				
					<div id ="iets">
						RESTAURANT APP
						
					</div>
					<h3 id="showForm"> Tafel 1</h3>
						<div id="results">
							<form action="Products" method="post">
								<table>
									<tr><th>Id</th><th>Stock</th><th>Name</th><th>Price</th></tr>
									<c:forEach items="${orders}" var="order">
										<tr>
											<td>${order.orderID}</td>
											<td>${order.tableNR}</td>
											<td>${order.orderID.productID}</td>
											<td>${product.price}</td>
											<td><button name="toDelete" value="${product.productID}" type="submit">delete</button></td>
										</tr>
									</c:forEach>
								</table>
							</form>
						</div>
					<h3 id="showForm"> Tafel 2</h3>
						<div id="results">
							
							<c:forEach var="product" items="${table.deBesteldeProducten}">                          
					        <h3><c:out value="${product.amount}"/></h3><p><c:out value="${product.price}"/></p>
					    </c:forEach>
						
						</div>	
					<h3 id="showForm"> Tafel 3</h3>
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
						<div id="bestellen">
							<form action = "Orders" method= "post">
							<table>
								<tr><th>Bestelling</th><th>Aantal</th><th>Name</th><th>Price</th></tr>
								<select>
									<c:forEach items="${products}" var="product">
									<option>${product.name}</option>
									</c:forEach>
								</select>
								
							</table>
							
							</form>
						
						</div>
					<h3 id="showForm"> Tafel 4</h3>
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
					<h3 id="showForm"> Tafel 5</h3>
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
					<h3 id="showForm"> Tafel 6</h3>
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
					<h3 id="showList">Product List</h3>	
					<div id="productList">
						<a href="#" id="all">All</a>
						
		
		
						<table border = "1" id="products">
						</table>
					</div>	
			</div>
		</body>
</html>
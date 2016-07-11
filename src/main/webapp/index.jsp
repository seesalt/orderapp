<%@page import="java.util.*"%>
<%@page import="ordermap.model.ServiceProvider"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setAttribute("products", ServiceProvider.getOrderService().returnAllProducts()); %>
<% request.setAttribute("service", ServiceProvider.getOrderService()); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Theme Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body role="document">

    <!-- Fixed navbar -->
 <!--     <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse 
      </div>
    </nav> -->

    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      


      <div class="page-header">
        <h1>Order</h1>
      </div>
     
      <form class="form-horizontal" role="form" action ="OrderServlet.do" method="post">
	  		<div class ="form-group">
				<label class="control-lable col-sm-2" for="tablenr">Table Number:<br></label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="tablenr" name="tableNR" placeholder="Select Table Number" min="1" max="15">
				</div>
			</div>
			<div class ="form-group">
				<label class="control-lable col-sm-2" for="product">Product:<br></label>
				<div class="col-sm-10">
					<select class="form-control" id="sel1" name="product">
						<option value="" disabled selected>Select your option</option>
      					<c:forEach var="product" items="${products}">
      						<option>${product.name}</option>
      					</c:forEach>
      				</select>
				</div>
			</div>
			<div class ="form-group">
				<label class="control-lable col-sm-2" for="amount">Amount:<br></label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="amount" name="amount" placeholder="Select amount" min="1" max="15" >
				</div>
			</div>
			<div class="form-group">
      			<div class="col-sm-offset-2 col-sm-10">
        			<button type="submit" class="btn btn-default">Submit</button>
      			</div>
    		</div>
  		</form>
  		
  		<div class="page-header">
        <h1>Add a Product</h1>
      </div>
     
      <form class="form-horizontal" role="form" action="ProductServlet.do" method="post">
			<div class ="form-group">
				<label class="control-lable col-sm-2" for="price">Product:<br></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name">
				</div>
			</div>
			<div class ="form-group">
				<label class="control-lable col-sm-2" for="price">Price:<br></label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="price" name="price" step="0.05">
				</div>
			</div>
			<div class ="form-group">
				<label class="control-lable col-sm-2" for="amount">Amount:<br></label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="stock" name="stock" placeholder="Select amount" min="1" max="15" >
				</div>
			</div>
			<div class="form-group">
      			<div class="col-sm-offset-2 col-sm-10">
        			<button type="submit" class="btn btn-default">Submit</button>
      			</div>
    		</div>
  		</form>
  		
  		<div class="page-header">
        <h1>Pay</h1>
      </div>
     
      <form class="form-horizontal" role="form" action="PayServlet.do" method="post">
	  		<div class ="form-group">
				<label class="control-lable col-sm-2" for="name">Table Number:<br></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" placeholder="Select Table Number" min="1" max="15">
				</div>
			</div>
			<div class="form-group">
      			<div class="col-sm-offset-2 col-sm-10">
        			<button type="submit" class="btn btn-default">Submit</button>
      			</div>
    		</div>
  		</form>
      


      <div class="page-header">
        <h1>Tables</h1>
      </div>
      <div class="row">
        <div class="col-md-6">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>Name</th>
                <th>Stock</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
              <tr>
                <td>${product.productID}</td>
                <td>${product.name}</td>
                <td>${product.stock}</td>
                <td>${product.price}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col-md-6">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Table Nr</th>
                <th>Order Nr</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${orders}" var="order">
              <tr>
                <td>${order.orderID}</td>
                <td>${order.tableNR}</td>
                <td>${order.completed}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>


    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

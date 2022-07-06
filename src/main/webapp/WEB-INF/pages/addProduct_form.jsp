

<jsp:include page="menu.jsp" />
<html>
<head>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/reg.css">

<title>Add Product</title>
</head>
<body>
<h4 style="color:red">${msg}</h4>
<form action="addUser" method="post" onsubmit="" name="myForm">
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome</h3>
				<p>You are 30 seconds away from earning your own money!</p>

			</div>
			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">ADD PRODUCT</h3>
						<div class="row register-form">
							<div class="col-md-8">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="PRODUCT NAME *" value="" name="productName"  required="required"/>
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="PRODUCT PRICE  *" value="" name="productPrice" />
								</div>


								<input type="submit" class="btnRegister" value="ADD USER" />
							</div>
							
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
	</form>
</body>
</html>
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

<title>Profile</title>
</head>
<body>
<h4 style="color:red">${msg}</h4>
<form action="updateUser" method="post"  name="myForm">
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
						<h3 class="register-heading">PROFILE</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="USERNAME *" value="${user.username}" name="username"  required="required" readonly="readonly"/>
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="PASSWORD *" value="${user.password}" name="password" required="required"/>
								</div>


								<div class="form-group">
									<div class="maxl">
										<label class="radio inline"> <input type="radio"
											name="gender" value="male" checked> <span>
												Male </span>
										</label> <label class="radio inline"> <input type="radio"
											name="gender" value="female"> <span>Female </span>
										</label>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<select class="form-control" name="role">
									<option value="${user.role}">${user.role}</option>
									<option value="Admin">Admin</option>
									<option value="User">User</option>
									</select>
								</div>
								<div class="form-group">
									<select class="form-control" name="question">
									<option value="${user.question}">${user.question}</option>
									<option>What is your Birthdate?</option>
									<option>What is Your old Phone Number</option>
									<option>What is your Pet Name?</option>
									</select>
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Enter Your Answer *" value="${user.answer}" name="answer" />
								</div>
								<input type="submit" class="btnRegister" value="Update Profile" />
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
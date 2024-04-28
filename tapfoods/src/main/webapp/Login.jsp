<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tap Foods</title>
<link rel="icon" href="http://localhost:8080/tapfoods/Images/icon.png">
<style>
body {
	display: flex;
	justify-content: center;
	margin-top: 75px;
	background-color:  #B7C8E9;
}

.box {
	height: 500px;
	width: 400px;
	display: flex;
	justify-content: center;
	align-items: center;
	box-shadow: 2px 2px 5px 5px gray;
	border-radius: 20px;
	background-color: #ffff;
	
}
.login{
margin:-3% 0% 0% 0%;
}
.login h1 {
	font-size: 40px;
	text-decoration: underline;
	text-decoration-color: #fca311;
}

.inputbox1, .inputbox2 {
	width: 250px;
	border-bottom: 2px solid;
	padding-top: 20px;
	display: flex;
	align-items: center;
}

.inputbox1 input, .inputbox2 input {
	width: 97%;
	height: 27px;
	border: none;
	outline: none;
	background: transparent;
	font-size: 15px;
}

.inputbox1 label, .inputbox2 label {
	color: #fca311;
	position: absolute;
	font-weight: 900;
	cursor:text;
}

.inputbox1 input:focus ~label, .inputbox1 input:valid ~label {
	top: 254px;
	font-size: 13px;
	transition: font-size 0.2s ease;
}

.inputbox2 img {
	height: 25px !important;
	cursor:pointer;
	padding-right: 2px;
}

.inputbox2 input:focus ~label, .inputbox2 input:valid ~label {
	top: 307px;
	font-size: 13px;
	transition: font-size 0.2s ease;
}


.submit {
    margin-top:8%;
	padding-top: 24px;
	padding-left: 190px;
}

.submit input {
	font-size: 15px;
	padding: 4px;
	background-color: #fca311;
	border-radius: 10px 2px;
}

.submit input:hover {
	font-size: 14.5px;
	background-color: white;
	transform: scale(0.95);
	}
.reset{
position: absolute;
margin:-6.5% 0% 0% 0%;
}
.reset a{
text-decoration: none;
	color:#fca311;
	padding-left: 10px;
	font-size: 15px;

}
.reset a:hover{

	color:black;
	
	

}
.signup a{
	text-decoration: none;
	color: #fca311;
	padding-left: 10px;
	font-size: 17.5px;
}

.signup a:hover{
	color:black ;
}
.errormessage1{
position:absolute;
color:red;
font-size:14px;
margin:22% 0% 0% -1%;

}
.errormessage2{
position:absolute;
color:red;
font-size:14px;
margin:22% 0% 0% -4%;
}
.pleaselogin{
position:absolute;
color:red;
font-size:14px;
font-weight:700;
margin:0% 0% 0% 0%;
}
.successmes{
position:absolute;
background-color:green;
border-radius:0px 0px 5px 5px;
width:190px;
color:#ffff;
font-size:20px;
font-weight:700;
margin:0% 0% 0% 0%;
}
.successmes1{
position:absolute;
background-color:green;
border-radius:0px 0px 5px 5px;
color:#ffff;
height:25px;
font-size:15px;
font-weight:700;
margin:0% 0% 0% 0%;
}
</style>
</head>
<body>
	<div class="box">
		<div class="login">
			<h1>Login</h1>

			<form action="loginservlet" method="post">
				<div>
					<div class="inputbox1">
						<input type="text" id="userName" name="userName" required>
						<label for="userName">UserName</label> <br>
					</div>
					<div class="inputbox2">
						<input type="password" id="password" name="password" required >
						<label for="password">Password</label> <img
							src="http://localhost:8080/tapfoods/Images/eye-close.png" alt="eye-close icon"
							class="closed-eye" id="icon" onclick="myfunction()">
					</div>
				</div>


				<div class="submit">
					<input type="submit">
				</div>
				<div class="reset">
				<h5>Forgot Password ? <a href="ResetPassword.jsp">Reset Here</a></h5>
				</div>
				<div class="signup">
					<h4>
						New &nbsp; Account ?<a href="Signup.jsp">Sign Up</a>
					</h4>
				</div>
			</form>
		</div>
	</div>






<!-- javascript -->


	<script>
		let eyeicon = document.getElementById("icon")
		let password = document.getElementById("password")

		function myfunction() {
			if (password.type == "password") {
				password.type = "text";
				eyeicon.src = "http://localhost:8080/tapfoods/Images/eye%20-open.png";
			} else {
				password.type = "password";
				eyeicon.src = "http://localhost:8080/tapfoods/Images/eye-close.png"
			}
		}
	</script>
</body>
</html>
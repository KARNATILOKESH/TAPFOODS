<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tapfoods.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tap Foods</title>
<link rel="icon" href="http://localhost:8080/tapfoods/Images/icon.png">
<style>
body {
	background-color: #B7C8E9;
}

::-webkit-scrollbar {
	width: 5px;
}

::-webkit-scrollbar-thumb {
	background: #fca311;
	border-radius: 20px;
}

nav {
	height: 75px;
	width: 101.5%;
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: rgba(255, 255, 255, 0.9);
	margin: -6% 0% 0% -1%;
	position: fixed;
		z-index: 999;
}

nav .logo {
	margin: 0.2% 0% 0% 0.5%;
}

nav .logo img {
	margin: 10% 0% 0% -8%;
	height: 30vh;
	width: 100%;
}

nav ul {
	list-style: none;
	display: flex;
	gap: 30px;
	margin-right: 40px;
	margin-top: 25px;
	text-shadow: 1px 1px 1px gray;
}

nav ul li .search-icon {
	font-size: 25px;
	cursor: pointer;
	color: black;
	padding-top: 30px;
	text-shadow: 1px 1px 1px gray;
}

nav ul li .search-icon .icon {
	font-size: 23px;
	cursor: pointer;
}

nav ul li .search-icon:hover {
	color: #fca311;
}

a {
	text-decoration: none;
	color: black;
	font-size: 25px;
}

nav  a:hover {
	color: #fca311;
}

.search {
	margin: 3% 0% 0% 0%;
	width: %;
	display: flex;
	flex-direction: row;
	justify-content: center;
}

.search form {
	display: flex;
	margin: 0% 0% 2% 11%;
	cursor: text;
}

.search .search-bar input {
	width: 70vw;
	height: 50px;
	border: 1px solid black;
	border-radius: 7px;
	outline-color: #B7C8E9;
	padding: 0% 0% 0% 1%;
	cursor: text;
}

.search .search-bar input::placeholder {
	font-size: 15px;
	font-weight: 600;
}

.search .search-submit input {
	margin: 1.8% 0% 0% -101%;
	width: 120px;
	height: 46px;
	font-size: 2vw;
	font-weight: 600;
	border: none;
	cursor: pointer;
	background-color: #B7C8E9;
	border-radius: 0px 7px 7px 0px;
}

::-webkit-search-cancel-button {
	display: none;
}

.search .search-submit input:hover {
	background-color: rgba(252, 163, 17, 0.8);
}

section {
	margin: 6% 0% 0% 0%;
}

section .banner {
	width: 100%;
	height: 60%;
	margin: 0% 0% 0% 0%;
	border-radius: 0px 0px 15px 15px;
	box-shadow: 1px 1px 1.5px 0.5px gray;
	background-color: #fff;
	display: flex;
}

section .banner img {
	position: absolute;
	width: 40%;
	margin: -6% 0% 0% 27%;
}

section .banner .picture2 {
	position: absolute;
	width: 32%;
	margin: 8% 0% 0% 10%;
}

section .banner .picture3 {
	position: absolute;
	width: 30%;
	margin: 5.5% 0% 0% 59%;
	mix-blend-mode: multiply;
}

section .banner .text1 {
	width: 28%;
	margin: 2% 0% 2% 10%;
	font-size: 4vw;
}

section .banner .text2 {
	width: 25%;
	margin: 4% 0% 0% 32%;
	font-size: 4vw;
}

section .restaurants {
	width: 97%;
	margin: 2% 0% 0% 1.2%;
	margin-left: 3.5%;
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(250px, 10px));
	grid-gap: 5%;
}

section .restaurants .box {
	width: 22vw;
	border-radius: 15px;
	cursor: pointer;
	overflow: hidden;
	background-color: #fff;
}

section .restaurants .box:hover {
	box-shadow: 2px 2px 12px  2px gray;
	transform: scale(0.99);
}

section .restaurants .box .picture img {
	height: 190px;
	width: 95%;
	border: 1px solid gray;
	border-radius: 15px;
	box-shadow: 1px 1px 3px 1px gray;
	margin: 2% 0% 0% 2.2%;
}

section .restaurants .box .discription {
	width: 100%;
	border-radius: 15px;
	margin: 0% 0% 0% 2%;
}

section .restaurants .box .discription .name {
	font-size: 2.5vw;
	margin: 2% 0% 0% 3%;
}

section .restaurants .box .discription .rating {
	border: 0.5px solid;
	width: 19%;
	color: #fff;
	background-color: green;
	border-radius: 5px;
	font-size: 1.5vw;
	margin: -10% 0% 0% 3%;
	padding: 1%;
}

section .restaurants .box .discription .eta {
	font-size: 1.5vw;
	margin: -9% 0% 0% 30%;
}

section .restaurants .box .discription .cuisineType {
	font-size: 1.5vw;
	margin: 3% 0% 0% 3%;
}

section .restaurants .box .discription .address {
	font-size: 1.5vw;
	margin: -12% 0% 3% 3%;
}

footer {
	color: white;
	width: 97%;
	margin: 10% 0% 0% 1.2%;
	background-color: RGBA(68, 68, 68, 0.5);
	border-radius: 5px 5px 20px 20px;
	display: flex;
	align-items: center;
	justify-content: space-evenly;
	width: 97%;
}

footer .c {
	margin: 0% 0% 0% 10%;
}

footer  ul li {
	color: white;
	list-style: none;
	font-size: 1.7vw;;
}
ul .special:hover{
	color:#fca311;
	}
footer  .devisions {
	font-size: 2vw;
}

@media all and (max-width:600px) {
	nav {
		margin: -17% 0% 0% -1%;
	}
	section {
		margin: 17% 0% 0% 0%;
	}
	section .restaurants {
		margin: 4.5% 0% 0% 1.2%;
		display: grid;
		grid-template-columns: repeat(auto-fit, minmax(120px, 10px));
		grid-gap: 40px;
	}
	section .restaurants .box {
		width: 150px;
		transition: 0.3s;
	}
	section .restaurants .box:hover {
		width: 149px;
		transition: 0.3s;
	}
	section .restaurants .box .picture img {
		height: 150px;
		width: 95%;
	}
	section .restaurants .box .discription .name {
		font-size: 15px;
	}
	section .restaurants .box .discription .rating {
		width: 40px;
		font-size: 14px;
		margin: -19% 0% 0% 3%;
	}
	section .restaurants .box .discription .eta {
		font-size: 13px;
		margin: -13% 0% 0% 49%;
	}
	section .restaurants .box .discription .cuisineType {
		font-size: 14px;
		margin: 5% 0% 0% 3%;
	}
	section .restaurants .box .discription .address {
		font-size: 14px;
		margin: -19% 0% 3% 3%;
	}
	footer {
		display: flex;
		flex-wrap: 1;
		overflow-x: scroll;
	}
	::-webkit-scrollbar {
		width: 0;
	}
	footer .companyname {
		font-size: 12px;
		margin: -18% 0% 0% 3%;;
	}
	footer .c {
		margin: 0% 0% 0% 29%;
	}
	footer  ul li {
		color: white;
		list-style: none;
		font-size: 13px;;
	}
	ul .special:hover{
	color:#fca311;
	}
	footer  .devisions {
		font-size: 14px;
	}
	footer .company {
		margin: 15% 0% 0% -33%;
	}
}
</style>
</head>
<body>
	<nav>
		<div class="logo">
			<a href="#"><img src="http://localhost:8080/tapfoods/Images/MainLogo.png" alt="logo"></a>
		</div>
		<ul>
          
			
			<li><a href="Login.jsp"><b>Login</b></a></li>
			<li><a href="Signup.jsp"><b>Signup</b></a></li>
		</ul>
	</nav>
	

	<section>
		<div class="banner">
			<div class="picture1">
				<img
					src="http://localhost:8080/tapfoods/Images/MainLogo.png"
					alt="picture" class="picture1">
			</div>
			<div class="picture2">
				<img
					src="https://cdn.pixabay.com/photo/2020/05/25/08/40/food-delivery-5217579_1280.png"
					alt="picture" class="picture2">
			</div>
			<div class="picture3">
				<img
					src="https://cdn.pixabay.com/photo/2023/08/12/02/42/ai-generated-8184596_1280.png"
					alt="picture" class="picture3">
			</div>
			<div class="text1">
				<b>From<br> Kitchen <br> to <br>Couch
				</b>
			</div>
			<div class="text2">
				<b>Enjoy Every<br> Bite,<br>Every Time
				</b>
			</div>
		</div>

 <div class="search" id="search">
	<form action="serchservlet">
	<div class="search-bar"><input type="search" name="search" placeholder="What you are looking for ? Search a specific restaurant here"></div>
   <div class="search-submit"> <input type="submit" value="&#128269;"></div>
	</form>
	</div>
		<div class="restaurants">
			<%
			List<Restaurant> list = (List<Restaurant>) session.getAttribute("restaurants");

			for (Restaurant restaurant : list) {
			%>
			<a href="callindexmenu?restaurantId=<%=restaurant.getRestaurantId()%>">
				 <div class="box">
					<div class="picture">
						<img src="<%=restaurant.getImagePath()%>" alt="picture">
					</div>
					<div class="discription">
						<div class="name"><%=restaurant.getName()%></div>
						<br>
						<div class="rating">
							&#9733;<%=restaurant.getRating()%></div>
						<div class="eta"><%=restaurant.getEta()%></div>
						<div class="cuisineType"><%=restaurant.getCuisineType()%></div>
						<br>
						<div class="address">
							<%=restaurant.getAddress()%></div>
					</div>
				</div>
			</a>
			<%
			}
			%>
		</div>
	</section>
	<footer>
		<div class="companyname">
			<h1>TapFoods</h1>
			<span class="c">©2024 </span>
		</div>
		<div class="company">
			<ul>
				<span class="devisions"><u>Contact Developer</u></span>
				<br>
				<a href="mailto:karnatilokeshtony@gmail.com" target="_blank"><li class="special">Email: karnatilokeshtony@gmail.com</li></a>
				<a href="https://www.linkedin.com/in/lokeshkarnati"  target="_blank"><li  class="special" >LinkedIn</li></a>
		<br>
				<span class="devisions"><u>Company</u></span>
				<br>
				<a href="#"><li>About</li></a>
				<a href="#"><li>Terms</li></a>
		<br>	
				<span class="devisions"><u>Legal</u></span>
				<br>
				<a href="#"><li>Terms&Conditions</li></a>
				<a href="#"><li>Cookies Policy</li></a>
				<a href="#"><li>Privacy Policy</li></a>
			</ul>
		</div>
	</footer>
	
	
	
<!--javaScript  -->
<!-- <script type="text/javascript">
document.getElementById("search-icon").addEventListener("click",function(){
	let search=document.getElementById("search");
	if(search.style.display=="none")
		{
		search.style.display="flex";
		}
	else
		{
		search.style.display="none"
		}
});
</script> -->
</body>
</html>

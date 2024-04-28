<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tapfoods.model.CartItem"%>
<%@ page import="com.tapfoods.model.User"%>
<%@ page import=" java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.Set"%>
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
	margin-right: 30px;
	margin-top: 35px;
	text-shadow: 1px 1px 1px gray;
}

nav a {
	text-decoration: none;
	color: black;
	font-size: 25px;
	margin-top: 1%;
}

nav  a:hover {
	color: #fca311;
}

nav .profile {
	position: relative;
	border-radius: 50%;
	height: 8vh;
	width: 48px;
	margin: -12% 0% 0% 12%;
	background:
		url("https://cdn.pixabay.com/photo/2016/08/31/11/54/icon-1633249_1280.png");
	background-size: 40px;
	background-position: 4.5px;
	background-repeat: no-repeat;
	box-shadow: 0px 0px 7px black;
	cursor: pointer;
	border-radius: 50%;
}

.profile-details {
	display: none;
	flex-direction: column;
	position: fixed;
	width: 25vw;
	border: 1px solid;
	background-color: rgba(0, 0, 0, 0.9);
	border-radius: 10px 10px 10px 10px;
	margin: -1.8% 0% 0% 70.5%;
	box-shadow: 0px 0px 7px black;
	z-index:999;
}

.profile-details .profilepic {
	border-radius: 50%;
	height: 50px;
	width: 45px;
	margin: 24px 20px 0px 20px;
	box-shadow: 0px 0px 7px black;
	background:
		url("https://cdn.pixabay.com/photo/2023/02/18/11/00/icon-7797704_1280.png");
	background-size: cover;
	background-position: -2px;
	background-repeat: no-repeat;
}

.profile-details .name {
	width: 70%;
	margin: -15% 0% 0% 20%;
	align-content: center;
	font-size: 3vw;
	padding-left: 5%;
	color: #ffff;
}

.profile-details .userName {
	width: 90%;
	margin: 10% 0% 0% 5%;
	align-content: center;
}

.profile-details .email {
	width: 90%;
	margin: 10% 0% 0% 5%;
}

.profile-details .phoneNo {
	width: 90%;
	margin: 10% 0% 0% 5%;
}

.profile-details .address {
	width: 90%;
	margin: 10% 0% 0% 5%;
}

.profile-details .titles {
	color: orange;
	font-size: 100%;
	padding-left: 5%;
}

.profile-details .values {
	color: #ffff;
	font-size: 120%;
}



.profile-details .logout-edit {
	margin: 7% 0% 5% 5%;
	display:flex;
	justify-content: space-around;
}


.profile-details .logout-edit .log{
margin-left:-15%;
}
.profile-details .logout-edit a {
	color: orange;
	margin: 0% 0% 0% 5%;
	font-size:2vw;
}

.profile-details .logout-edit a:hover {
	color: #ffff;
}

.profile-details .logout a:hover {
	color: #ffff;
}

.container {
	margin-left: 10%;
	margin-top: 6%;
	width: 80%;
	background-color: #ffff;
}

.items  .container1 {
	margin-top: 0.5%;
	background-color: #ffff;
	display: flex;
	justify-content: space-around;
}

.container1 .pic img{
width:100px;
height:80px;
border:1px solid;
margin-top:10%;
margin-left:15%;
border-radius: 10px;
object-fit:cover;
}

.container1 .name {
	margin: 2% 10% 0% 0%;
	font-size: 1.7vw;
	width: 30vw;
	overflow-x: hidden;
	padding: 0.5%;
}

.container1 .price {
	margin: 2% 10% 2% 0%;
	font-size: 1.7vw;
	width: 6vw;
	overflow-x: hidden;
	padding: 0.5%;
}

.container1 .quantity {
	margin: 2% 4% 2% -8%;
	font-size: 1.7vw;
	width: 8vw;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border: 2px solid #B7C8E9;
	padding: 0.5%;
}

.container1 .quantity .less {
	margin: -4% 0% -5% -4%;
	width: 3vw;
	height: 5vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container1 .quantity .less span {
	margin: -19% 0% 0% 0%;
	font-size: 34px;
	color: red;
	cursor: pointer;
}

.container1 .quantity .less:hover {
	background-color: #B7C8E9;
}

.container1 .quantity .less span:hover {
	font-size: 33px;
	margin: -18% 0% 0% 0%;
}

.container1 .quantity .quan {
	font: size 30px;
	margin: -4% 0% -5% 0%;
	width: 2.5vw;
	height: 5vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container1 .quantity .add {
	font: size 30px;
	margin: -4% -4% -5% 0%;
	width: 3vw;
	height: 5vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container1 .quantity .add span {
	margin: -5% 0% 0% 0%;
	color: green;
	font-size: 30px;
	cursor: pointer;
}

.container1 .quantity .add:hover {
	background-color: #B7C8E9;
}

.container1 .quantity .add span:hover {
	font-size: 33px;
	margin: -5% 0% 0% 0%;
}

.container1 .delete {
	margin: 2.7% 0% 2% -4%;
}

.container1 .delete img {
	height: 2vw;
	cursor: pointer;
}

.container1 .delete img:hover {
	margin: 15% 0% 2% 0%;
	height: 1.7vw;
}

.container2 {
	border-top: 1px solid #B7C8E9;
	margin-top: 1%;
	background-color: #ffff;
	display: flex;
	justify-content: space-between;
}

.container2 .addmore {
	border: 1px solid #B7C8E9;
	box-shadow: 0.1px 0.1px 3px 0.1px #c9d8f7;
	width: 12.5vw;
	padding: 1%;
	font-size: 1.5vw;
	margin: 10% 0% 10% 20%;
	cursor: pointer;
}

.container2 .chechout {
	border: 1px solid #B7C8E9;
	box-shadow: 0.1px 0.1px 3px 0.1px #c9d8f7;
	width: 18vw;
	padding: 1%;
	font-size: 1.5vw;
	margin: 7% 0% 10% -15%;
	cursor: pointer;
}

.container2 .addmore:hover {
	background-color: #B7C8E9;
}

.container2 .chechout:hover {
	background-color: #B7C8E9;
}

a {
	text-decoration: none;
	color: black;
}

.items h2 {
	margin: 0% 0% 0% 30%;
}

.container3 {
	margin:5% 0% 0% 13%;
	padding-bottom: 5%;
	background-color: #ffff;
}

.container3 .additemstext {
	border: 1px solid #B7C8E9;
	box-shadow: 0.1px 0.1px 3px 0.1px #c9d8f7;
	width: 16vw;
	padding: 1%;
	font-size: 1.5vw;
	cursor: pointer;
	margin-left: 18%;
}

.container3 .additemstext:hover {
	background-color: #B7C8E9;
}

.deletepopup {
	position: absolute;
	width: 30vw;
	background-color:rgba(0,0,0,0.4);
	margin: 4% 0% 0% 13%;
	display: none;
}

.deletepopup .text {
	margin: 5% 0% 0% 5%;
	font-size: 2.3vw;
}

.deletepopup .buttons {
	margin: 7% 0% 7% 0%; 
	gap: 40%;
	display: flex;
}

.deletepopup .buttons .cancel {
	margin: 0% 0% 0% 40%;
	
}

.deletepopup .buttons button {
	font-size: 1.5vw;
}

.deletepopup .buttons button:hover {
	background-color: #b7c8e9;
	
}
</style>
</head>
<body>
<nav>
		<div class="logo">
			<a href="#"><img
				src="http://localhost:8080/tapfoods/Images/MainLogo.png" alt="logo"></a>
		</div>
		<ul>


			<a href="Restaurant.jsp"><li class="elements"><b>Home</b></li></a>
			<a href="orderhistory"><li class="elements"><b>Order
						History</b></li></a>
			<a href="ViewCart.jsp"><li class="elements"><b>View Cart</b></li></a>
			<li><div class="profile" id="profile"></div></li>

		</ul>
	</nav>
					<!--pop up profile  -->
	<div class="profile-details" id="profile-details">

		<%
		User user = (User) session.getAttribute("user");
		%>
		<div class="profilepic"></div>
		<div class="name"><%=user.getName()%></div>
		<div class="userName">
			<span class="titles">USERNAME :</span><span class="values"> <%=user.getUserName()%></span>
		</div>
		<div class="email">
			<span class="titles">EMAIL : </span><span class="values"><%=user.getEmail()%></span>
		</div>
		<div class="phoneNo">
			<span class="titles">PHONENO :</span><span class="values"> <%=user.getPhoneNo()%></span>
		</div>
		<div class="address">
		<%if(user.getAddress()!=null)
		{
		 %>
			<span class="titles">ADDRESS :</span><span class="values"> <%=user.getAddress()%></span>
		<% }
		else
		{
		%>
		<span class="titles">ADDRESS :</span><span class="values"><a href="calledit?menu=menu">Add Address</a></span>
		<%}
		%>
		
		</div>

		<div class="logout-edit">
			<div class="log"><a href="indexservlet">LogOut</a></div> <div class="edit"><a href="calledit?isthiscart=cart">Edit</a></div>
		</div>

	</div>
	<div class="container">
		<div class="items">
			<%
			String rid = null;
			int quantity = 0;
			Map<Integer, CartItem> cartList = (Map<Integer, CartItem>) session.getAttribute("cartList");
			if (!(cartList.isEmpty())) {
				Set<Integer> keySet = cartList.keySet();
				for (Integer key : keySet) {

					CartItem cart = cartList.get(key);
					double price = cart.getPrice();
					quantity = cart.getQuantity();
					double total = price * quantity;
					rid = String.valueOf(cart.getRestaurantId());
			%>

			<div class="container1">
			<div class="pic"><img src="<%=cart.getImagePath() %>" alt="pic"></div>
				<div class="name"><%=cart.getItemName()%></div>
				<div class="price">
					&#8377;<%=total%></div>
				<div class="quantity">
					<a href="less?itemId=<%=cart.getItemId()%>&itemName= <%=cart.getItemName()%>&quantity=<%=cart.getQuantity()%>&price=<%=cart.getPrice()%>&restaurantId=<%=cart.getRestaurantId()%>&userId=<%=user.getUserId()%>&imagepath="<%=cart.getImagePath() %>"><div class="less">
							<span><b>-</b></span>
						</div></a>
					<div class="quan"><%=cart.getQuantity()%></div>
					<a href="add?itemId=<%=cart.getItemId()%>&itemName= <%=cart.getItemName()%>&quantity=<%=cart.getQuantity()%>&price=<%=cart.getPrice()%>&restaurantId=<%=cart.getRestaurantId()%>&userId=<%=user.getUserId()%>&imagepath="<%=cart.getImagePath() %>"><div class="add" id="add">
							<span><b>+</b></span>
						</div></a>
				</div>
				<div class="delete" id="delete">
				<a href="remove?itemId=<%=cart.getItemId()%>&userId=<%=user.getUserId()%>">	<img
						src="http://localhost:8080/tapfoods/Images/delete-icon.png"
						alt="delete"></a>
				</div>
				
			</div>

			<%-- <div class="deletepopup" id="deletepopup">
				<div class="text">Do want to remove this Item?</div>
				<div class="buttons">
					<a href="Cart.jsp"><div class="cancel">
						<button>Cancel</button>
					</div></a>
					<a href="remove?itemId=<%=cart.getItemId()%>"><div class="remove">
						<button>Yes,Remove</button>
					</div></a>
				</div>
			</div> 
 --%>

			

<%
			}
			%>
		</div>


		<div class="container2">
			<a href="callmenu?restaurantId=<%=rid%>&quantity=<%=quantity%> %>"><div
					class="addmore">ADD MORE ITEMS</div></a> <a href="checkout"><div
					class="chechout">PROCEED TO CHDECKOUT</div></a>
		</div>

	</div>


	<%
	} else {
	%>

	<div class="container">
		<div class="items">
			<br>
			<h2>Your cart is Empty</h2>
		</div>
		<div class="container3">
			<a href="Restaurantservlet"><div class="additemstext">SEE
					RESTAURANTS &nbsp; &#10140;</div></a>
		</div>
	</div>



	<%
	}
	%>
	
	
	 <!-- <script type="text/javascript">
	var deletepopup=document.getElementById("deletepopup");
	document.getElementById("delete").onclick=function(){
		if(deletepopup.style.display = "none"){
			deletepopup.style.display="grid";
		}
		else
			{
			deletepopup.style.display="none";
			}
		
	}
	</script>
	  -->
	<script type="text/javascript">
	document.getElementById("profile").addEventListener('mouseover',function(){
		document.getElementById("profile-details").style.display = "flex";
	});
	
	document.getElementById("profile").addEventListener('mouseleave',function(){
		document.getElementById("profile-details").style.display = "none";
	});
	
	document.getElementById("profile-details").addEventListener('mouseover',function(){
		document.getElementById("profile-details").style.display = "flex";
	});
	
	document.getElementById("profile-details").addEventListener('mouseleave',function(){
		document.getElementById("profile-details").style.display = "none";
	});

</script>
	
</body>
</html>
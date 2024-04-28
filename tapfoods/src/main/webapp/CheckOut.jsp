<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tapfoods.model.CartItem"%>
<%@ page import=" java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.Set"%>
<%@ page import="com.tapfoods.model.Menu"%>
<%@ page import="com.tapfoods.model.Restaurant"%>
<%@ page import="com.tapfoods.model.User"%>
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
margin-left:10%;
	margin-top: 6%;
	width: 80%;
	background-color: #ffff;
}

.restaurant {
	height: 16vh;
	display: flex;
	padding-top: 3%;
	gap: 1%;
	margin-bottom: 3%;
}

.restaurant .res-pic {
	height: 14vh;
	width: 15vh;
	margin: 0.5% 0% 0% 5%;
}

.restaurant .res-pic img {
	height: 14vh;
	width: 15vh;
}

.restaurant .res-name {
	margin: 0% 0% 0% 2%;
	font-size: 2vw;
	width: 17vw;
}

.restaurant .res-re {
	display: flex;
	align-items: center;
}

.restaurant .res-re  .res-rating {
	border: 0.5px solid;
	width: 4vw;
	color: #fff;
	background-color: green;
	border-radius: 5px;
	font-size: 1.5vw;
	margin: 2% 0% 0% 2%;
	padding: 1%;
}

.restaurant .res-re  .eta {
	margin-left: 10%;
	font-size: 1.5vw;
}

.restaurant .res-address {
	margin: 1% 0% 0% 3%;
	font-size: 1.5vw;
}

.items  .container1 {
	margin-top: -2%;
	background-color: #ffff;
	display: flex;
	justify-content: space-around;
}
 .header {
	margin: 1% 0% 0% 2%;
	text-decoration: underline;
	text-decoration-color: #B7C8E9;
	color:#fca311;
	font-weight: 550;
}

.container1 .item-pic img{
margin: 25% 0% 2% -1%;
border:1px solid;
height:80px;
width:100px;
object-fit:cover;
border-radius:10px;
}
.container1 .name {
	margin: 4% 0% 2% -5%;
	font-size: 1.7vw;
	width: 30vw;
	overflow-x: hidden;
	padding: 0.5%;
}

.container1 .price {
	margin: 4% 0% 2% -8%;
	font-size: 1.7vw;
	width: 6vw;
	overflow-x: hidden;
	padding: 0.5%;
}

.container1 .quantity {
	margin: 4% 0% 5% -8%;
	font-size: 1.7vw;
	width: 8vw;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border: 2px solid #B7C8E9;
	padding: 0.5%;
}

.container1 .quantity .less {
	margin: -7% 0% 0% -4%;
	width: 3vw;
	height: 5vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container1 .quantity .less span {
	margin: -18% 0% 0% 0%;
	font-size: 34px;
	color: red;
	cursor: pointer;
}

.container1 .quantity .less:hover {
	background-color: #B7C8E9;
}

.container1 .quantity .less span:hover {
	font-size: 33px;
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
	margin: -7% -4% 0% 0%;
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
	font-size: 32px;
}

.container1 .delete {
	margin: 2% 0% 2% -8%;
}

.container1 .delete img {
	height: 2vw;
	cursor: pointer;
}

.container1 .delete img:hover {
	margin: 15% 0% 2% 0%;
	height: 1.7vw;
}

.bill {
	margin-top: 3%;
	border-top: 0.5px solid #B7C8E9;
	
}

.bill .header {
	margin: 1% 0% 0% 2%;
	text-decoration: underline;
	text-decoration-color: #B7C8E9;
	color:#fca311;
	font-weight: 550;
}

.bill-deatils .item-total, .delivery, .gst {
	display: flex;
	margin: 2% 0% 0% 2%;
	justify-content: space-between;
	font-size: 1.26vw;
}

.bill-deatils .item-total .item-price, .delivery-price, .gst-price {
	margin-right: 4%;
}

.bill-deatils .total {
	border-top: 1px solid;
	border-bottom: 1px solid;
	display: flex;
	margin: 2% 0% 0% 2%;
	justify-content: space-between;
	font-size: 1.4vw;
	padding-top: 1%;
}

.bill-deatils .total-price {
	margin-right: 4%;
}

.delivery-address {
	margin-top: 5%;
}

.delivery-address label {
	margin: 2%;
	cursor: pointer;
	text-decoration: underline;
	text-decoration-color: #B7C8E9;
	color:#fca311;
	font-weight: 550;
}

.delivery-address input {
	width: 93.5%;
	height: 4vh;
	margin: 2%;
	border: 1px solid gray;
	outline: none;
	padding: 1%;
}

.payment-mode {
	margin: 2% 0% 0% 0%;
}

.payment-mode label {
	margin: 2%;
	cursor: pointer;
	text-decoration: underline;
	text-decoration-color: #B7C8E9;
	color:#fca311;
	font-weight: 550;
}

.payment-mode input {
	width: 40%;
	height: 4vh;
	margin: 2% 0% 3% 10%;
	border: 1px solid gray;
	outline: none;
	padding: 1%;
}

.confirm {
	border-top: 1px solid #B7C8E9;
}

.confirm input {
	background-color: #B7C8E9;
	border: 1px solid #B7C8E9;
	width: 40%;
	height: 7vh;
	margin: 2% 0% 0% 30%;
	font-size: 1.5vw;
}

.confirm input:hover {
	font-size: 1.3vw;
}

.upi-options {
	display: none;
	align-items: center;
	gap: 10%;
	margin-bottom: 3%;
}

.upi-options .googlepay, .phonepay, .paytm {
	display: grid;
	margin-left: 7%;
	cursor: pointer;
}

.upi-options .googlepay img, .phonepay img, .paytm img {
	height: 12vh;
}

.upi-options .googlepay span {
	margin-left: 5%;
}

.upi-options .phonepay span {
	margin-left: 20%;
}

.upi-options .paytm span {
	margin-left: 20%;
}

.debitcard {
	display: none;
	border: 1px solid;
	border-radius: 10px;
	width: 45%;
	height: 30vh;
	margin: 1% 0% 1% 24%;
	background-color: #B7C8E9;
}

.debitcard .cardnumber  input {
	margin: 4% 0% 0% 1%;
	width: 96%;
	height: 5vh;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}

.debitcard .my {
	display: flex;
	justify-content: space-around;
	height: 9vh;
}

.debitcard .month input{
	margin: 5% 0% 0% 5%;
	width: 7vw;
	height: 60%;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}
.debitcard .year input {
margin: 5% 0% 0% 5%;
	width: 7vw;
	height: 60%;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}

.debitcard .cvv input {
	margin: 0% 0% 0% 1%;
	width: 96%;
	height: 5vh;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}
.creditcard {
	display: none;
	border: 1px solid;
	border-radius: 10px;
	width: 45%;
	height: 30vh;
	margin: 1% 0% 1% 24%;
	background-color: #B7C8E9;
}

.creditcard .cardnumber  input {
	margin: 4% 0% 0% 1%;
	width: 96%;
	height: 5vh;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}

.creditcard .my {
	display: flex;
	justify-content: space-around;
	height: 9vh;
}

.creditcard .month input{
	margin: 5% 0% 0% 5%;
	width: 7vw;
	height: 60%;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}
.creditcard .year input {
margin: 5% 0% 0% 5%;
	width: 7vw;
	height: 60%;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}

.creditcard .cvv input {
	margin: 0% 0% 0% 1%;
	width: 96%;
	height: 5vh;
	border: 1px solid gray;
	outline: none;
	border-radius: 5px;
}
a{
text-decoration: none;
color:black;}
.addpopup {
	position: absolute;
	width: 30vw;
	background-color:rgba(0,0,0,0.4);
	margin: 4% 0% 0% 13%;
	display: none;
}

.addpopup .text {
	margin: 5% 0% 0% 3%;
	font-size: 3vw;
}

.addpopup .buttons {
	margin: 7% 0% 7% 0%; display : flex;
	gap: 25%;
	display: flex;
}

.addpopup .buttons .cancel {
	margin: 0% 0% 0% 40%;
	
}

.addpopup .buttons button {
	font-size: 2vw;
}

.addpopup .buttons button:hover {
	background-color: #b7c8e9;
	
}
#address-error,#paymentMode-error{
            width:190px;
            color: red;
            margin-top: 2%;
        }
        .v{
        font-size:25px;
           position: absolute;
           margin:-4.5% 0% 0% 74.5%;
        }
        .en{
            font-size:18px;
           position: absolute;
           margin:-4.2% 0% 0% 69%;
            width:300px;
            
        }
         .epn {
            font-size:18px;
           position: absolute;
           margin:-4.2% 0% 0% 65%;
            width:300px;
            
        }
        .efn{
        font-size:18px;
           position: absolute;
           margin:-4.2% 0% 0% 67%;
            width:300px;
        }
        #paymentMode-error .v{
        font-size:25px;
           position: absolute;
           margin:-5.7% 0% 0% 42%;
        }
        #paymentMode-error .efn{
        font-size:18px;
           position: absolute;
           margin:-5% 0% 0% 42%;
            width:350px;
        }
          #submit-error .submiterror{
        position: absolute;
        font-weight: 550;
        margin:-4.6% 0% 0% 27%;
        color:red;
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
			<div class="log"><a href="indexservlet">LogOut</a></div> <div class="edit"><a href="calledit?isthischeckout=checkout">Edit</a></div>
		</div>

	</div>
	<div class="container">
		<div class="restaurant">
			<%
			Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
			%>
			<div class="res-pic">
				<img src="<%=restaurant.getImagePath()%>" alt="restaurant-img">
			</div>
			<div class="res-details">
				<div class="res-name">
					<b><%=restaurant.getName()%></b>
				</div>
				<div class="res-re">
					<div class="res-rating">
						&#9733;<%=restaurant.getRating()%></div>
					<div class="eta"><%=restaurant.getEta()%></div>
				</div>
				<div class="res-address"><%=restaurant.getAddress()%></div>
			</div>
		</div>
		<div class="header">Items</div>
		<%
		double totalAmount = 0.0;
		Map<Integer, CartItem> cartList = (Map<Integer, CartItem>) session.getAttribute("cartList");
		Set<Integer> keySet = cartList.keySet();
		for (Integer key : keySet) {

			CartItem cart = cartList.get(key);
			double price = cart.getPrice();
			int quantity = cart.getQuantity();
			double totalCostOfItems = price * quantity;
			totalAmount = totalAmount + totalCostOfItems;
		%>
		<div class="items">
		
			<div class="container1">
				<div class="item-pic"><img src="<%=cart.getImagePath() %>" alt="pic"></div>
				<div class="name"><%=cart.getItemName()%></div>
				<div class="price">
					&#8377;<%=totalCostOfItems%></div>
				<div class="quantity">
					<a href="lessquantityincheckout?itemId=<%=cart.getItemId()%>&itemName= <%=cart.getItemName()%>&quantity=<%=cart.getQuantity()%>&price=<%=cart.getPrice()%>&restaurantId=<%=cart.getRestaurantId()%>"><div class="less"><span ><b>-</b></span></div></a>
					<div class="quan"><%=cart.getQuantity()%></div>
					<a href="addincheckout?itemId=<%=cart.getItemId()%>&itemName= <%=cart.getItemName()%>&quantity=<%=cart.getQuantity()%>&price=<%=cart.getPrice()%>&restaurantId=<%=cart.getRestaurantId()%>"><div class="add" id="add"><span><b>+</b></span></div></a>
				</div>
				
			</div>

		</div>
		
		
		
			<%-- <div class="addpopup" id="addpopup">
				<div class="text">Repeat previous Item?</div>
				<div class="buttons">
					<a href="CheckOut.jsp"><div class="cancel">
						<button>Cancel</button>
					</div></a>
					<a href="addincheckout?itemId=<%=cart.getItemId()%>&itemName= <%=cart.getItemName()%>&quantity=<%=cart.getQuantity()%>&price=<%=cart.getPrice()%>&restaurantId=<%=cart.getRestaurantId()%>"><div class="repeat">
						<button>Yes Repeat</button>
					</div></a>
				</div>
			</div> --%>
		<%
		session.setAttribute("totalAmount", totalAmount);
		}
		%>

		<div class="bill">
			<div class="header">Bill Details</div>
			<div class="bill-deatils">
				<div class="item-total">
					<div class="item-name">Item Total</div>
					<div class="item-price">
						&#8377;<%=totalAmount%></div>
				</div>
				<div class="delivery">
					<div class="item-name">Delivery partner fee</div>
					<div class="delivery-price">&#8377;29</div>
				</div>
				<div class="gst">
					<div class="item-name">GST and Restaurant Charges</div>
					<div class="gst-price">&#8377;50.50</div>
				</div>
				<div class="total">
					<div class="total-name">Total</div>
					<div class="total-price">&#8377;<%=totalAmount +29+50.50%></div>
				</div>
			</div>
		</div>

		<div class="delivery-address">
			<form action="paymentservlet" onsubmit="return validateAll()"> 
		<%
		User user1 = (User) session.getAttribute("user");
		
		if(user.getAddress()!=null){
		
		%>
				<label for="address">Delivery Address : </label><br> <input
					type="text" name="address" value="<%=user1.getAddress() %>" id="address" required onkeyup="return validateAddress()">
					<span id="address-error"></span>
			<%
		}else{%>
		
		<label for="address">Delivery Address : </label><br> <input
					type="text" name="address" placeholder="Enter your Address" id="address" required onkeyup="return validateAddress()">
					<span id="address-error"></span>
		<%} %>
				
	
				
		</div>

		<div class="payment-mode">
			<label for="mode">Payment Mode :</label><br> <input list="text"
				placeholder="Choose Payment Mode" id="mode"  name="paymentmode" required  onkeyUp="return isPaymentModeValid()">
			<datalist id="text">
				<option value="cod">
				<option value="upi">
				<option value="debit card">
				<option value="credit card">
				
			</datalist>
			<span id="paymentMode-error"></span>

		</div>
		<div class="upi-options" id="upi-options">
			<div class="googlepay">
				<img
					src="https://w7.pngwing.com/pngs/667/120/png-transparent-google-pay-2020-hd-logo.png"
					alt="googlepay-img"><span>Google pay</span>
			</div>
			<div class="phonepay">
				<img
					src="https://e7.pngegg.com/pngimages/332/615/png-clipart-phonepe-india-unified-payments-interface-india-purple-violet.png"
					alt="phone-img"><span>phone pay</span>
			</div>
			<div class="paytm">
				<img
					src="https://cdn.icon-icons.com/icons2/730/PNG/512/paytm_icon-icons.com_62778.png"
					alt="paytm-img"><span>Paytm</span>
			</div>
		</div>
		<div class="debitcard" id="debitcard">
			<div class="cardnumber">
				<input type="text" name="cardnumber" placeholder="Card Number"
					id="cardinput">
			</div>
			<div class="my">
				<div class="month">
					<input type="text" name="month" placeholder="month" id="monthinput">
				</div>
				<div class="year">
					<input type="text" name="year" placeholder="Year">
				</div>
			</div>
			<div class="cvv">
				<input type="password" name="cvv" placeholder="CVV">
			</div>
		</div>
		<div class="creditcard" id="creditcard">
			<div class="cardnumber">
				<input type="text" name="cardnumber" placeholder="Card Number"
					id="cardinput">
			</div>
			<div class="my">
				<div class="month">
					<input type="text" name="month" placeholder="month" id="monthinput">
				</div>
				<div class="year">
					<input type="text" name="year" placeholder="Year">
				</div>
			</div>
			<div class="cvv">
				<input type="password" name="cvv" placeholder="CVV">
			</div>
		</div>
		<div class="confirm">
			<input type="submit" value="Place the Order" id="submit">
			<span id="submit-error"></span>
		</div>
		<br>

		</form>
	</div>
	</div>

	<script>
		var input = document.getElementById("mode");
		var upioption = document.getElementById("upi-options");
		var debitcard = document.getElementById("debitcard");
		var creditcard = document.getElementById("creditcard");
		input.addEventListener('input', function() {
			var val = input.value;
			if (val == "upi") {
				upioption.style.display = "flex";
			} else {
				upioption.style.display = "none";
			}
			if (val == "debit card") {
				debitcard.style.display = "grid";
			} else {
				debitcard.style.display = "none";
			}
			if (val == "credit card") {
				creditcard.style.display = "grid";
			} else {
				creditcard.style.display = "none";
			}
		});
		
		
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
		
		 var addressError=document.getElementById('address-error')
         function validateAddress(){
                     var address=document.getElementById('address').value;
                     
                     
                      if(address.length==0)
                         {
                    	  addressError.innerHTML="<div class='en'>Enter Address</div>";
                         return false
                         
                         }
                        if(!address.match(/^[A-Za-z0-9\s-,]*$/))
                         {
                        	addressError.innerHTML="<div class='epn'>Enter proper Address</div>";
                             return false;
                         }
                         if(address.length<3)
                         {
                        	 addressError.innerHTML="<div class='efn'>Enter Full Address</div>";
                             return false;
 
                         }
                        
                     
                         addressError.innerHTML='<div class="v">&#9989;</div>';
                     return true;
                     
                 }
		 var paymentModeError=document.getElementById('paymentMode-error')
		    function isPaymentModeValid() {
		        var allowedModes = ['cod', 'upi', 'debit card', 'credit card'];
		        var selectedMode = document.getElementById('mode').value;
		        
		        if (!allowedModes.includes(selectedMode)) {
		        	paymentModeError.innerHTML = "<div class='efn'>Please Select a Listed Payment Mode only</div>";
		            return false;
		        } 
		        	paymentModeError.innerHTML = '<div class="v">&#9989;</div>';
		            return true;
		        
		    }
		
		
		 var submitError=document.getElementById('submit-error'); 
		 function validateAll(){
	            var submit=document.getElementById('submit');  
	            
	            if (!validateAddress() || !isPaymentModeValid()) {
	                submitError.innerHTML = "<div class='submiterror'>Please Provide Correct Address and PaymentMode</div>";
	                return false;
	            }
	            return true;
	        }
	</script>
</body>
</html>

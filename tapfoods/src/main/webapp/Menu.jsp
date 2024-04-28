<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
body{
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
.restaurantdetails {
	height: 300px;
	width: 100%;
	margin-top: 80px;
	border: 1px solid;
	box-shadow: 1px 1px 8px 1px gray;
	border-radius: 20px;
	display: flex;
	justify-content: space-between;
	overflow: hidden;
		background-color: #FFFF;
}

.resdetails {
	margin-left: 20px;
	margin-top: 20px;
}
.ratings{
border: 0.5px solid;
	width: 60px;
	color: #fff;
	background-color: green;
	border-radius: 5px;
	font-size:25px;
	padding:0.5%;
	

}

.respic {
	border: 1px solid;
	background-color: black;
	border-radius: 20px;
	height: 200px;
	width: 300px;
	margin-top: 50px;
	margin-right: 25px;
}
.respic  img{
height:100%;
width:100%;
border-radius: 20px;
object-fit:cover;
}

.offers {
	height: 60px;
	width: auto;
	margin-top: 50px;
	box-shadow: 3px 3px 9px 4px gray;
	border-radius: 20px;
	display: flex;
	align-items: center;
	background-color: #FFFF;
}

.ofr {
	height: 45px;
	width: max-content;
	border-radius: 18px;
	box-shadow: 2px 2px 5px gray;
	margin-left: 15px;
	display: flex;
	align-items: center;
	padding-left: 20px;
	padding-right: 20px;
}
.search{
position:relative;
margin:3% 0% 0% 0%;
width:	%;
display: flex;
flex-direction:row;
justify-content: center;
}
.search form{
display: flex;
margin:0% 0% 2% 11%;
}
.search .search-bar input{
width:70vw;
height:50px;
border:1px solid black;
border-radius: 7px;
outline-color: #B7C8E9;
padding:0% 0% 0% 1%;
}
.search .search-bar input::placeholder{
font-size: 15px;
font-weight: 600;
}
 ::-webkit-search-cancel-button{
 display: none;
 }
.search .search-submit input{
  margin:1% 0% 0% -101%;
  width:120px;
  height:46px;
  font-size: 2vw;
font-weight: 600;
border:none;
cursor:pointer;
background-color: #B7C8E9;
border-radius: 0px 7px  7px 0px;
}
.search .search-submit input:hover{
  background-color:rgba(252, 163, 17, 0.8);
}
 .options{
        display: flex;
        justify-content: space-around;
        margin-top: -0.5%;
        
       }
       .options .all{
         display: flex;
         justify-content: center;
         cursor: pointer;
         font-weight: 700; 
          font-size:1.5vw;
           width:10%;
          
       }
       .options .all:hover{
        background-color: rgba(255,255,255,0.7);
        border-radius: 50px;
         
       }
       .options .top-rated{
         display: flex;
         justify-content: center;
         cursor: pointer;
         font-weight: 700;
          font-size:1.5vw;
           width:10%;
       }
       .options .top-rated:hover{
        background-color: rgba(255,255,255,0.7);
        border-radius: 50px;
       }
       .options .price-low-to-high{
         display: flex;
         justify-content: center;
         cursor: pointer;
         font-weight: 700;
          font-size:1.5vw;
           width:18%;
       }
       .options .price-low-to-high:hover{
         background-color: rgba(255,255,255,0.7);
        border-radius: 50px;
       }
       .options .price-high-to-low{
         display: flex;
         justify-content: center;
         cursor: pointer;
         font-weight: 700;
          font-size:1.5vw;
           width:18%;
       }
       .options .price-high-to-low:hover{
         background-color: rgba(255,255,255,0.7);
        border-radius: 50px;
       }
.menu {
	width: 100%;
	margin-top: 30px;
	background-color: #FFFF;
	border-radius: 2px;
}

hr {
	width: 97%;
}

.item {
	margin-top: -18px;
	height: 140px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	overflow: hidden;
}


.itemdetails {
	width: 70%;
	border-radius: 20px;
	margin-left: 15px;
	word-wrap: break-word;
}

.itemdetails .rating {
	margin-top: 10px;
	margin-left: 10px;
	font-size: 15px;
}
.itemdetails .rvn .rating{
border: 0.5px solid;
	width: 40px;
	color: #fff;
	background-color: green;
	border-radius: 5px;
	font-size: 15px;

}
.itemdetails h2 {
	margin-top: 10px;
	margin-left: 13px;
}

.itemdetails h4 {
	margin-top: -19px;
	margin-left: 13px;
}

.itemdetails p {
	margin-top: -15px;
	margin-left: 10px;
	font-size: 12px;
	max-width: 100%;
	word-wrap: break-word;
	overflow-wrap: break-word;
}

.itempic {
	background-color: black;
	margin-top: 10px;
	height: 120px;
	width: 150px;
	border-radius: 20px;
	margin-right: 15px;
	position: relative;
	
}
.itempic img{
height:100%;
width:100%;
border-radius: 10px;
object-fit:cover;
}

.add {
position:absolute;
margin-left:25px;
margin-bottom:-5px;
bottom:0;
	height: 30px;
	width: 100px;
	background-color: white;
	border-radius: 13px;
	display: flex;
	justify-content: center;
	align-items: center;
	box-shadow: 2px 2px 6px black;
	cursor: pointer;
}

a{
text-decoration: none;
color:black;
}
details{


}
summary{
font-size:30px;

}
.item h1{
margin:1% 0% 0% 35%;
}

.rvn{
display: flex;
}
.rvn .veg_nonveg{

margin:1% 0% 0% 2%;
font-weight: 550;
}
footer {
	color: black;
	width: 102%;
	margin: 5% 0% 0% 1.6%;
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
	color: black;
	list-style: none;
	font-size: 1.7vw;;
}
ul .special:hover{
	color:#fca311;
	}

footer  .devisions {
	font-size: 2vw;
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
	
	<%Restaurant restaurant=(Restaurant)session.getAttribute("restaurant"); 
	session.setAttribute("restaurantId", restaurant.getRestaurantId());%>
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
			<div class="log"><a href="indexservlet">LogOut</a></div> <div class="edit"><a href="calledit?isthismenu=menu">Edit</a></div>
		</div>

	</div>
	<div class="restaurantdetails">
		<div class="resdetails">
		<% 
		session.setAttribute("restaurantId", restaurant.getRestaurantId());
		%>
			<h1>
				<%=restaurant.getName()%><br><div class="ratings">&#9733;<%=restaurant.getRating()%></div>
			</h1>
			<h2>
				Estimated Time Of Arrival :
				<%=restaurant.getEta()%></h2>
			<h3>
				CuisineType :
				<%=restaurant.getCuisineType()%><br> <br> Address
				:
				<%=restaurant.getAddress()%>
			</h3>
		</div>
		<div class="respic">
			<img alt="" src="<%=restaurant.getImagePath()%>">
		</div>
	</div>

	<!--  <div class="offers">
		
		<div class="ofr">
			<h4>
			
			</h4>
		</div> 
	</div> -->

   
		 <div class="search">
			<form action="serchmenuitemsservlet ">
				<div class="search-bar">
					<input type="search" name="search"
						placeholder="What you are looking for ? Search a specific menu item here">
				</div>
				<div class="search-submit">
					<input type="submit" value="&#128269;">
				</div>
			</form>
		</div>

  <div class="options">
          <div class="all"> <a href="onlyveg?restaurantId=<%=restaurant.getRestaurantId() %>&userId=<%=user.getUserId()%>">Only Veg</a></div>
          <div class="all"> <a href="onlynonveg?restaurantId=<%=restaurant.getRestaurantId() %>&userId=<%=user.getUserId()%>">Only NonVeg</a></div>
          <div class="all"> <a href="callmenu?restaurantId=<%=restaurant.getRestaurantId() %>"> All Items</a></div>
            <div class="top-rated"><a href="toprated?restaurantId=<%=restaurant.getRestaurantId() %>&userId=<%=user.getUserId()%>">Top Rated</a></div>
            <div class="price-low-to-high"><a href="pricelowtohigh?restaurantId=<%=restaurant.getRestaurantId() %>&userId=<%=user.getUserId()%>">Price Low To High</a></div>
            <div class="price-high-to-low"><a href="pricehightolow?restaurantId=<%=restaurant.getRestaurantId() %>&userId=<%=user.getUserId()%>">Price High To Low</a></div>
        </div>

		<%
		List<Menu> menuList = (List<Menu>) session.getAttribute("menu");
      if(menuList!=null && !menuList.isEmpty()){
		for (Menu menu : menuList) {
			
		%>
		
		<div class="menu">
			<div class="item">
				<div class="itemdetails">
					
					<div class="rvn">	<div class="rating">&#9733; <%=menu.getRating()%>  </div>
					<%if(menu.getVeg_nonVeg().equals("veg"))
					{%>
					<div class="veg_nonveg">&#128994;<%=menu.getVeg_nonVeg() %></div></div>
					<%
					}else{
					%>
					<div class="veg_nonveg">&#128308;<%=menu.getVeg_nonVeg() %></div></div>
					<%
					}%>
					<h2><%=menu.getName()%></h2>
					<h4>
						₹<%=menu.getPrice()%></h4>
					<p><%=menu.getDescription()%></p>
					
				</div>
				<div class="itempic">
				<img alt="picture" src="<%=menu.getImagePath() %>">
					<a href="callcart?itemId=<%=menu.getMenuId() %>&restaurantid=<%=restaurant.getRestaurantId() %>">
					<div class="add">
						<b> ADD </b>
					</div>
					</a>
				
			</div>
			
		
		</div>
		<hr>
		



		<%
		}
		%>
		<%
		}else{
			%>
			<div class="menu">
			<div class="item">
			 <h1>No Item Found</h1>	
			 </div>
		</div>
		<%	
		}
		%>

      </div>
      
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
a{
text-decoration: none;
color:black;
}
        .container{
            margin: 6% 0% 0% 18%;
            width: 60vw;
            height: 39vw;
            background-color: #FFFF;
            display: grid;
            justify-content: center;
        }
        .container .text1{
            width: 50vw;
            font-size: 3vw;
            margin: 10% 0% 0% 5%;
        }
        .container .text2{
            width: 40vw;
            font-size: 3vw;
            margin: -10% 0% 0% 25%;
        }
        .uname{
        color:#fca311;}
        
        .annimation{
        margin: 0% 0% 5% 5%;
        width: 100%;
        }
        
        .annimation .pic{
        position: absolute;
      margin: -2% 0% 0% 0%;
        }
        .annimation  .text{
        font-size:25px;
        margin:10% 0% 0% 22%;
        text-decoration: underline;
       text-decoration-color: #fca311;
        }
       
        
        .annimation .pic img{
        width:100px;
        height:100px;
        position: relative;
        margin:0% 0% 0% 350%;
        animation-name:ani;
        animation-duration:3s; 
        animation-iteration-count:infinite;  
        }
        
       @keyframes ani{
          0%{margin:0% 0% 0% 100%;}
          100%{margin1:0% 0% 0% 350%;}
        } 
        
        
        
       .homepage{ 
        border: 1px solid #B7C8E9;
	box-shadow: 0.1px 0.1px 3px 0.1px #c9d8f7;
	width: 20vw;
	height:30px;
	padding: 1%;
	font-size: 1.3vw;
	cursor: pointer;
	margin:-7% 0% 0% 60%;
}

.homepage:hover {
	background-color: #fca311;
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
			<div class="log"><a href="indexservlet">LogOut</a></div> <div class="edit"><a href="calledit?isthisconfirm=confirm">Edit</a></div>
		</div>

	</div>

    <div class="container">
        <div class="text1">Chill <span class="uname"><%=user.getName()%></span> your order is on the way</div>
        <br>
        <div class="text2"> .....Thank You.....</div>
    
<div class="annimation">
<div class="pic"><img alt="pic" src="https://cdn.pixabay.com/photo/2023/08/22/14/06/ai-generated-8206499_1280.png"></div>
<div class="text">Your Order is on the Way</div>
</div>
<div class="homepage"><a href="Restaurantservlet">RETURN TO
					RESTAURANTS &nbsp; &#10140;</a></div>
</div>
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
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
	background-color:#ffff;
}

.login h1 {
	font-size: 30px;
    margin-top: -5px;
	text-decoration: underline;
	text-decoration-color: #fca311;
}

.inputbox1, .inputbox2, .inputbox3, .inputbox4 {
	width: 250px;
	border-bottom: 2px solid;
	padding-top: 20px;
	display: flex;
	align-items: center;
	
}

.inputbox1 input, .inputbox2 input, .inputbox3 input, .inputbox4 input {
	width: 97%;
	height: 27px;
	border: none;
	outline: none;
	background: transparent;
	font-size: 15px;
}

.inputbox1 label, .inputbox2 label, .inputbox3 label, .inputbox4 label {
	color: #fca311;
	position: absolute;
	font-weight: 900;
	cursor:text;
}

.inputbox1 input:focus ~label, .inputbox1 input:valid ~label {
	top: 213px;
	font-size: 13px;
	transition: font-size 0.2s ease;
}
.inputbox2 input:focus ~label, .inputbox2 input:valid ~label {
	top: 263px;
	font-size: 13px;
	transition: font-size 0.2s ease;
}
.inputbox3 input:focus ~label, .inputbox3 input:valid ~label {
	top: 317px;
	font-size: 13px;
	transition: font-size 0.2s ease;
}
.inputbox4 input:focus ~label, .inputbox4 input:valid ~label {
	top: 367px;
	font-size: 13px;
	transition: font-size 0.2s ease;
}

.inputbox3 img {
padding-right: 2px;
	height: 25px !important;
	cursor:pointer;
}

.inputbox4 img {
padding-right: 2px;
	height: 25px !important;
	cursor:pointer;
}


.submit {
	padding-top: 24px;
	padding-left: 190px;
    margin-top: 20px;
}

.submit input {
	font-size: 15px;
	padding: 4px;
	background-color: #fca311;
	border-radius: 10px 2px;
}

.submit input:hover {
	transform: scale(0.95);
	background-color: white;
	
}

#phoneNo-error,#userName-error,#password-error{
            width:190px;
            color: red;
            margin-top: 2%;
        }
        .v{

           margin-left: 82%;
        }
         .en{
            
            width:100px;
            margin-left: 37%;
        }
         .epn {
            position: absolute;

            width:190px;
            margin-left: 0%;
        }
          #userName-error .en{
            
            width:150px;
            margin-left: 31%;
        }
       #userName-error .epn {
            position: absolute;
            font-size:13px ;
            width:250px;
            margin:-2.5% 0% 0% -5.5%;
        }
        #userName-error .efn{
            
            width:250px;
            margin-left: 10%;
        }
        #phoneNo-error .en{
            width:100px;
            margin-left: 18%;
        }
        #phoneNo-error .epn{
            position: absolute;

            width:230px;
            margin: -0.9% 0% 0% -4%;
        }
         #password-error{
        position: absolute;
        width:190px;
            color: red;
            margin: -3.5% 0% 0% 6.5%;
       }
       #password-error .en{
        position: absolute;
        width:190px;
            color: red;
            margin: -3.9% 0% 0% 35%;
       }
       #password-error .v{
        margin-left: 75%;
       }

       #submit-error .submiterror{
        position: absolute;
        font-weight: 550;
        margin:-1.8% 0% 0% -16%;
        color:red;
       }

.em{
position:absolute;
color:red;
font-size:14px;
margin:-5% 0% 0% 0%;
}

</style>
</head>
<body>

	<div class="box">
		<div class="login">
			<h1>Reset Password</h1>

			<form action="reset" method="post" onsubmit=" return validateAll()">
				<div>
					<div class="inputbox1">
						<input type="text" id="userName" name="username" required onkeyup="validateUserName()">
						<label for="userName">UserName</label>
						<span id="userName-error"></span>
                       <br>
					</div>
					<div class="inputbox2">
						<input type="tel" id="phoneNo" name="phoneno" required onkeyup="validatePhoneNo()">
						<label for="phoneNo">PhoneNo</label>
						<span id="phoneNo-error"></span>
                       <br>
					</div>
					<div class="inputbox3">
						<input type="password" id="password" name="password" required onkeyup="validatePassword()">
						<label for="password">New Password</label>
						<span id="password-error"></span><img
                        src="http://localhost:8080/tapfoods/Images/eye-close.png" alt="eye-close icon"
                        class="closed-eye" id="icon1" onclick="myfunction1()"> 
                        <br>
					</div>
					<div class="inputbox4">
						<input type="password" id="cpassword" name="cpassword" required>
						<label for="cpassword">Confirm Password</label> <img
							src="http://localhost:8080/tapfoods/Images/eye-close.png" alt="eye-close icon"
							class="closed-eye" id="icon2" onclick="myfunction2()">
					</div>
				</div>


				<div class="submit">
					<input type="submit" id="submit">
					<span id="submit-error"></span>
				</div>
			</form>
				<div class="em">
				<%if(session.getAttribute("errormessage")!=null) 
				{%>
				${sessionScope.errormessage }
				<%} %>
				</div>
				
		</div>
	</div>






<!-- javascript -->


	<script>
		let eyeicon1 = document.getElementById("icon1")
		let eyeicon2 = document.getElementById("icon2")
		let password = document.getElementById("password")
		let cpassword = document.getElementById("cpassword")

		function myfunction1() {
			if (password.type == "password") {
				password.type = "text";
				eyeicon1.src = "http://localhost:8080/tapfoods/Images/eye%20-open.png";
			} else {
				password.type = "password";
				eyeicon1.src = "http://localhost:8080/tapfoods/Images/eye-close.png"
			}
		}
		function myfunction2() {
			if (cpassword.type == "password") {
				cpassword.type = "text";
				eyeicon2.src = "http://localhost:8080/tapfoods/Images/eye%20-open.png";
			} else {
				cpassword.type = "password";
				eyeicon2.src = "http://localhost:8080/tapfoods/Images/eye-close.png"
			}
		}
		
		
		var userNameError=document.getElementById('userName-error')
        function validateUserName(){
                    var userName=document.getElementById('userName').value;
                    
                    
                     if(userName.length==0)
                        {
                            userNameError.innerHTML="<div class='en'>Enter UserName</div>";
                        return false
                        
                        }
                    
                       if(!userName.match(/^[a-zA-z][a-zA-Z0-9_]*$/))
                        {
                            userNameError.innerHTML="<div class='epn'>Starts with Alphabet and Spaces and Special Characters are not allowed except ( _ ) </div";
                            return false;
                        }
                        if(userName.length<3)
                        {
                            userNameError.innerHTML="<div class='efn'>Enter more than 2 characters</div>";
                        return false
                        
                        }
                       
                    
                        userNameError.innerHTML='<div class="v">&#9989;</div>';
                    return true;
                    
                }  
		var phoneNoError=document.getElementById('phoneNo-error')
        function validatePhoneNo(){
                    var phoneNo=document.getElementById('phoneNo').value;
                    
                    
                     if(phoneNo.length==0)
                        {
                            phoneNoError.innerHTML="<div class='en'>Enter PhoneNo</div>";
                        return false
                        
                        }
                    
                       if(!phoneNo.match(/^[6-9][0-9]{9}$/))
                        {
                            phoneNoError.innerHTML="<div class='epn'>Enter 10 Digit Proper PhoneNo</div";
                            return false;
                        }
                       
                       
                    
                        phoneNoError.innerHTML='<div class="v">&#9989;</div>';
                    return true;
                    
                } 
		 var passwordError=document.getElementById('password-error');
         function validatePassword(){
                     var password=document.getElementById('password').value;
                     
                     
                         if(password.length==0)
                         {
                             passwordError.innerHTML="<div class='en'>Enter Password</div>";
                         return false
                         
                         }
                         if(password.length<8)
                         {
                             passwordError.innerHTML="<div class='efn'>Enter more than 7 characters</div>";
                         return false
                         
                         }
                        
                     
                         passwordError.innerHTML='<div class="v">&#9989;</div>';
                     return true;
                     
                 } 
         
         var submitError=document.getElementById('submit-error');    
         function validateAll(){
             var submit=document.getElementById('submit');  
             if( !validatePhoneNo()|| !validateUserName()||!validatePassword() )
             {
                 submitError.innerHTML="<div class='submiterror'>Please Provide Correct Details</div>";
                 submit.style.setProperty("transform", "scale(1)", "important");
                 submit.style.setProperty("background-color", "#fca311", "important");
                 return false;
             }
             return true;
         }
	</script>

</body>
</html>
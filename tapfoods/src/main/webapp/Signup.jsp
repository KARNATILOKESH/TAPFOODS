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
        background-color:  #B7C8E9;
            display: flex;
            justify-content: center;
            margin-top: 75px;
            
        }
        
        .box {
            height: 500px;
            width: 400px;
            display: grid;
            justify-content: center;
            align-items: center;
            box-shadow: 2px 2px 5px 5px gray;
            border-radius: 20px;
            background-color:  #ffff;
        }
        
        .form {
            margin-top: -50px;
        }
        
        .signup h1 {
            font-size: 40px;
            text-decoration: underline;
            text-decoration-color: #fca311;
        }
        
        .inputbox1, .inputbox2, .inputbox3, .inputbox4, .inputbox5 {
            width: 256px;
            border-bottom: 2px solid;
            padding-top: 20px;
            display: flex;
            cursor: text;
        }
        #name{
         text-transform: capitalize;
        }
        
        .inputbox1 input, .inputbox2 input, .inputbox3 input, .inputbox4 input,
            .inputbox5 input {
            width: 90%;
            height: 27px;
            border: none;
            outline: none;
            background: transparent;
            font-size: 15px;
            cursor: text;
        }
        
        .inputbox1 label, .inputbox2 label, .inputbox3 label, .inputbox4 label,
            .inputbox5 label {
            position: absolute;
            padding-top: 10px;
            color: #fca311;
            font-weight: 900;
            cursor: text;
            transition: font-size 0.5s ease;
        }
        
        .inputbox1 input:focus ~label, .inputbox1 input:valid ~label {
            top: 180px;
            font-size: 13px;
            transition: font-size 0.2s ease;
        }
        
        
        .inputbox2 input:focus ~label, .inputbox2 input:valid ~label {
            top: 230px;
            font-size: 13px;
            transition: font-size 0.2s ease;
        }
        
        .inputbox3 input:focus ~label, .inputbox3 input:valid ~label {
            top: 280px;
            font-size: 13px;
            transition: font-size 0.2s ease;
        }
        
        .inputbox4 input:focus ~label, .inputbox4 input:valid ~label {
            top: 330px;
            font-size: 13px;
            transition: font-size 0.2s ease;
        }
        
        .inputbox5 input:focus ~label, .inputbox5 input:valid ~label {
            top: 380px;
            font-size: 13px;
            transition: font-size 0.2s ease;
        }
        
        
        .inputbox5 img {
            padding-right: 2px;
            height: 25px !important;
            cursor: pointer;
        }
        
        .submit {
            padding-top: 24px;
            padding-left: 197px;
        }
        
        .submit input {
            font-size: 15px;
            padding: 4px;
            background-color: #fca311;
            border-radius: 10px 2px;
        }
        
        .submit input:hover {
            
            background-color: white;
            transform: scale(0.95);
            
        }
        
        .login a {
            text-decoration: none;
            color: #fca311;
            padding-left: 10px;
            font-size: 17.5px;
        }
        
        .login a:hover {
            color:black;
        }
        
        #name-error,#email-error,#phoneNo-error,#username-error{
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
        #name-error  .efn{
            margin-left: 12%;
        }
        #phoneNo-error .en{
            width:100px;
            margin-left: 18%;
        }
        #phoneNo-error .epn{
            position: absolute;

            width:230px;
            margin-left: -3%;
        }
        #username-error .en{
            
            width:150px;
            margin-left: 31%;
        }
       #username-error .epn {
            position: absolute;
            font-size:13px ;
            width:250px;
            margin:-1.9% 0% 0% -5.5%;
        }
        #username-error .efn{
            
            width:250px;
            margin-left: 10%;
        }
       #password-error{
        position: absolute;
        width:190px;
            color: red;
            margin: -1.5% 0% 0% 5%;
       }
       #password-error .en{
        position: absolute;
        width:190px;
            color: red;
            margin: -1.5% 0% 0% 5%;
       }
       #password-error .v{
        margin-left: 90%;
       }

       #submit-error .submiterror{
        position: absolute;
        font-weight: 550;
        margin:-1.8% 0% 0% -1.3%;
        color:red;
       }
        .em{
        position:absolute;
        color:red;
        font-size:14px;
        margin:27% 0% 0% -1%;
        }
        .errormessage{
        position:absolute;
        color:red;
        font-size:14px;
        margin:1% 0% 0% 1%;
        }
        .over{
        font-size: 14px;
        color:black;
        }
        </style>
        </head>
        <body>
        <body>
            <div class="box">
                <div class="signup">
                    <h1>Sign Up</h1>
                </div>
                <div class="form">
                    <form action="sign-up" method="post" onsubmit=" return validateAll()">
                        <div class="inputbox1">
                            <input type="text" id="name" name="name"  onkeyup="return validateName()" required> <label
                                for="name">Name</label>
                                <span id="name-error"></span>
                                 <br>
                        </div>
                        <div class="inputbox2">
                            <input type="text" id="email" name="email"  title="Format : alex@gmail.com" onkeyup="return validateEmail()" required> <label
                                for="email">Email</label>
                                <span id="email-error"></span> <br>
                        </div>
                        <div class="inputbox3">
                            <input type="tel" id="phoneNo" name="phoneNo"    onkeyup="return validatePhoneNo()" required><label
                                for="phoneNo">PhoneNo</label>
                                <span id="phoneNo-error"></span> <br>
                        </div>
                        <div class="inputbox4">
                            <input type="text" id="userName" name="userName"  onkeyup="return validateUserName()" required >
                            <label for="userName">UserName</label>
                            <span id="username-error"></span> <br>
                        </div>
                    
                        <div class="inputbox5">
                            <input type="password" id="password" name="password" required   onkeyup="return validatePassword()">
                            <label for="password">Password</label>
                             <img
                                src="http://localhost:8080/tapfoods/Images/eye-close.png" alt="eye-close icon" class="closed-eye"
                                id="icon" onclick="myfunction()"> 
                                <br>
                                <span id="password-error"></span>

                        </div>
        
                        <div class="submit">
                            <input type="submit" id="submit" >
                        </div>
                        <span id="submit-error"></span>
                        <div class="login">
                            <h4>
                                Already have an account?<a href="Login.jsp">Login</a>
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
                
                
                var nameError=document.getElementById('name-error')
                function validateName(){
                            var name=document.getElementById('name').value;
                            
                            
                             if(name.length==0)
                                {
                                nameError.innerHTML="<div class='en'>Enter Name</div>";
                                return false
                                
                                }
                               if(!name.match(/^[A-Za-z\s]*$/))
                                {
                                    nameError.innerHTML="<div class='epn'>Enter proper Name</div";
                                    return false;
                                }
                                if(name.length<3)
                                {
                                    nameError.innerHTML="<div class='efn'>Enter Full Name</div>";
                                    return false;
        
                                }
                               
                            
                            nameError.innerHTML='<div class="v">&#9989;</div>';
                            return true;
                            
                        }  
                  
                var emailError=document.getElementById('email-error')
                function validateEmail(){
                            var email=document.getElementById('email').value;
                            
                            
                             if(email.length==0)
                                {
                                    emailError.innerHTML="<div class='en'>Enter Email</div>";
                                return false
                                
                                }
                               if(!email.match(/^[^\s@]+@[^\s@]+\.+[a-z]{3}$/))
                                {
                                    emailError.innerHTML="<div class='epn'>Enter proper Email</div";
                                    return false;
                                }
                               
                            
                                emailError.innerHTML='<div class="v">&#9989;</div>';
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
                  
                var userNameError=document.getElementById('username-error')
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
            if(!validateName() || !validateEmail()|| !validatePhoneNo()|| !validateUserName()||!validatePassword() )
            {
                submitError.innerHTML="<div class='submiterror'>Please Provide Correct Details</div>";
               
                return false;
            }
            return true;
        }
                
            </script>
        
        
        </body>
        </html>
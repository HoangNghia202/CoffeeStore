<%-- 
    Document   : loginAndSignin
    Created on : Jul 2, 2022, 4:36:14 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login & register Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/login-signin.css">
    </head>
    <body>
        <br>
        <div class="cont">
            <form action="login" method="post">
                <div class="form sign-in">
                    <h2 style="color: #9F7E52; font-family: cursive">Welcome To Coffee BLEND</h2>
                    <label>
                        <span>Email</span>
                        <input type="email" name="email-log" value="${NEWEMAIL}"  />
                    </label>
                    <label>
                        <span>Password</span>
                        <input type="password" name="password-log" value="${NEWPASS}" />
                    </label>
                    <p class="forgot-pass">${ERROR_LOGIN}</p>
                    <button type="submit" class="submit">
                        Sign-in
                    </button> 
                    <a href="sign-in-ad.jsp" style="text-align: center; margin: 100px 240px; color: red ">Log in as Admin</a>
                  
                </div>
            </form>

            <div class="sub-cont">
                <div class="img">
                    <div class="img__text m--up">

                        <h3>Don't have an account? Please Sign up!</h3>
                    </div>
                    <div class="img__text m--in">

                        <h3>If you already has an account, just sign in.</h3>
                    </div>
                    <div class="img__btn">
                        <span class="m--up">Sign Up</span>
                        <span class="m--in">Sign In</span> 
                   
                       
                    </div>
              

                    
                </div>

                <form action="registerServlet" method="post">
                    <div class="form sign-up row" >
                        <h2>Create your Account</h2>
                         <h4 style="color: red; text-align: center">${ERRMESSAGE}</h4>
                        <label class="col-md-6">
                            <span>First Name</span>
                            <input type="text" name="fname-sign" value="${USERSIGNUP.firstName}"/>
                        </label>
                        <label class="col-md-6">
                            <span>Last Name</span>
                            <input type="text" name="lname-sign" value="${USERSIGNUP.lastName}" />
                        </label>
                        <label class="col-md-12">
                            <span>Street address</span>
                            <input type="text" name="address-sign" value="${USERSIGNUP.streetAddress}" />
                        </label>
                        <label class="col-md-6">
                            <span>Town</span>
                            <input type="text" name="town-sign" value="${USERSIGNUP.town}"/>
                        </label>
                        <label class="col-md-6">
                            <span>City</span>
                            <input type="text" name="city-sign" value="${USERSIGNUP.city}" />
                        </label>
                        <label class="col-md-6">
                            <span>Phone number</span>
                            <input type="tel" name="phone-sign" value="${USERSIGNUP.phone}" />
                        </label>
                        <label class="col-md-6">
                            <span>Email</span>
                            <input type="email"  name="email-sign" value="${USERSIGNUP.email}"/>
                          
                        </label>
                        <label class="col-md-6">
                            <span>User name</span>
                            <input type="text" name="username-sign" value="${USERSIGNUP.userName}" />
                            
                        </label>
                        <label class="col-md-6">
                            <span>Password</span>
                            <input type="password" name="password-sign" value="${USERSIGNUP.password}" />
                        </label>

                        <br>
                        <br>
                        <br>

                        <hr>
                        <button type="submit" class="submit submit-sign col-md-12">Sign Up</button>

                    </div>

                </form>

            </div>
        </div>

        <script>
            document.querySelector('.img__btn').addEventListener('click', function () {
                document.querySelector('.cont').classList.toggle('s--signup');
            });
        </script>
    </body>
</html>

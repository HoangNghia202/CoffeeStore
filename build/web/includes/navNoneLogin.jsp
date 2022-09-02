<%-- 
    Document   : nav
    Created on : Jun 24, 2022, 11:05:46 AM
    Author     : ASUS
--%>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Coffee<small>Blend</small>  </a> <h5>Wellcome ${sessionScope.INUSER.getUserName()}</h5>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="indexNoneLogin.jsp" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="menu.jsp" class="nav-link">Menu</a></li>
                <li class="nav-item"><a href="services.jsp" class="nav-link">Services</a></li>

                <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="room.html" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="/login">Shop</a>
                        <a class="dropdown-item" href="/login">Cart</a>
                        <a class="dropdown-item" href="/login">Checkout</a>
                    </div>
                </li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>


                <li class="nav-item cart"><a href="cart.jsp" class="nav-link"><span class="icon icon-shopping_cart"></span><span class="bag d-flex justify-content-center align-items-center"><small>0</small></span></a></li>
                  <li class="nav-item"><a href="logoutServet" class="nav-link">Log in</a></li>
            </ul>
        </div>
    </div>
</nav><%-- 
    Document   : navNonLogin
    Created on : Jul 5, 2022, 9:44:39 AM
    Author     : ASUS
--%>


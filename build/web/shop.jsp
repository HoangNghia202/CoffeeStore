<%-- 
    Document   : shop
    Created on : Jun 24, 2022, 10:52:00 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Coffee - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Great+Vibes" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <!-- END nav -->

        <section class="home-slider owl-carousel">

            <div class="slider-item" style="background-image: url(images/bg_3.jpg);" data-stellar-background-ratio="0.5">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text justify-content-center align-items-center">

                        <div class="col-md-7 col-sm-12 text-center ftco-animate">
                            <h1 class="mb-3 mt-5 bread">Order Online</h1>
                            <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home</a></span> <span>Shop</span></p>
                        </div>

                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-menu mb-5 pb-5">
            <div class="container">
                <div class="row d-md-flex">
                    <div class="col-lg-12 ftco-animate p-md-5">
                        <div class="row">
                            <div class="col-md-12 nav-link-wrap mb-5">
                                <div class="nav ftco-animate nav-pills justify-content-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                    <a class="nav-link active" id="v-pills-0-tab" data-toggle="pill" href="#v-pills-0" role="tab" aria-controls="v-pills-0" aria-selected="true">Coffee</a>



                                    <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">Drinks</a>

                                    <a class="nav-link" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Desserts</a>
                                </div>
                            </div>
                            <div class="col-md-12 d-flex align-items-center">

                                <div class="tab-content ftco-animate" id="v-pills-tabContent">

                                    <div class="tab-pane fade show active" id="v-pills-0" role="tabpanel" aria-labelledby="v-pills-0-tab">
                                        <div class="row">
                                            <c:forEach var="coffee" items="${sessionScope.LISTCOFFEES}">
                                                <div class="col-md-3">
                                                    <form action="shop" method="post">
                                                        <div class="menu-entry">
                                                            <input type="hidden" name="id-item" value="${coffee.getId()}">
                                                            <a href="#" class="img" style="background-image: url(${coffee.getImgLink()});"></a>
                                                            <div class="text text-center pt-4">
                                                                <h3><a href="product-single.html">${coffee.getName()}</a></h3>
                                                                <p style="height: 80px">${coffee.getDescribe()}</p>
                                                                <p class="price"><span>$${coffee.getPrice()}</span></p>
                                                                <p><input type="submit" class="btn btn-primary btn-outline-primary" value="Add to cart" onclick="alert('${coffee.getName()} has added to cart')"></p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>



                                    <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-2-tab">
                                        <div class="row">
                                            <c:forEach var="drink" items="${sessionScope.LISTDRINKS}">
                                                <div class="col-md-4 text-center">
                                                    <form action="shop" method="post">
                                                        <div class="menu-wrap">
                                                            <input type="hidden" name="id-item" value="${drink.getId()}">
                                                            <a href="#" class="menu-img img mb-4" style="background-image: url(${drink.imgLink});"></a>
                                                            <div class="text">
                                                                <h3><a href="product-single.html">${drink.name}</a></h3>
                                                                <p>${drink.describe}</p>
                                                                <p class="price"><span>$${drink.price}</span></p>
                                                                <p><input type="submit" class="btn btn-primary btn-outline-primary" value="Add to cart" onclick="alert('${drink.getName()} has added to cart')"></p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </c:forEach>


                                        </div>
                                    </div>

                                    <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-3-tab">
                                        <div class="row">
                                             <c:forEach var="dess" items="${sessionScope.LISTDESSERTS}">
                                                <div class="col-md-4 text-center">
                                                    <form action="shop" method="post">
                                                        <div class="menu-wrap">
                                                            <input type="hidden" name="id-item" value="${dess.getId()}">
                                                            <a href="#" class="menu-img img mb-4" style="background-image: url(${dess.imgLink});"></a>
                                                            <div class="text">
                                                                <h3><a href="product-single.html">${dess.name}</a></h3>
                                                                <p>${dess.describe}</p>
                                                                <p class="price"><span>$${dess.price}</span></p>
                                                                <p><input type="submit" class="btn btn-primary btn-outline-primary" value="Add to cart" onclick="alert('${dess.getName()} has added to cart')"></p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </c:forEach>

                                          
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer class="ftco-footer ftco-section img">
            <div class="overlay"></div>
            <div class="container">
                <div class="row mb-5">
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">About Us</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Recent Blog</h2>
                            <div class="block-21 mb-4 d-flex">
                                <a class="blog-img mr-4" style="background-image: url(images/image_1.jpg);"></a>
                                <div class="text">
                                    <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about</a></h3>
                                    <div class="meta">
                                        <div><a href="#"><span class="icon-calendar"></span> Sept 15, 2018</a></div>
                                        <div><a href="#"><span class="icon-person"></span> Admin</a></div>
                                        <div><a href="#"><span class="icon-chat"></span> 19</a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="block-21 mb-4 d-flex">
                                <a class="blog-img mr-4" style="background-image: url(images/image_2.jpg);"></a>
                                <div class="text">
                                    <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about</a></h3>
                                    <div class="meta">
                                        <div><a href="#"><span class="icon-calendar"></span> Sept 15, 2018</a></div>
                                        <div><a href="#"><span class="icon-person"></span> Admin</a></div>
                                        <div><a href="#"><span class="icon-chat"></span> 19</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4 ml-md-4">
                            <h2 class="ftco-heading-2">Services</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Cooked</a></li>
                                <li><a href="#" class="py-2 d-block">Deliver</a></li>
                                <li><a href="#" class="py-2 d-block">Quality Foods</a></li>
                                <li><a href="#" class="py-2 d-block">Mixed</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Have a Questions?</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                                    <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

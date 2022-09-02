<%-- 
    Document   : nav-left
    Created on : Jul 18, 2022, 3:23:30 PM
    Author     : ASUS
--%>

<div class="collapse navbar-collapse  w-auto  max-height-vh-100" id="sidenav-collapse-main">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link text-white active bg-gradient-primary" href="<%=request.getContextPath()%>/indexAd.jsp">
                <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                    <i class="material-icons opacity-10">dashboard</i>
                </div>
                <span class="nav-link-text ms-1">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-white " href="<%=request.getContextPath()%>/edit-menu.jsp">
                <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                    <i class="material-icons opacity-10">table_view</i>
                </div>
                <span class="nav-link-text ms-1">Edit Menu</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-white " href="./tables.html">
                <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                    <i class="material-icons opacity-10">receipt_long</i>
                </div>
                <span class="nav-link-text ms-1">Billing</span>
            </a>
        </li>


        <li class="nav-item mt-3">
            <h6 class="ps-4 ms-2 text-uppercase text-xs text-white font-weight-bolder opacity-8">Account pages</h6>
        </li>
       
        <li class="nav-item">
            <a class="nav-link text-white " href="<%=request.getContextPath()%>/sign-up-ad.jsp">
                <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                    <i class="material-icons opacity-10">assignment</i>
                </div>
                <span class="nav-link-text ms-1">Sign Up</span>
            </a>

        </li>
        <li class="nav-item"> <a class="nav-link text-white " href="<%=request.getContextPath()%>/Login_Logout_Amin_Servlet">
                <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                    <i class="material-icons opacity-10">assignment</i>
                </div>
                <span class="nav-link-text ms-1">Log out</span>
            </a></li>
    </ul>
</div>
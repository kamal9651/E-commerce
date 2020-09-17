
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ecom.helper.Message"%>
<%@page import="com.ecom.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%
    User user = (User) session.getAttribute("current");

    if (user == null) {
        response.sendRedirect("login_page.jsp");
    }


%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <link href="css/my_custom_style.css" rel="stylesheet" type="text/css"/>




        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <!--start admin navbar-->   

        <nav class="navbar navbar-expand-lg navbar-dark bg-custom">
            <a class="navbar-brand" href="#">TechSoft INDIA</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Options
                        </a>
                        <div class="dropdown-menu" a>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#add-catergory-modal">Add Category</a>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#add-product-modal">Add Product</a>
                        </div>
                    </li>





                </ul>

                <ul class="navbar-nav right">



                    <li class="nav-item">
                        <a class="nav-link " href="#!" data-toggle="modal" data-target="#profile-modal"><%= user.getuName()%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="LogoutServlet">Logout</a>
                    </li>

                </ul>

            </div>
        </nav>


        <!--end admin navbar-->

        <%

            Message msg = (Message) session.getAttribute("my_msg");
            if (msg != null) {
                String temp = "danger";
                if (msg.getMessageType().equals("success")) {
                    temp = "success";
                }


        %>


        <div class="alert alert-<%= temp%>" role="alert">
            <%= msg.getMessageContent()%>
        </div>

        <%

                session.removeAttribute("my_msg");

            }%>








        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <h3 class="mt-3 display-4">List of users:</h3>

                    <%

                        Connection con = ConnectionProvider.createConnection();
                        String query = "select * from user";

                        Statement stmt = con.createStatement();

                        ResultSet set = stmt.executeQuery(query);

                        while (set.next()) {
                            String name = set.getString(2);
                            String type = set.getString(7);
                            int userId = set.getInt(1);

                    %>

                    <ul class="list-group mt-1">
                        <li class=" list-group-item list-group-item-success  justify-content-between d-flex align-items-center">
                            <%= name%>
                            <span class="badge badge-primary badge-pill"><%= type%></span>
                            <a href="ChangeUserTypeServlet?user_id=<%= userId%>&&user_type=<%= type %>"> <span class="badge badge-success badge-pill">change</span></a>

                        </li>
                    </ul>

                    <%
                        }


                    %>



                </div>

                <div class="col-sm-6">
                    hello
                </div>

            </div>
        </div>


















        <%@include  file="admin-modals.jsp" %>
















    </body>
</html>

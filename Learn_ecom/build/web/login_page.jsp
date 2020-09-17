<%-- 
    Document   : login_page
    Created on : Mar 30, 2019, 11:12:20 AM
    Author     : pc
--%>

<%@page import="com.ecom.helper.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/my_custom_style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <!--start navbar-->
        <%@include file="navbar.jsp" %>

        <!--end navbar-->

        <div class="container">
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
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




                    <form action="LoginServlet" method="post">

                        <div class="card z-depth-5" >
                            <div class="card-body">
                                <h5 class="card-title display-4">Login here</h5>
                                <br>   
                                <div class="form-group">
                                    <input type="email" name="user_email" placeholder="Enter your email here" class="form-control" />

                                </div>
                                <div class="form-group">
                                    <input type="password" name="user_pass" placeholder="Enter your password here" class="form-control" />

                                </div>
                            </div>

                            <div class="card-footer">
                                <button type="submit" class="btn btn-success">Login</button>
                            </div>


                        </div>

                    </form>

                </div>


            </div>

        </div>

    </body>
</html>

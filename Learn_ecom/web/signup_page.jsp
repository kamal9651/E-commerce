<%-- 
    Document   : signup_page
    Created on : Mar 28, 2019, 11:55:34 AM
    Author     : pc
--%>

<%@page import="com.ecom.helper.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/my_custom_style.css" rel="stylesheet" type="text/css"/>
        <style>

            .d{
                height: 400px;
                border:.5px solid red;
            }
        </style>


    </head>
    <body>
        <!--navbar start-->
        <%@include file="navbar.jsp" %>


        <div class="row">
            <div class="col-md-4 ">

            </div>

            <div class="col-md-4 ">


                <%

                    Message msg = (Message) session.getAttribute("my_msg");
                    if (msg != null) {
                        String temp = "danger";
                        if(msg.getMessageType().equals("success"))
                              temp="success";


                %>


                <div class="alert alert-<%= temp%>" role="alert">
                    <%= msg.getMessageContent()%>
                </div>

                <%

                        session.removeAttribute("my_msg");

                    }%>




                <form action="RegisterServlet" method="post">

                    <div class="card my-form-signup ">
                        <div class="card-header  bg-custom">
                            <h3 class="display-4 text-white ">Signup here !</h3>

                        </div>

                        <div class="card-body">
                            <!--creating form-->

                            <div class="form-group">

                                <input  id="user_name" class="form-control" type="text" name="user_name" placeholder="Enter your name here" />

                            </div>

                            <div class="form-group ">

                                <input id="user_pass" class="form-control" type="password" name="user_pass" placeholder="Enter your password here" />

                            </div>

                            <div class="form-group">

                                <input id="user_email" class="form-control" type="email" name="user_email" placeholder="Enter your email here" />

                            </div>

                            <div class="form-group">
                                <textarea placeholder="Enter some about you" name="user_about" class="form-control"></textarea>

                            </div>


                        </div>

                        <div class="card-footer ">
                            <button type="submit"  class="btn btn-outline-success">Submit</button>
                            <button type="reset"  class="btn btn-outline-warning">Clear</button>

                        </div>



                    </div>

                </form>



            </div>

            <div class="col-md-4 ">

            </div>
        </div>




        <!--navbar ends-->





    </body>
</html>

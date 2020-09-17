<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.ecom.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/my_custom_style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>ECom</title>
    </head>
    <body>

        <!--navbar start-->
        <%@include file="navbar.jsp" %>



        <!--navbar end-->
        <div class="container">
            <div class="row">

                <%
                    String q = "select * from products order by pId desc";

                    Connection con = ConnectionProvider.createConnection();

                    Statement stmt = con.createStatement();

                    ResultSet set = stmt.executeQuery(q);
                    while (set.next()) {
                        String name = set.getString(2);
                        String desc = set.getString(3);
                        double price = set.getDouble(4);
                %>

                <div class="card mt-3 col-sm-3" >
                    <div class="card-header">
                        <h3><%= name%></h3>  
                    </div>
                    <div class="card-body">
                        <p><%= desc%></p>

                        <span class="badge badge-primary badge-pill"> <i class="fa fa-inr" aria-hidden="true"></i> <% out.print(price); %> </span>

                    </div>

                    <div class="card-footer">
                        <button class="btn btn-outline-success">Add to card</button>
                    </div>
                </div>


                <%
                    }

                %>


            </div>

        </div>






    </body>
</html>

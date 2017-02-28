<%-- 
    Document   : customer
    Created on : 28-02-2017, 14:10:35
    Author     : Moonniuniu
--%>

<%@page import="domain.entites.Customer"%>
<%@page import="data.Mapper.PartMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <title>Cup Cakes Webshop</title>
    </head>
    <body>
        <div class="wrap" >
            <div class="mid">
                <h1>Hey 
                <%
                    String email = session.getAttribute("email").toString();
                    PartMapper pm = new PartMapper();
                    String name = pm.customerInfo(email).getName();
                    out.println(name);
                %>
                </h1>
                <h3>Show Orders:</h3><br>
                <a href="">order1</a><br>
                <a href="">order2</a><br>
                <a href="">order3</a><br>
                <a href="">order4</a><br>
            </div>
        </div>
    </body>
</html>

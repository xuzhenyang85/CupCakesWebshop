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
                <h1>Hey </h1>
                <%
                    //String email = request.getSession().getAttribute("email").toString();
                    out.print(session.getAttribute("email"));
                    PartMapper pm = new PartMapper();
                    //String name = pm.customerInfo(email).getName();
                    //out.println(name);
                %>
            </div>
        </div>
    </body>
</html>

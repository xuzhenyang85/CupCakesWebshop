
<%@page import="data.Mapper.PartMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang= da>
    
        <script LANGUAGE="JavaScript" src="JS/javascript.js" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">     
        <title>Cup Cakes Webshop</title>

    <div id="logo">
        <a href="index.jsp"><img Src="img/logo.png" style="height:50px; width: 50px;" /></a>
        

        <%
            
            if (session.getAttribute("email") == null || session.getAttribute("email").equals(""))
            {
                out.println("<a href='signup.jsp' style='float:right; margin:15px 25px 0px 0px;'>Sign Up</a>");
                out.println("<a href='login.jsp' style='float:right; margin:15px 25px 0px 0px;'>Log In</a>");    
                out.println("<a href='products.jsp' style='float:right; margin:15px 25px 0px 0px;'>Product</a>"); 
                out.println("<a href='shoppingcart.jsp' style='float:right; margin:15px 25px 0px 0px;'>ShoppingCart</a>"); 
            }
            else
            {
                String sessionEmail = session.getAttribute("email").toString();
                PartMapper pm = new PartMapper();
                String email = pm.customerInfo(sessionEmail).getEmail().toString();
                
                out.println("<form action='LogoutServlet' method='post'>");
                out.println("<input type=submit value='Log Out' class='btm' /> ");
                out.println("</form>");
                out.println("<a href='customer.jsp' style='float:right; margin:15px 25px 0px 0px;'> "+email+"</a>");
                out.println("<a href='products.jsp' style='float:right; margin:15px 25px 0px 0px;'>Product</a>"); 
                out.println("<a href='shoppingcart.jsp' style='float:right; margin:15px 25px 0px 0px;'>ShoppingCart</a>"); 
            }
        %> 

    </div> 

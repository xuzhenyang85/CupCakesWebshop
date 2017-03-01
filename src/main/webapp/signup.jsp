<%-- 
    Document   : create
    Created on : 27-02-2017, 17:04:44
    Author     : Moonniuniu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="masterpage/header.jsp" />
    <body>
        <div class="wrap">
            <div class ="mid">
                <h1>Sign Up</h1>
                <p><form action="Signup" method="POST">
                    Fullname<br>
                    <input type="text" name="name" class="mytext" /><br>
                    Adresse<br>
                    <input type="text" name="adresse" class="mytext" /><br>
                    Phone<br>
                    <input type="text" name="phone" class="mytext" placeholder="+45" /><br>
                    Email<br>
                    <input type="text" name="email" class="mytext" placeholder="@" /><br>
                    Password<br>
                    <input type="password" name="password" class="mytext"  /><br>
                    Password agian<br>
                    <input type="password" name="password2" class="mytext" /><br><br>
                    <input type="submit" value="Sign Up" class="mybtm" /><br><br></p>
                    </body>
                    <jsp:include page="masterpage/footer.jsp" />
                    </html>

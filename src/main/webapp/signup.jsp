<%-- 
    Document   : create
    Created on : 27-02-2017, 17:04:44
    Author     : Moonniuniu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head
        <jsp:include page="masterpage/header.jsp" />
</head>
<body>
    <div class="wrap container">
        <div class ="login container">
            <h1>Sign Up</h1>
            <form   action="Signup" method="POST">
                <p>Fullname</p><br>
                <input type="text" name="name" class="mytext container" /><br>
                <p>Adresse</p><br>
                <input type="text" name="adresse" class="mytext container" /><br>
                <p>Phone</p><br>
                <input type="text" name="phone" class="mytext container" placeholder="+45" /><br>
                <p>Email</p><br>
                <input type="email" name="email" class="mytext container" placeholder="@" /><br>
                <p>Password</p><br>
                <input type="password" name="password" class="mytext container"  /><br>
                <p>Password agian</p><br>
                <input type="password" name="password2" class="mytext container" /><br><br>
                <input type="submit" value="Sign Up" class="mybtm" /><br><br></p>
                </div> 
                </div>
                </body>
                <jsp:include page="masterpage/footer.jsp" />
                </html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <jsp:include page="masterpage/header.jsp" />
    </head>
    <body>
        <div class="wrap container">
            <div class ="login container">
                <h1>Log In</h1>
                
                <form action="Login" method="POST">
                    <p>Your email:</p><br>
                    <input type="email" name="email" class="mytext" /><br>
                    <p>Password</p><br>
                    <input type="password" name="password" class="mytext" /><br>
                    <input type="submit" value="Log In" class="mybtm" /><br><br>
                </form>
            </div>
        </div>
    </body>
        <jsp:include page="masterpage/footer.jsp" />
    </html>

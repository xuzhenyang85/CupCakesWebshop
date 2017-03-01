<%@page import="domain.entites.Customer"%>
<%@page import="data.Mapper.PartMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="masterpage/header.jsp" />
    <body>
        <div class="wrap" >
            <div class="mid">
                <h1>Hey 
                <%
                    String email = session.getAttribute("email").toString();
                    PartMapper pm = new PartMapper();
                    String name = pm.customerInfo(email).getName();
                    double balance =pm.customerInfo(email).getBalance();
                    out.println(name+"<br>");
                    out.println("Balance: "+balance);
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

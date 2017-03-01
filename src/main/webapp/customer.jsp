<%@page import="domain.entites.Customer"%>
<%@page import="data.Mapper.PartMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="masterpage/header.jsp" />
    <body>
        <div class="wrap" >
            <div class="mid">
                
                <%
                    String email = session.getAttribute("email").toString();
                    PartMapper pm = new PartMapper();
                    String name = pm.customerInfo(email).getName();
                    double balance =pm.customerInfo(email).getBalance();
                    
                    out.println("<img src='img/user.jpg' style='width:100px; float:left;' /> ");
                    out.println("<h1 style='float:left;'>"+name+"</h1><br><br><br>");
                    out.println("<p>Balance: "+balance+"</p>");
                %>
                
                <p>Show Orders:</p><br>
                <a href="">order1</a><br>
                <a href="">order2</a><br>
                <a href="">order3</a><br>
                <a href="">order4</a><br>
            </div>
        </div>
    </body>
</html>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.entites.Order"%>
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
                <id class="order container">
                    <form   action="Signup" method="POST">
                <%
                    ArrayList<Order> orders =pm.OrderList(email);
                    for (Order order : orders)
                        {
                            out.println("<h1>Order no. "+order.getOid()+"</h1>");
                            out.println("Order name: "+order.getName()+"<br>");
                            out.println("Order email:"+ order.getEmail()+"<br>");
                            out.println("Order Date: "+ order.getDate()+"<br>" );
                            out.println("QTY: "+ order.getQty()+"<br>" );
                            out.println("Topping price: "+ order.getTprice()+"<br>" );
                            out.println("Bottom price: "+ order.getBprice() +"<br>" );
                            out.println("Total price: "+order.getOprice()+"<br>");
                            if(order.getStatus() ==0){
                            out.println("Status : Not pay <br>");
                            out.print("<input type='submit' value='Pay now' class='mybtm' />");
                            }
                            else{
                                out.print("Payed");
                            }
                        }
                %>
                </id>
                </form>
            </div>
        </div>
    </body>
</html>

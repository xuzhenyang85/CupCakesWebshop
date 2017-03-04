
<%@page import="domain.entites.PBottom"%>
<%@page import="domain.entites.PTop"%>
<%@page import="data.Mapper.PartMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="masterpage/header.jsp" />
    </head>
    <body>
        <div class="wrap container">
            <div class="product container">
                <form action="OrderPay" method="POST">
                    <h1>Shopping Cart</h1>

                    <%

                            boolean booleantopid = session.getAttribute("topid") != null;
                            boolean booleanbottomid = session.getAttribute("bottomid") != null;
                            boolean booleanquantity = session.getAttribute("quantity") != null;
                            if (booleantopid == true && booleanbottomid == true && booleanquantity == true)
                            {
                                PartMapper pm = new PartMapper();

                                int topid = Integer.parseInt(session.getAttribute("topid").toString());
                                int bottomid = Integer.parseInt(session.getAttribute("bottomid").toString());
                                int quantity = Integer.parseInt(session.getAttribute("quantity").toString());

                                PTop topInfo = pm.getTop(topid);
                                PBottom bottomInfo = pm.getBottom(bottomid);
                                double topPrice = topInfo.getTopPrice();
                                double bottomPrice = bottomInfo.getBottomPrice();
                                double totalPrice = (topPrice + bottomPrice) * quantity;

                                out.println("<form action='OrderPay' method='POST' >");
                                out.println("<div class='row'>");
                                out.println("<div class='col-sm'>");
                                //top info
                                out.println("<img src='img/" + topInfo.getTopImgurl() + "' style='width:20%'/>");
                                out.println("Top : " + topInfo.getTopName());
                                out.println("<p>Top Price: " + topPrice + ",-");
                                out.println("</div></div>");
                                //bottom info
                                out.println("<div class='row'>");
                                out.println("<div class='col-sm'>");
                                out.println("<img src='img/" + bottomInfo.getBottomImgurl() + "' style='width:20%' />");
                                out.println("Bottom : " + bottomInfo.getBottomName());
                                out.println("<p>Bottom Price: " + bottomPrice + ",-");
                                out.println("</div></div>");
                                //quantity
                                out.println("<div class='row'>");
                                out.println("<div class='col-sm'>");
                                out.println("Quantity: " + quantity);
                                out.println("<p>Total Price: " + totalPrice + ",-");
                                out.println("</div></div>");
                                //btm
                                out.println("<div class='row'>");
                                out.println("<div class='col-sm'>");
                                out.println("<input type='submit' value='Pay now' >");
                                out.println("</div></div>");

                                out.println("</div></div>");
                                out.println("</div>");//form
                          
                        }
                            else{
                                out.println("Empty shopping chart");
                            }
                    %>

                </form>
            </div>
        </div>
    </body>
    <jsp:include page="masterpage/footer.jsp" />
</html>



<%@page import="domain.entites.PBottom"%>
<%@page import="domain.entites.PTop"%>
<%@page import="data.Mapper.CakeMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.entites.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="masterpage/header.jsp" />
        <script src="JS/product.js"></script>
    </head>
    <body>
        <div class="wrap container" >
            <%-- <jsp:include page="masterpage/nav.jsp" /> --%>

            <div class="product container">
                <form id="order" action="OrderPay" method="post">

                    <input type="hidden" name="origin" value="order">

                        <h2>Tops</h2> 
                        <div id = "tops">
                            <%
                                CakeMapper cm = new CakeMapper();
                                ArrayList<PTop> ptops = new ArrayList<>();
                                ptops = cm.getToppingList();

                                for (int i = 0; i < ptops.size(); i++)
                                {
                                    out.print("<div class='col-6 col-md-4'>");
                                    out.print("<img src='img/" + ptops.get(i).getTopImgurl() + "' />");
                                    out.print("<p>" + ptops.get(i).getTopName() + "</p>");
                                    out.print("<p>" + ptops.get(i).getTopPrice() + "</p>");
                                    out.print("<input name='Top' class='cakepart' type='radio'>");
                                    out.print("<input type='hidden' value='" + ptops.get(i).getId() + "'>");
                                    out.print("</div>");
                                }
                            %>
                        </div>
                        <br><br><br><br>
                        <h2>Bottoms</h2>        
                        <div id="bottoms">
                            <%
                                ArrayList<PBottom> pbottoms = new ArrayList<>();
                                pbottoms = cm.getBottomList();
                                for (int i = 0; i < pbottoms.size(); i++)
                                {
                                    out.print("<div class='col-6 col-md-4'>");
                                    out.print("<img src='img/" + pbottoms.get(i).getBottomImgurl() + "' />");
                                    out.print("<p>" + pbottoms.get(i).getBottomName()+ "</p>");
                                    out.print("<p>" + pbottoms.get(i).getBottomPrice() + "</p>");
                                    out.print("<input name='Bottom' class='cakepart' type='radio'>");
                                    out.print("<input type='hidden' value='" + pbottoms.get(i).getId() + "'>");
                                    out.print("</div>");
                                }

                            %>
                        </div>
                        
                        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                            <p>CakePrice: DKK <span id="CakePrice">0</span>,-    </p>
                            <label>Quantity</label><input type="text" id="quantity">
                            
                            <br>
                            
                            <input id="ButtonAddCakes" type="button" value="Add cakes">
                            
                            <br>

                            <table id = "cakes">
                                <thead class="">
                                    <tr>
                                        <th>Top</th>
                                        <th>Bottom</th>
                                        <th>Price</th>
                                        <th>SubTotal</th>
                                    </tr>
                                </thead>
                                <tbody id="orderlines">                    
                                </tbody>
                            </table>            

                            <div id="cakes">
                            </div>

                            <p>Total: <span id="total"></span></p>

                            <input id="ButtonOrderCakes" type="submit" value="Order" >

                            </form>
                        </div>
                        </div>
                        </body>
                        <jsp:include page="masterpage/footer.jsp" />
                        </html>

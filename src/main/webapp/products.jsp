

<%@page import="domain.entites.PTop"%>
<%@page import="data.Mapper.PartMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.entites.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page="masterpage/header.jsp" />
    <body>
        <div class="wrap" >
            <jsp:include page="masterpage/nav.jsp" /> 
            <div id="product">
                <form id="order" action="Controller" method="post">

                    <input type="hidden" name="origin" value="order">
                    <%

                        PartMapper pm = new PartMapper();

                        ArrayList<Product> products = new ArrayList<>();

                        products = pm.productList();
                        for (Product product : products)
                        {
                            out.println("<div class='container'>");

                            out.println("<div class='row'>");

                            out.println("<div class='col col-md-4'>");
                            out.println("<img src ='img/" + product.getImgurl() + "' />");
                            out.println("</div>");

                            out.println("<div class='col col-md-8'>");
                            out.println("<h3>Cup Cake Type 1: " + product.getPname() + "</3>");
                            out.println("</div>");
                            //row done
                            out.println("</div>");

                            out.println("</div>");
                            out.println("</div>");

                            //container
                            out.println("</div>");
                        }

                        ArrayList<PTop> ptops = new ArrayList<>();
                        ptops = pm.getToppingList();
                        for (PTop ptop : ptops)
                        {
                            out.println(ptop.getTopName());
                        }
                    %>
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="masterpage/footer.jsp" />
</html>

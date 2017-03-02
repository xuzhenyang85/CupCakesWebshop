

<%@page import="domain.entites.PBottom"%>
<%@page import="domain.entites.PTop"%>
<%@page import="data.Mapper.CakeMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.entites.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page="masterpage/header.jsp" />
    <body>
        <div class="wrap" >
            <%-- <jsp:include page="masterpage/nav.jsp" /> --%>

            <div id="product">
                <form id="order" action="Controller" method="post">

                    <input type="hidden" name="origin" value="order">
                    
                    
                    <%

                        CakeMapper cm = new CakeMapper();
                        ArrayList<Product> products = new ArrayList<>();
                        ArrayList<PTop> ptops = new ArrayList<>();
                        ArrayList<PBottom> pbottom = new ArrayList<>();
                        
                        ptops = cm.getToppingList();
                        pbottom = cm.getBottomList();
                                                
                        products = cm.productList();
                        for (Product product : products)
                        {
                            out.println("<div class='container'>");

                            out.println("<div class='row'>");

                            out.println("<div class='col col-md-8'>");
                            out.println("<h3>" + product.getPname() + "</3>");
                            out.println("<h3>Price: DKK " + product.getPrice()+ "</h3>");
                            out.println("</div>"); // col done

                            out.println("</div>");//row done

                        }
                        
                        //topping
                        out.println("<div class='row'>");
                            out.println("<div class='col col-md-12'>");
                                out.println("<h1>Topping</h1>");
                            out.println("</div>");// col done
                        
                        for (int i = 0; i < ptops.size(); i++)
                        {
                            out.println("<div class='col col-md-4'>");
                                out.println("<h3 class='text-left'>"+ptops.get(i).getTopName() + "</h3> <br>");
                                out.println("<img src='img/"+ptops.get(i).getTopImgurl()+"' /><br><br><br><br><br><br><br><br>");
                                out.println("Price: " + ptops.get(i).getTopPrice() + " <br>");
                            out.println("</div>");// col done
                        }
                        out.println("</div>");//row done
                        
                        //bottom
                        out.println("<div class='row'>");
                        
                            out.println("<div class='col col-md-12'>");
                                out.println("<h1>Bottom</h1>");
                            out.println("</div>");// col done
                            
                        for (int i = 0; i < pbottom.size(); i++)
                        {
                            out.println("<div class='col col-md-4'>");
                            out.println("<h3>"+pbottom.get(i).getBottomName()+"</h3><br>");
                            out.println("<img src='img/"+pbottom.get(i).getBottomImgurl()+"' /><br><br><br><br><br><br>");
                            out.println("Price: " + pbottom.get(i).getBottomPrice()+"<br>");
                            out.println("</div>");//col done 
                        }
                        
                        //out.println("<div class='col col-md-4'>");
                        
                        out.println("</div>");// row done

                        //container
                        out.println("</div>");

                    %>
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="masterpage/footer.jsp" />
</html>

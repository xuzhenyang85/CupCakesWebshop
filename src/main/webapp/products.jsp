

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
                        
                        products = cm.productList();
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
                            
                            out.println("</div>");//row done
                            
                        }                      
                       //ArrayList<PBottom> pbottoms = new ArrayList<>();
                       //pbottoms = pm.getBottomList();
                       //for (PBottom pbottom : pbottoms)
                          // {
                              // out.println("BOTTOM!!!" + pbottom.getBottomName());
                          // }
                        
                        
                        ptops = cm.getToppingList();
                        
                        for(int i=0; i< ptops.size(); i++){
                            out.println("<div class='row'>");

                            out.println("<div class='col col-md-4'>");
                            out.println("Topping: "+ptops.get(i).getTopName()+" <br>");
                            out.println("</div>");
                            
                            out.println("<div class='col col-md-4'>");
                            out.println("Price: "+ptops.get(i).getTopPrice()+" <br>");
                            out.println("</div>");

                            //out.println("</div>");
                            //out.println("</div>");

                            //container
                            out.println("</div>");
                        }
                        
                    %>
                </form>
                    </div>
                    </div>
                    </body>
                    <jsp:include page="masterpage/footer.jsp" />
                    </html>

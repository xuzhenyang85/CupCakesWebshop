

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
                
                <% 
                    ArrayList<Product> products = new ArrayList<Product>();
                    PartMapper pm = new PartMapper();
                    //products = pm.productList();
                   // out.print(products.get(1).getPname());
                   // for(int i = 0; i < products.size();i++){
                     //   out.println("ID: "+ products.get(i).getPid());
                       // out.println("Name: "+ products.get(i).getPname());
                       // out.println("Price: " + products.get(i).getPrice());
                     //   out.println("Description: " + products.get(i).getDescription());
                     //   out.println("Topping:" + products.get(i).getTopname());
                      //  out.println("Topping Price: " + products.get(i).getTopPrice());
                      //  out.println("Bottom: " + products.get(i).getBottomName());
                        //out.println("Bottom Price: " + products.get(i).getBottomPrice());
                       // out.println("<img src='img/" + products.get(i).getImgurl()+"' />");
                        
                    //}
                %>

            </div>
        </div>
    </body>
    <jsp:include page="masterpage/footer.jsp" />
</html>

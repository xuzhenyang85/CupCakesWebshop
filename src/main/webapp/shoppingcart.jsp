
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="masterpage/header.jsp" />
        <script src="JS/shoppingcart.js"></script>

    </head>
    <body>
        <div class="wrap container">
            <div class="product container">
                <form action="" method="POST">
                    <h1>Shopping Cart</h1>
                    <input type="hidden" id="hdnSession" data-value="@Request.RequestContext.HttpContext.Session["someKey"]" />
                           <p>Top Price DKK <span id="topprice">0</span>,-    </p>
                    <p>Bottom Price DKK<span id="bottomprice">0</span>,-    </p>
                    <p>Quantity <span id="quantity">0</span>    </p>
                    <p>Total Price DKK <span id="total">0</span>,-    </p>
                    <input type="submit" value="Buy now" >
                    
                </form>
            </div>
        </div>
    </body>
</html>

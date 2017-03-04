
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
                <form action="OrderPay" method="POST">
                    <h1>Shopping Cart</h1>
                    <p>Top Price DKK <span id="topprice" >0</span>,-    </p>
                    <p>Bottom Price DKK<span id="bottomprice">0</span>,-    </p>
                    <p>Quantity <span id="quantity">0</span>    </p>
                    <p>Total Price DKK <span id="total">0</span>,-    </p>
                    
                    <input type="submit" value="Buy now" >
                    <p>Top id <span id="topid">0</span>   </p>
                    <input type="hidden" id="topid" name="top" value="topid"  />
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="masterpage/footer.jsp" />
</html>

var total = 0;

window.addEventListener("load", function(){
    document.getElementById("ButtonAddCakes").addEventListener("click", addCakes);
    
    for (var cp of document.getElementsByClassName("cakepart")) 
    {
        cp.addEventListener("click", updateCakePrice);
    }           
});

function updateCakePrice()
{    
    var topprice = 0;
    var bottomprice = 0;
    
    var tops = document.getElementById("tops").children;
    
    for(var i = 0; i < tops.length; i++)
    {
        var top = tops[i];
        //alert(top.children[3].checked);
        if(top.children[3].checked)
        {  
            
            topprice = parseInt(top.children[2].innerHTML);
            //alert(topprice);
        }
    }
    
    var bottoms = document.getElementById("bottoms").children;
    for(var i = 0; i < bottoms.length; i++)
    {
        var bottom = bottoms[i];
        //alert(bottom.children[3].checked)
        if(bottom.children[3].checked)
        { 
            bottomprice = parseInt(bottom.children[2].innerHTML);
            //alert(bottomprice);
        }
    }
    
    var cakeprice = topprice + bottomprice;
    
    //alert(topprice + " "+ bottomprice);
    
    document.getElementById("CakePrice").innerHTML = cakeprice;
    
}

function addCakes()
{    
    //Tops
    var topid = 0;
    var topname = "";
    var topprice = 0;
    var tops = document.getElementById("tops").children;
    for(var i = 0; i < tops.length; i++)
    {
        var top = tops[i];
        //alert(top.children[3].checked);
        if(top.children[3].checked)
        {
            topid = top.children[4].value;            
            topname = top.children[1].innerHTML;   
            topprice = parseInt(top.children[2].innerHTML);
            //alert(topprice);
        }
    }
    
    //Bottoms
    var bottomid = 0;
    var bottomname = "";
    var bottomprice = 0;
    var bottoms = document.getElementById("bottoms").children;
    for(var i = 0; i < bottoms.length; i++)
    {
        var bottom = bottoms[i];
        //alert(bottom.children[3].checked);
        if(bottom.children[3].checked)
        {
            bottomid = bottom.children[4].value;            
            bottomname = bottom.children[1].innerHTML;  
            bottomprice = parseInt(bottom.children[2].innerHTML);
            //alert(bottomprice);
        }
    }
    
    //Quantity
    //var quantity = 0;
    //quantity = document.getElementById("quantity").value;
    
    //CakePrice
    var cakeprice = topprice + bottomprice;
    
    //Subtotal
    var subtotal = 5 + cakeprice;
    
    total += subtotal;
    document.getElementById("total").innerHTML = total;
    
    //Orderlines
    var orderlines = document.getElementById("orderlines");
    orderlines.innerHTML += 
            '<tr>' +
            '<td>' + topname + '</td>' +
            '<td>' + bottomname + '</td>' +
            '<td>' + cakeprice + '</td>' +
            '<td>' + quantity + '</td>' +
            '<td>' + subtotal + '</td>' +
            '</tr>';
    
    //Cakes
    var cakes = document.getElementById("cakes");
    cakes.innerHTML +=
            '<input type="hidden" name="cakestopid" value="' + topid + '">' +
            '<input type="hidden" name="cakesbottomid" value="' + bottomid + '">' +
            '<input type="hidden" name="cakesquantity" value="' + quantity + '">';
    
    //CheckBalance
    if(document.getElementById("CustomerName") != null)
    {
        if(parseFloat(document.getElementById("CustomerBalance").innerHTML) >= total)
        {
            document.getElementById("ButtonOrderCakes").removeAttribute("disabled");
        }
        else
        {
            document.getElementById("ButtonOrderCakes").setAttribute("disabled", "disabled");
        }
    }
}
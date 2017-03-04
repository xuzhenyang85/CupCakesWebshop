var topid = 0;
var topprice = 0;
var bottomid = 0;
var bottomprice = 0;
var quantity = 0;
var total = 0;
var email = null;

window.addEventListener("load", function () {
    
    topid = sessionStorage.getItem('topid');
    topprice = sessionStorage.getItem('topprice');
    bottomid = sessionStorage.getItem('bottomid');
    bottomprice = sessionStorage.getItem('bottomprice');
    quantity = sessionStorage.getItem('quantity');
    total = sessionStorage.getItem('total');
    
    document.getElementById("topid").innerHTML = topid;
    document.getElementById("topprice").innerHTML = topprice;
    document.getElementById("bottomprice").innerHTML = bottomprice;
    document.getElementById("quantity").innerHTML = quantity;
    document.getElementById("total").innerHTML = total;
    
    //var username= "<%= Session["UserName"]%>";
});
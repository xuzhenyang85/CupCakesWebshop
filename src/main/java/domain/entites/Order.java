
package domain.entites;

public class Order
{
    private int oid;
    private String name;
    private String email;
    private String date;
    private int qty;
    private double tprice;
    private double bprice;
    private double oprice;
    private int status;

    public Order(int oid, String name, String email, String date, int qty, double tprice, double bprice, double oprice,int status)
    {
        this.oid = oid;
        this.name = name;
        this.email = email;
        this.date = date;
        this.qty = qty;
        this.tprice = tprice;
        this.bprice = bprice;
        this.oprice = oprice;
        this.status = status;
    }
    
    public Order(){
        
    }

    public int getOid()
    {
        return oid;
    }

    public void setOid(int oid)
    {
        this.oid = oid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getQty()
    {
        return qty;
    }

    public void setQty(int qty)
    {
        this.qty = qty;
    }

    public double getTprice()
    {
        return tprice;
    }

    public void setTprice(double tprice)
    {
        this.tprice = tprice;
    }

    public double getBprice()
    {
        return bprice;
    }

    public void setBprice(double bprice)
    {
        this.bprice = bprice;
    }

    public double getOprice()
    {
        return oprice;
    }

    public void setOprice(double oprice)
    {
        this.oprice = oprice;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Order{" + "oid=" + oid + ", name=" + name + ", email=" + email + ", date=" + date + ", qty=" + qty + ", tprice=" + tprice + ", bprice=" + bprice + ", oprice=" + oprice + ", status=" + status + '}';
    }

    

    
}

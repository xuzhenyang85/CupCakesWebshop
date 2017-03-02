
package domain.entites;


public class Product
{
    private int pid;
    private String pname;
    private double price;
    private String topname;
    private double topPrice;
    private String bottomName;
    private double bottomPrice;

    public Product(int pid, String pname, double price, String topname, double topPrice, String bottomName, double bottomPrice)
    {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.topname = topname;
        this.topPrice = topPrice;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
    }
    
    public Product(){
        
    }

    public int getPid()
    {
        return pid;
    }

    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getTopname()
    {
        return topname;
    }

    public void setTopname(String topname)
    {
        this.topname = topname;
    }

    public double getTopPrice()
    {
        return topPrice;
    }

    public void setTopPrice(double topPrice)
    {
        this.topPrice = topPrice;
    }

    public String getBottomName()
    {
        return bottomName;
    }

    public void setBottomName(String bottomName)
    {
        this.bottomName = bottomName;
    }

    public double getBottomPrice()
    {
        return bottomPrice;
    }

    public void setBottomPrice(double bottomPrice)
    {
        this.bottomPrice = bottomPrice;
    }

    @Override
    public String toString()
    {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", price=" + price + ", topname=" + topname + ", topPrice=" + topPrice + ", bottomName=" + bottomName + ", bottomPrice=" + bottomPrice + '}';
    }



    
}

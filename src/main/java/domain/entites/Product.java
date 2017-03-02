
package domain.entites;


public class Product
{
    private int pid;
    private String pname;
    private String description;
    private String topname;
    private double topPrice;
    private String bottomName;
    private double bottomPrice;
    private String imgurl;

    public Product(int pid, String pname, String description, String topname, double topPrice, String bottomName, double bottomPrice, String imgurl)
    {
        this.pid = pid;
        this.pname = pname;
        this.description = description;
        this.topname = topname;
        this.topPrice = topPrice;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
        this.imgurl = imgurl;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public String getImgurl()
    {
        return imgurl;
    }

    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

    @Override
    public String toString()
    {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", description=" + description + ", topname=" + topname + ", topPrice=" + topPrice + ", bottomName=" + bottomName + ", bottomPrice=" + bottomPrice + ", imgurl=" + imgurl + '}';
    }


    
}

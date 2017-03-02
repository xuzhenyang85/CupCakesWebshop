
package domain.entites;

public class PTop
{
    private int id;
    private String topName;
    private double topPrice;
    private String topImgurl;

    public PTop(int id, String topName, double topPrice, String topImgurl)
    {
        this.id = id;
        this.topName = topName;
        this.topPrice = topPrice;
        this.topImgurl = topImgurl;
    }
    
    public PTop(){
        
    }

    public int getId()
    {
        return id;
    }

    public String getTopName()
    {
        return topName;
    }

    public void setTopName(String topName)
    {
        this.topName = topName;
    }

    public double getTopPrice()
    {
        return topPrice;
    }

    public void setTopPrice(double topPrice)
    {
        this.topPrice = topPrice;
    }

    public String getTopImgurl()
    {
        return topImgurl;
    }

    public void setTopImgurl(String topImgurl)
    {
        this.topImgurl = topImgurl;
    }

    @Override
    public String toString()
    {
        return "PTop{" + "id=" + id + ", topName=" + topName + ", topPrice=" + topPrice + ", topImgurl=" + topImgurl + '}';
    }
    
        
    
}


package domain.entites;


public class PBottom
{
    private int id;
    private String bottomName;
    private double bottomPrice;
    private String bottomImgurl;

    public PBottom(int id, String bottomName, double bottomPrice, String bottomImgurl)
    {
        this.id = id;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
        this.bottomImgurl = bottomImgurl;
    }

    public int getId()
    {
        return id;
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

    public String getBottomImgurl()
    {
        return bottomImgurl;
    }

    public void setBottomImgurl(String bottomImgurl)
    {
        this.bottomImgurl = bottomImgurl;
    }

    @Override
    public String toString()
    {
        return "PBottom{" + "id=" + id + ", bottomName=" + bottomName + ", bottomPrice=" + bottomPrice + ", bottomImgurl=" + bottomImgurl + '}';
    }
    
    
        
}


package domain.entites;


public class PBottom
{
    private int id;
    private String bottomName;
    private double bottomPrice;

    public PBottom(int id, String bottomName, double bottomPrice)
    {
        this.id = id;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
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

    @Override
    public String toString()
    {
        return "PBottom{" + "id=" + id + ", bottomName=" + bottomName + ", bottomPrice=" + bottomPrice + '}';
    }
        
}

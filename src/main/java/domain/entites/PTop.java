
package domain.entites;

public class PTop
{
    private int id;
    private String topName;
    private double topPrice;

    public PTop(int id, String topName, double topPrice)
    {
        this.id = id;
        this.topName = topName;
        this.topPrice = topPrice;
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

    @Override
    public String toString()
    {
        return "PTop{" + "id=" + id + ", topName=" + topName + ", topPrice=" + topPrice + '}';
    }
    
    
    
}

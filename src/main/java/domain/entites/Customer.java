
package domain.entites;

public class Customer
{
    private int uid;
    private String name;
    private String password;
    private double balance;

    public Customer(int uid, String name, String password, double balance)
    {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    
    public Customer(){
        
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    
}

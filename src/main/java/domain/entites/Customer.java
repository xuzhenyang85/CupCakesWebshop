
package domain.entites;

public class Customer
{
    private String name;
    private String adresse;
    private String phone;
    private String email;
    private String password;
    private double balance;

    public Customer(String name, String adresse, String phone, String email, String password, double balance)
    {
        this.name = name;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    public Customer(){
        
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
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

    @Override
    public String toString()
    {
        return "Customer{" + "name=" + name + ", adresse=" + adresse + ", phone=" + phone + ", email=" + email + ", password=" + password + ", balance=" + balance + '}';
    }
    
    
    
}

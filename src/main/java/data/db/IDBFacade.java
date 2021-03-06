
package data.db;

import domain.entites.Customer;
import domain.entites.Order;
import domain.entites.PBottom;
import domain.entites.PTop;
import domain.exception.CustomerException;
import java.util.ArrayList;

public interface IDBFacade
{
    public void signUp(String name,String adresse, String phone, String email, String password) throws CustomerException;
    public boolean validateCustomer(String name,String password) throws CustomerException;
    public Customer customerInfo (String email) throws CustomerException;
    public ArrayList<PTop> getToppingList();
    public ArrayList<PBottom> getBottomList();
    public void addOrder(int FK_topid,int FK_bottomid,int qty,String email,double totalPrice);
    public ArrayList<Order> OrderList(String email);
    public PTop getTop (int FK_topId);
    public PBottom getBottom(int FK_bottomId);
    public void fillUpBalance(double balance, String email);
    public boolean enoughMoney (String email,double totalPrice);
}

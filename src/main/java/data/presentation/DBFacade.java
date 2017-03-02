
package data.presentation;

import data.db.IDBFacade;
import domain.entites.Customer;
import domain.entites.PBottom;
import domain.entites.PTop;
import domain.entites.Product;
import domain.exception.CustomerException;
import java.util.ArrayList;


public class DBFacade implements IDBFacade
{

    @Override
    public void signUp(String name, String adresse, String phone, String email, String password) throws CustomerException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateCustomer(String name, String password) throws CustomerException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer customerInfo(String email) throws CustomerException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Product> productList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PTop> getToppingList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PBottom> getBottomList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

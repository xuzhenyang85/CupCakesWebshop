
package data.presentation;

import data.db.IDBFacade;
import domain.entites.Customer;
import domain.exception.CustomerException;


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
    
}

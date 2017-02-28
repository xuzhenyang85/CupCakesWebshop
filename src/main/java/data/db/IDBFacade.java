
package data.db;

import domain.entites.Customer;
import domain.exception.CustomerException;

public interface IDBFacade
{
    public void signUp(String name,String adresse, String phone, String email, String password) throws CustomerException;
    public boolean validateCustomer(String name,String password) throws CustomerException;
    public Customer customerInfo (String email) throws CustomerException;
    
    
}

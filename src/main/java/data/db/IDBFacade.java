
package data.db;

import domain.entites.Customer;
import domain.exception.CustomerException;

public interface IDBFacade
{
    public void signUp(String name,String password,double balance) throws CustomerException;
    public void validateCustomer(String name,String password);
    public Customer customerInfo ();
    
    
}

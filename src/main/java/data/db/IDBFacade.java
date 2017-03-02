
package data.db;

import domain.entites.Customer;
import domain.entites.PBottom;
import domain.entites.PTop;
import domain.entites.Product;
import domain.exception.CustomerException;
import java.util.ArrayList;

public interface IDBFacade
{
    public void signUp(String name,String adresse, String phone, String email, String password) throws CustomerException;
    public boolean validateCustomer(String name,String password) throws CustomerException;
    public Customer customerInfo (String email) throws CustomerException;

}

package data.Mapper;

import data.db.DB;
import data.db.IDBFacade;
import domain.entites.Customer;
import domain.exception.CustomerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartMapper implements IDBFacade
{

    private Connection conn = new DB().getConnection();

    @Override
    public void signUp(String name, String password, double balance) throws CustomerException
    {
        try
        {
            String sql = "INSERT INTO customers (name,password,balance) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setDouble(3, balance);
            pstmt.executeUpdate();
            
        } catch (SQLException ex)
        {
            throw new CustomerException("Error in signUp() " + ex.getMessage());
        }

    }

    @Override
    public void validateCustomer(String name, String password)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer customerInfo()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

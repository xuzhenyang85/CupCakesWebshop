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
    public void signUp(String name, String adresse, String phone, String email, String password) throws CustomerException
    {
        try
        {

            String sql = "INSERT INTO customers (name,adresse,phone,email,password) VALUES (?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, adresse);
            pstmt.setString(3, phone);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.executeUpdate();

        } catch (SQLException ex)
        {
            throw new CustomerException("Error in signUp() " + ex.getMessage());
        }

    }

    @Override
    public boolean validateCustomer(String email, String password) throws CustomerException
    {
        try
        {
            String sql = "SELECT email,password FROM customers WHERE email = ? AND password = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                return true;
            } else
            {
                return false;
            }
        } catch (SQLException ex)
        {
            throw new CustomerException("Error in validateCustomer() " + ex.getMessage());
        }
    }

    @Override
    public Customer customerInfo(String email) throws CustomerException
    {
        Customer customer = null;
        try
        {
            String sql = "SELECT * FROM customers where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String name = rs.getString("name");
                String adresse = rs.getString("adresse");
                String phone = rs.getString("phone");
                String cemail = rs.getString("email");
                String password = rs.getString("password");
                double balance = rs.getDouble("balance");
                customer = new Customer(name, adresse, phone, cemail, password, balance);
            }
            return customer;
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }


    public static void main(String[] args)
    {
        try
        {
            PartMapper pm = new PartMapper();
            pm.signUp("xu", "jyllingvej", "234234", "xu@dk.dk", "1234");
//        ArrayList<PBottom> pbottoms = new ArrayList<>();
//        pbottoms = pm.getBottomList();
//        for (PBottom pbottom : pbottoms)
//        {
//            System.out.println(pbottom.getBottomName());
//        }
        } catch (CustomerException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

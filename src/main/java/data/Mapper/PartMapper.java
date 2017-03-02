package data.Mapper;

import data.db.DB;
import data.db.IDBFacade;
import domain.entites.Customer;
import domain.entites.PBottom;
import domain.entites.PTop;
import domain.entites.Product;
import domain.exception.CustomerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public ArrayList<Product> productList()
    {
        ArrayList<Product> products = new ArrayList<Product>();
        try
        {
            String sql = "SELECT pid, pname, description,imgurl "
                    + "FROM products "
                    + "INNER JOIN img ON img.FK_pid = products.pid;";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                int pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                String description = rs.getString("description");
                String topName = null;
                double topPrice = 0;
                String bottomName = null;
                double bottomPrice = 0;
                String imgurl = rs.getString("imgurl");
                Product product = new Product(pid, pname, description, topName, topPrice, bottomName, bottomPrice, imgurl);
                products.add(product);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return products;
    }

    @Override
    public ArrayList<PTop> getToppingList()
    {
        ArrayList<PTop> ptops = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM ptop;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String topName = rs.getString("topName");
                double topPrice = rs.getDouble("topPrice");
                PTop ptop = new PTop(id, topName, topPrice);
                ptops.add(ptop);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return ptops;
    }

    @Override
    public ArrayList<PBottom> getBottomList()
    {
        ArrayList<PBottom> pbottoms = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM pbottom;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String bottomName = rs.getString("bottomName");
                double bottomPrice = rs.getDouble("bottomPrice");
                PBottom pbottom = new PBottom(id, bottomName, bottomPrice);
                pbottoms.add(pbottom);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return pbottoms;
    }

    public static void main(String[] args)
    {
        PartMapper pm = new PartMapper();

//        ArrayList<PBottom> pbottoms = new ArrayList<>();
//        pbottoms = pm.getBottomList();
//        for (PBottom pbottom : pbottoms)
//        {
//            System.out.println(pbottom.getBottomName());
//        }
        
        ArrayList<PTop> ptops = new ArrayList<>();
        ptops = pm.getToppingList();
        for (PTop ptop : ptops)
        {
            System.out.println(ptop.getTopName());
        }
//        ArrayList<Product> products = new ArrayList<>();
//        products = pm.productList();
//        
//        for (Product product : products)
//        {
//            System.out.println(product.getPname());
//        }
    }
}

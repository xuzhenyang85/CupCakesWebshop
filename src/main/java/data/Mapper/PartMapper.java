package data.Mapper;

import data.db.DB;
import data.db.IDBFacade;
import domain.entites.Customer;
import domain.entites.Order;
import domain.entites.PBottom;
import domain.entites.PTop;
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

    public static void main(String[] args)
    {
        PartMapper pm = new PartMapper();
        pm.fillUpBalance(20, "martin@dk.dk");
        //pm.addOrder(2, 2, 100, "martin@dk.dk");
        
//        double bottomprice=pm.getBottom(4).getBottomPrice();
//        double topPrice = pm.getTop(2).getTopPrice();
//        System.out.println("topprice "+topPrice+" bottomprice  "+bottomprice);
        
//        ArrayList<Order> orders = pm.OrderList("martin@dk.dk");
//        for (Order order : orders)
//        {
//            System.out.println(order.getOprice());
//        }
//            boolean customer = pm.validateCustomer("xu@dk.dk", "1234");
//            System.out.println(customer);
//        ArrayList<PBottom> pbottoms = new ArrayList<>();
//        pbottoms = pm.getBottomList();
//        for (PBottom pbottom : pbottoms)
//        {
//            System.out.println(pbottom.getBottomName());
//     

    }

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
                String topImgurl = rs.getString("topImgurl");
                PTop ptop = new PTop(id, topName, topPrice, topImgurl);
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
                String bottomImgurl = rs.getString("bottomImgurl");
                PBottom pbottom = new PBottom(id, bottomName, bottomPrice, bottomImgurl);
                pbottoms.add(pbottom);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return pbottoms;
    }

    @Override
    public void addOrder(int FK_topid, int FK_bottomid, int qty, String email)
    {
        try
        {
            PartMapper pm = new PartMapper();
            double topPrice = pm.getTop(FK_topid).getTopPrice();
            double bottomPrice = pm.getBottom(FK_bottomid).getBottomPrice();
            double totalPrice = topPrice + bottomPrice;
            
            conn.setAutoCommit(false); //transaction block start
            String insertOrders = "INSERT INTO orders (date,oPrice) VALUES (NOW(),?);";
            String insertOlines = "INSERT INTO o_lines "
                    + "(FK_oid,FK_topId,FK_bottomId,FK_cemail,qty) VALUES "
                    + "(LAST_INSERT_ID(),?,?,?,?)";
            PreparedStatement addOrder = conn.prepareStatement(insertOrders);
            addOrder.setDouble(1, totalPrice);
            addOrder.executeUpdate();
            
            PreparedStatement addOlines = conn.prepareStatement(insertOlines);
            addOlines.setInt(1, FK_topid);
            addOlines.setInt(2, FK_bottomid);
            addOlines.setString(3, email);
            addOlines.setInt(4, qty);
            addOlines.executeUpdate(); //Error, rollback, including the first insert statement.
            conn.commit(); //transaction block end
            
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public ArrayList<Order> OrderList(String email)
    {
        ArrayList<Order> orders = new ArrayList<>();
        try
        {
            String sql = "SELECT oid,name,email, date, qty,topPrice,bottomPrice,oPrice,status FROM customers "
                    + "INNER JOIN o_lines ON customers.email = o_lines.FK_cemail "
                    + "INNER JOIN orders ON o_lines.FK_oid = orders.oid "
                    + "INNER JOIN  ptop ON o_lines.FK_topId = ptop.id "
                    + "INNER JOIN pbottom ON o_lines.FK_bottomId = pbottom.id WHERE email =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int oid = rs.getInt("oid");
                String name = rs.getString("name");
                String cemail = rs.getString("email");
                String date = rs.getString("date");
                int qty = rs.getInt("qty");
                double tprice = rs.getDouble("topPrice");
                double bprice = rs.getDouble("bottomPrice");
                double oPrice = rs.getByte("oPrice");
                int status = rs.getInt("status");
                Order order = new Order(oid, name, cemail, date, qty, tprice, bprice, oPrice,status);
                orders.add(order);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return orders;
    }

    @Override
    public PTop getTop(int FK_topId)
    {
        PTop top = null;
        try
        {
            String sql = "SELECT id,topName,topPrice,topImgurl FROM ptop WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, FK_topId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int topId = rs.getInt("id");
                String topName = rs.getString("topName");
                double topPrice = rs.getDouble("topPrice");
                String topImgurl = rs.getString("topImgurl");
                top = new PTop(topId,topName,topPrice,topImgurl);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return top;
    }

    @Override
    public PBottom getBottom(int FK_bottomId)
    {
        PBottom bottom = null;
        try
        {
            String sql = "SELECT id,bottomName,bottomPrice,bottomImgurl FROM pbottom WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, FK_bottomId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int bottomId = rs.getInt("id");
                String bottomName = rs.getString("bottomName");
                double bottomPrice = rs.getDouble("bottomPrice");
                String bottomImgurl = rs.getString("bottomImgurl");
                bottom = new PBottom(bottomId,bottomName,bottomPrice,bottomImgurl);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return bottom;
    }

    @Override
    public void fillUpBalance(double balance,String email)
    {
        try
        {
            String sql = "UPDATE customers SET balance =balance+? WHERE email=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, balance);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        
    }
}



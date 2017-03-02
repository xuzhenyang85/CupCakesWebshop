
package data.Mapper;

import data.db.DB;
import data.db.ICakeFacade;
import domain.entites.PBottom;
import domain.entites.PTop;
import domain.entites.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CakeMapper implements ICakeFacade
{
    private Connection conn = new DB().getConnection();
    
    
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
        CakeMapper cm = new CakeMapper();
        ArrayList<PTop> ptops = new ArrayList<>();
        ptops = cm.getToppingList();
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

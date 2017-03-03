
package data.Mapper;

import data.db.DB;
import data.db.ICakeFacade;
import domain.entites.PBottom;
import domain.entites.PTop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CakeMapper implements ICakeFacade
{
    private Connection conn = new DB().getConnection();
    
     
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
                PTop ptop = new PTop(id, topName, topPrice,topImgurl);
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
                PBottom pbottom = new PBottom(id, bottomName, bottomPrice,bottomImgurl);
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

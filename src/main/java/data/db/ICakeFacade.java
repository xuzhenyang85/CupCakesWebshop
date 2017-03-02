
package data.db;

import domain.entites.PBottom;
import domain.entites.PTop;
import domain.entites.Product;
import java.util.ArrayList;


public interface ICakeFacade
{
    public ArrayList<Product> productList ();
    public ArrayList<PTop> getToppingList();
    public ArrayList<PBottom> getBottomList();
}

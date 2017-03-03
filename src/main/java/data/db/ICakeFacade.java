
package data.db;

import domain.entites.PBottom;
import domain.entites.PTop;
import java.util.ArrayList;


public interface ICakeFacade
{
    public ArrayList<PTop> getToppingList();
    public ArrayList<PBottom> getBottomList();
    //public Order getOrder;
}

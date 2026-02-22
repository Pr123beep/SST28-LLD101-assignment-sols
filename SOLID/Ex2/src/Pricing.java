import java.util.*;

public class Pricing {
    public double subtotal(Map<String, MenuItem> menu, List<OrderLine> lines)
    {
        double sum = 0;
        for(OrderLine it : lines)
        {
            sum += menu.get(it.itemId).price * it.qty;
        }
        return sum;
    }
}

import java.util.*;

public class AddOnsPrice implements MonthlyPrice {
    private final Map<AddOn, Money> mp;
    public AddOnsPrice(Map<AddOn, Money> mp)
    {
        this.mp = mp;
    }

    @Override
    public Money monthly(BookingRequest req) {
        
        Money tot = new Money(0);
        for(AddOn a : req.addOns)
        {
            tot = tot.plus(mp.getOrDefault(a, new Money(0)));
        }
        return tot;
    }
}

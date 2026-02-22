import java.util.*;

public class RoomPrice implements MonthlyPrice {
    private final Map<Integer, Money> mp;
    public RoomPrice(Map<Integer, Money> mp)
    {
        this.mp = mp;
    }

    @Override
    public Money monthly(BookingRequest req) {
        return mp.getOrDefault(req.roomType, new Money(16000.0));
    }

}

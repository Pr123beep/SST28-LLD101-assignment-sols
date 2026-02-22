import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        Map<Integer, Money> rooms = Map.of(LegacyRoomTypes.SINGLE, new Money(14000),LegacyRoomTypes.DOUBLE, new Money(15000),LegacyRoomTypes.TRIPLE, new Money(12000),LegacyRoomTypes.DELUXE, new Money(16000));
        Map<AddOn, Money> addOns = Map.of(AddOn.MESS, new Money(1000),AddOn.LAUNDRY, new Money(500),AddOn.GYM, new Money(300));
        List<MonthlyPrice> comps = List.of(new RoomPrice(rooms), new AddOnsPrice(addOns));

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), comps);
        calc.process(req);
    }
}

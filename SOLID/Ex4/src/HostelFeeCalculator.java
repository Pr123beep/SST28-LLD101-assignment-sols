import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<MonthlyPrice> comps;

    public HostelFeeCalculator(FakeBookingRepo repo, List<MonthlyPrice> comps) { this.repo = repo; this.comps = comps; }

    public void process(BookingRequest req) {
        Money monthly = new Money(0);
        for (MonthlyPrice it : comps) 
        {
            monthly = monthly.plus(it.monthly(req));
        }
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

}

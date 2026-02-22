import java.util.*;

public interface InvoiceFormatter {
    String format(String invId, List<OrderLine> lines, Map<String, MenuItem> menu, double subtotal, double taxPct, double tax, double discount, double total);
}
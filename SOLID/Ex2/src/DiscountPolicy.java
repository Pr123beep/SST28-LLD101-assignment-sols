public interface DiscountPolicy {
    double discountAmt(String customerType, double subtotal, int lines);
}

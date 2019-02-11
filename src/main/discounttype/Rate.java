package main.discounttype;

public class Rate implements DiscountTypeInterface {

    @Override
    public double calculate(double totalAmount, double discountAmount) {
        return totalAmount * discountAmount / 100;
    }
}

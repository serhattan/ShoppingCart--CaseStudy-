package main.DiscountType;

public class Amount implements DiscountTypeInterface {

    @Override
    public double calculate(double totalAmount, double discountAmount) {

        return discountAmount;
    }
}

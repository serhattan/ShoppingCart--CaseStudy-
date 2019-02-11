package main.discounttype;

public class Amount implements DiscountTypeInterface {

    @Override
    public double calculate(double totalAmount, double discountAmount) {

        return discountAmount;
    }
}

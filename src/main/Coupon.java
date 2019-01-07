package main;

import main.DiscountType.DiscountTypeInterface;

public class Coupon {
    private double minCartAmount;
    private double amount;
    private DiscountTypeInterface discountType;

    public Coupon(double minCartAmount, double amount, DiscountTypeInterface discountType) {
        this.minCartAmount = minCartAmount;
        this.amount = amount;
        this.discountType = discountType;
    }

    /**
     *
     * @return minCartAmount
     */
    public double getMinCartAmount() {
        return minCartAmount;
    }

    /**
     *
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     *
     * @return discountType
     */
    public DiscountTypeInterface getDiscountType() {
        return discountType;
    }

    /**
     *
     * @param minCartAmount;
     */
    public void setMinCartAmount(double minCartAmount) {
        this.minCartAmount = minCartAmount;
    }

    /**
     *
     * @param amount;
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     *
     * @param discountType;
     */
    public void setDiscountType(DiscountTypeInterface discountType) {
        this.discountType = discountType;
    }
}

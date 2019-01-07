package main;

import main.DiscountType.DiscountTypeInterface;

public class Campaign {
    private Category category;
    private double amount;
    private int productCount;
    private DiscountTypeInterface discountType;

    public Campaign(Category category, double amount, int productCount, DiscountTypeInterface discountType) {
        this.category = category;
        this.amount = amount;
        this.productCount = productCount;
        this.discountType = discountType;
    }

    /**
     *
     * @return category
     */
    public Category getCategory() {
        return category;
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
     * @return productCount
     */
    public int getProductCount() {
        return productCount;
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
     * @param category;
     */
    public void setCategory(Category category) {
        this.category = category;
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
     * @param productCount;
     */
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    /**
     *
     * @param discountType;
     */
    public void setDiscountType(DiscountTypeInterface discountType) {
        this.discountType = discountType;
    }
}

package main;

import java.util.ArrayList;
import java.util.HashMap;

public class DeliveryCostCalculator {
    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost;
    public static final double FIXED_COST = 3.99;

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = DeliveryCostCalculator.FIXED_COST;
    }

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct, double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    /**
     *
     * @return costPerDelivery
     */
    public double getCostPerDelivery() {
        return costPerDelivery;
    }

    /**
     *
     * @return costPerProduct
     */
    public double getCostPerProduct() {
        return costPerProduct;
    }

    /**
     *
     * @return fixedCost
     */
    public double getFixedCost() {
        return fixedCost;
    }

    /**
     *
     * @param costPerDelivery;
     */
    public void setCostPerDelivery(double costPerDelivery) {
        this.costPerDelivery = costPerDelivery;
    }

    /**
     *
     * @param costPerProduct;
     */
    public void setCostPerProduct(double costPerProduct) {
        this.costPerProduct = costPerProduct;
    }

    /**
     *
     * @param fixedCost;
     */
    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }

    /**
     *
     * @param shoppingCart;
     */
    public void calculateFor(ShoppingCart shoppingCart) {
        int numberOfProducts = 0;

        HashMap<Category, ArrayList<CartItem>> cartItems = shoppingCart.getCart();
        int numberOfDevliveries = cartItems.size();

        for (ArrayList<CartItem> item: cartItems.values()) {
            numberOfProducts += item.size();
        }
        double deleverycost = (costPerDelivery * numberOfDevliveries) + (costPerProduct * numberOfProducts) + fixedCost;
        shoppingCart.setDeliveryCost(deleverycost);
    }
}

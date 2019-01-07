package main;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    /**
     *
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     *
     * @return amount
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param product;
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     *
     * @param quantity;
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

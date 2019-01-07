package main;

public class Product {
    private String title;
    private double price;
    private Category category;

    public Product(String title, double price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return price
     */
    public double getPrice() {
        return price;
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
     * @param title;
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param price;
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param category;
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}

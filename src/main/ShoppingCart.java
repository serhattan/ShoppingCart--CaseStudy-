package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private double totalAmount;
    private double campaignDiscount;
    private double couponDiscount;
    private double deliveryCost;
    private HashMap<Category, ArrayList<CartItem>> cart = new HashMap<>();

    /**
     *
     * @return totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     *
     * @return campaignDiscount
     */
    public double getCampaignDiscount() {
        return campaignDiscount;
    }

    /**
     *
     * @return couponDiscount
     */
    public double getCouponDiscount() {
        return couponDiscount;
    }

    /**
     *
     * @return deliveryCost
     */
    public double getDeliveryCost() {
        return deliveryCost;
    }

    /**
     *
     * @return cart
     */
    public Map<Category, ArrayList<CartItem>> getCart() {
        return cart;
    }

    /**
     *
     * @param totalAmount;
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     *
     * @param campaignDiscount;
     */
    public void setCampaignDiscount(Double campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    /**
     *
     * @param couponDiscount;
     */
    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     *
     * @param deliveryCost;
     */
    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    /**
     *
     * @param cart;
     */
    public void setCart(HashMap<Category, ArrayList<CartItem>> cart) {
        this.cart = cart;
    }

    /**
     *
     * @param product;
     * @param quantity;
     */
    public void addItem(Product product, int quantity) {
        boolean isNew = true;
        ArrayList<CartItem> productList = new ArrayList<>();
        CartItem item = new CartItem(product, quantity);

        Category category = product.getCategory();
        if (this.isCategoryInCart(category)) {
            productList = cart.get(category);

            for (CartItem cartItem: productList) {
                if ((cartItem.getProduct()).equals(product)) {
                    isNew = false;
                    int totalQuantity = cartItem.getQuantity() + item.getQuantity();
                    cartItem.setQuantity(totalQuantity);
                }
            }
        }

        if (isNew) {
            productList.add(item);
        }

        cart.put(category, productList);
        this.calculateTotalAmount(item);
    }

    /**
     *
     * @param discounts;
     */
    public void applyDiscounts(Campaign... discounts) {
        double categoryDiscount;

        for (Campaign discount: discounts) {
            if (isCategoryInCart(discount.getCategory()) || isProductsParentCategoryInCampaign(discount.getCategory())) {
                ArrayList<CartItem> categoryProductList = this.getCategoryProductList(discount.getCategory());
                int categoryItemCount = this.getCategoryItemCount(categoryProductList);

                if (categoryItemCount > discount.getProductCount()) {
                    double categoryTotalAmount = this.getItemsTotalAmount(categoryProductList);
                    categoryDiscount = discount.getDiscountType().calculate(categoryTotalAmount, discount.getAmount());

                    if (categoryDiscount > campaignDiscount) {
                        campaignDiscount = categoryDiscount;
                    }
                }
            }
        }
    }

    /**
     *
     * @param coupon;
     */
    public void applyCoupon(Coupon coupon) {
        double totalAmountAfterCampaign = this.getTotalAmountAfterCampaign();
        if (totalAmountAfterCampaign > coupon.getMinCartAmount()) {
            couponDiscount = coupon.getDiscountType().calculate(totalAmountAfterCampaign, coupon.getAmount());
        }
    }

    /**
     *
     * @return total amount after discounts
     */
    public double getTotalAmountAfterDiscounts() {
        return couponDiscount > this.getTotalAmountAfterCampaign() ? 0 : this.getTotalAmountAfterCampaign() - couponDiscount;
    }

    public void print() {
        for(HashMap.Entry<Category, ArrayList<CartItem>> shoppingCart: cart.entrySet()) {
            Category category = shoppingCart.getKey();
            ArrayList<CartItem> cartItemList = shoppingCart.getValue();

            System.out.println("\n\n-------- Category: " + category.getTitle() + " --------");
            for (CartItem cartItem: cartItemList) {
                System.out.println("Product: " + cartItem.getProduct().getTitle());
                System.out.println("\t Quantity: " + cartItem.getQuantity());
                System.out.println("\t Unit Price: " + cartItem.getProduct().getPrice());
                System.out.println("\t Total Price: " + cartItem.getQuantity() * cartItem.getProduct().getPrice());
            }
        }

        System.out.println("\n\nTotal Amount: " + this.getTotalAmount());
        System.out.println("Total Applied Campaign: " + campaignDiscount);
        System.out.println("Total Amount After Campaign: " + (totalAmount - campaignDiscount));
        System.out.println("Total Applied Coupon: " + couponDiscount);
        System.out.println("Total Discount Amount: " + (couponDiscount +  campaignDiscount));
        System.out.println("Total Amount After Discounts: " + this.getTotalAmountAfterDiscounts());
        System.out.println("Delivery Cost: " + this.getDeliveryCost());
    }

    /**
     *
     * @param item;
     */
    private void calculateTotalAmount(CartItem item) {
        totalAmount += item.getQuantity() * item.getProduct().getPrice();
    }

    /**
     *
     * @return total amount after campaign
     */
    private double getTotalAmountAfterCampaign() {
        return campaignDiscount > totalAmount ? 0 : totalAmount - campaignDiscount;
    }

    /**
     *
     * @param categoryProductList;
     * @return item count
     */
    private int getCategoryItemCount(ArrayList<CartItem> categoryProductList) {
        int itemCount = 0;

        for (CartItem product: categoryProductList) {
            itemCount += product.getQuantity();
        }

        return itemCount;
    }

    /**
     *
     * @param category;
     * @return is category in chart
     */
    private boolean isCategoryInCart(Category category) {
        return cart.containsKey(category);
    }

    /**
     *
     * @param discountCategory;
     * @return is product parent category in campaign
     */
    private boolean isProductsParentCategoryInCampaign(Category discountCategory) {
        for (Category productsCategory: cart.keySet()) {
            if (
                    productsCategory.getParentCategory() != null &&
                    (productsCategory.getParentCategory()).equals(discountCategory)
            ) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param category;
     * @return category product list
     */
    private ArrayList<CartItem> getCategoryProductList(Category category) {
        ArrayList<CartItem> categoryProductList = new ArrayList<>();
        if (cart.containsKey(category)) {
            categoryProductList = cart.get(category);
        } else {
            for (Category productsCategory: cart.keySet()) {
                if (
                        productsCategory.getParentCategory() != null &&
                        (productsCategory.getParentCategory()).equals(category)
                ) {
                    categoryProductList = cart.get(productsCategory);
                }
            }
        }

        return categoryProductList;
    }

    /**
     *
     * @param productList;
     * @return items total amount;
     */
    private double getItemsTotalAmount(ArrayList<CartItem> productList) {
        double itemsTotalAmount = 0.0;

        for (CartItem cartItem : productList) {
            itemsTotalAmount += (cartItem.getProduct().getPrice() * cartItem.getQuantity());
        }

        return itemsTotalAmount;
    }
}

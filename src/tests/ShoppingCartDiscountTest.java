package tests;

import main.DiscountType.Amount;
import main.DiscountType.DiscountTypeInterface;
import main.DiscountType.Rate;
import main.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartDiscountTest {
    private Category food;
    private Category fruit;
    private Product apple;
    private Product banana;
    private ShoppingCart shoppingCart;
    private DiscountTypeInterface discountTypeRate;
    private DiscountTypeInterface discountTypeAmount;

    @BeforeEach
    public void setUp() {
        food = new Category("food");
        fruit = new Category("fruit", food);
        apple = new Product("apple", 10.0, fruit);
        banana = new Product("banana", 12.0, fruit);
        shoppingCart = new ShoppingCart();
        discountTypeRate = new Rate();
        discountTypeAmount = new Amount();
    }

    @AfterEach
    public void tearDown() {
        food = null;
        fruit = null;
        apple = null;
        banana = null;
        discountTypeRate = null;
        discountTypeAmount = null;
        shoppingCart = null;
    }

    @Test
    public void testRateDiscountApplied() {
        Campaign campaign = new Campaign(fruit, 10, 4, discountTypeRate);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(5.4, shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testAmountDiscountApplied() {
        Campaign campaign = new Campaign(fruit, 10, 4, discountTypeAmount);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(10, shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testRateDiscountNotApplied() {
        Campaign campaign = new Campaign(fruit, 10, 5, discountTypeRate);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(0, shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testAmountDiscountNotApplied() {
        Campaign campaign = new Campaign(fruit, 10, 5, discountTypeAmount);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(0, shoppingCart.getCampaignDiscount());
    }

    private void add3AppleAnd2BananaIntoCart() {
        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(banana, 2);
    }

    @Test
    public void testParentCategoryRateDiscountApplied() {
        Campaign campaign = new Campaign(food, 10, 4, discountTypeRate);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(5.4, shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testParentCategoryAmountDiscountApplied() {
        Campaign campaign = new Campaign(food, 10, 4, discountTypeAmount);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(10, shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testParentCategoryDiscountNotApplied() {
        Campaign campaign = new Campaign(food, 10, 5, discountTypeRate);

        this.add3AppleAnd2BananaIntoCart();
        shoppingCart.applyDiscounts(campaign);

        assertEquals(0, shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testBestDiscountApplied() {
        Category technology = new Category("technology");
        Product smartWatch = new Product("smartWatch", 200, technology);
        Product powerBank = new Product("powerBank", 50, technology);

        Campaign campaign1 = new Campaign(fruit, 30, 3, discountTypeRate);
        Campaign campaign2 = new Campaign(technology, 10, 5, discountTypeRate);

        shoppingCart.addItem(apple, 10);
        shoppingCart.addItem(banana, 10);
        shoppingCart.addItem(smartWatch, 2);
        shoppingCart.addItem(powerBank, 4);
        shoppingCart.applyDiscounts(campaign1, campaign2);

        assertEquals(66,shoppingCart.getCampaignDiscount());
    }

    @Test
    public void testRateCouponApplied() {
        Coupon coupon = new Coupon(100, 5, discountTypeRate);

        shoppingCart.addItem(apple, 10);
        shoppingCart.addItem(banana, 10);
        shoppingCart.applyCoupon(coupon);

        assertEquals(11, shoppingCart.getCouponDiscount());
    }

    @Test
    public void testAmountCouponApplied() {
        Coupon coupon = new Coupon(100, 32, discountTypeAmount);

        shoppingCart.addItem(apple, 10);
        shoppingCart.addItem(banana, 10);
        shoppingCart.applyCoupon(coupon);

        assertEquals(32, shoppingCart.getCouponDiscount());
    }

    @Test
    public void testCouponNotApplied() {
        Coupon coupon = new Coupon(100, 32, discountTypeAmount);

        shoppingCart.addItem(apple, 5);
        shoppingCart.addItem(banana, 4);
        shoppingCart.applyCoupon(coupon);

        assertEquals(0, shoppingCart.getCouponDiscount());
    }

    @Test
    public void testTotalAmountAfterCampaign() {
        Campaign campaign = new Campaign(fruit, 30, 3, discountTypeRate);

        shoppingCart.addItem(apple, 5);
        shoppingCart.addItem(banana, 8);
        shoppingCart.applyDiscounts(campaign);

        assertEquals(102.2, shoppingCart.getTotalAmountAfterDiscounts());
    }

    @Test
    public void testTotalAmountAfterCoupon() {
        Coupon coupon = new Coupon(100, 5, discountTypeAmount);

        shoppingCart.addItem(apple, 8);
        shoppingCart.addItem(banana, 5);
        shoppingCart.applyCoupon(coupon);

        assertEquals(135, shoppingCart.getTotalAmountAfterDiscounts());
    }

    @Test
    public void testTotalAmountAfterDiscount() {
        Coupon coupon = new Coupon(50, 5, discountTypeAmount);
        Campaign campaign = new Campaign(fruit, 30, 3, discountTypeRate);

        shoppingCart.addItem(apple, 5);
        shoppingCart.addItem(banana, 5);
        shoppingCart.applyDiscounts(campaign);
        shoppingCart.applyCoupon(coupon);

        assertEquals(72, shoppingCart.getTotalAmountAfterDiscounts());
    }
}
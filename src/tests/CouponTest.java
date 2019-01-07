package tests;

import main.DiscountType.Amount;
import main.DiscountType.DiscountTypeInterface;
import main.DiscountType.Rate;
import main.Coupon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {
    private static final double MIN_CART_AMOUNT = 10;
    private static final double AMOUNT = 10.0;
    private DiscountTypeInterface discountTypeRate;
    private DiscountTypeInterface discountTypeAmount;
    private Coupon coupon;

    @BeforeEach
    public void setUp() {
        discountTypeRate = new Rate();
        discountTypeAmount = new Amount();
        coupon = new Coupon(CouponTest.MIN_CART_AMOUNT, CouponTest.AMOUNT, discountTypeRate);

    }

    @AfterEach
    public void tearDown() {
        discountTypeRate = null;
        discountTypeAmount = null;
        coupon = null;
    }

    @Test
    public void testIsMinCartAmountCorrectWhenInitialize() {
        assertEquals(CouponTest.MIN_CART_AMOUNT, coupon.getMinCartAmount());
    }

    @Test
    public void testIsAmountCorrectWhenInitialize() {
        assertEquals(CouponTest.AMOUNT, coupon.getAmount());
    }

    @Test
    public void testIsDiscountTypeRateCorrectWhenInitialize() {
        assertEquals(discountTypeRate, coupon.getDiscountType());
    }

    @Test
    public void testIsDiscountTypeAmountCorrectWhenInitialize() {
        coupon = new Coupon(CouponTest.MIN_CART_AMOUNT, CouponTest.AMOUNT, discountTypeAmount);

        assertEquals(discountTypeAmount, coupon.getDiscountType());
    }
}
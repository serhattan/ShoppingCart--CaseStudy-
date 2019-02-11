package tests;

import main.discounttype.Amount;
import main.discounttype.DiscountTypeInterface;
import main.discounttype.Rate;
import main.Coupon;
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
    void setUp() {
        discountTypeRate = new Rate();
        discountTypeAmount = new Amount();
        coupon = new Coupon(CouponTest.MIN_CART_AMOUNT, CouponTest.AMOUNT, discountTypeRate);

    }

    @Test
    void testIsMinCartAmountCorrectWhenInitialize() {
        assertEquals(CouponTest.MIN_CART_AMOUNT, coupon.getMinCartAmount());
    }

    @Test
    void testIsAmountCorrectWhenInitialize() {
        assertEquals(CouponTest.AMOUNT, coupon.getAmount());
    }

    @Test
    void testIsDiscountTypeRateCorrectWhenInitialize() {
        assertEquals(discountTypeRate, coupon.getDiscountType());
    }

    @Test
    void testIsDiscountTypeAmountCorrectWhenInitialize() {
        coupon = new Coupon(CouponTest.MIN_CART_AMOUNT, CouponTest.AMOUNT, discountTypeAmount);

        assertEquals(discountTypeAmount, coupon.getDiscountType());
    }
}
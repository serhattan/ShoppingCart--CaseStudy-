package tests;

import main.discounttype.Amount;
import main.discounttype.DiscountTypeInterface;
import main.discounttype.Rate;
import main.Campaign;
import main.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignTest {
    private static final double AMOUNT = 10.0;
    private static final int PRODUCT_COUNT = 10;
    private Category food;
    private Campaign campaign;
    private DiscountTypeInterface discountTypeRate;
    private DiscountTypeInterface discountTypeAmount;

    @BeforeEach
    void setUp() {
        discountTypeRate = new Rate();
        discountTypeAmount = new Amount();
        food = new Category("food");
        campaign = new Campaign(food, CampaignTest.AMOUNT, CampaignTest.PRODUCT_COUNT, discountTypeRate);
    }

    @Test
    void testIsCategoryCorrectWhenInitialize() {
        assertEquals(food, campaign.getCategory());
    }

    @Test
    void testIsAmountCorrectWhenInitialize() {
        assertEquals(CampaignTest.AMOUNT, campaign.getAmount());
    }

    @Test
    void testIsProductCountCorrectWhenInitialize() {
        assertEquals(CampaignTest.PRODUCT_COUNT, campaign.getProductCount());
    }

    @Test
    void testIsDiscountTypeRateCorrectWhenInitialize() {
        assertEquals(discountTypeRate, campaign.getDiscountType());
    }

    @Test
    void testIsDiscountTypeAmountCorrectWhenInitialize() {
        campaign = new Campaign(food, CampaignTest.AMOUNT, CampaignTest.PRODUCT_COUNT, discountTypeAmount);

        assertEquals(discountTypeAmount, campaign.getDiscountType());
    }
}
package tests;

import main.DiscountType.Amount;
import main.DiscountType.DiscountTypeInterface;
import main.DiscountType.Rate;
import main.Campaign;
import main.Category;
import org.junit.jupiter.api.AfterEach;
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
    public void setUp() {
        discountTypeRate = new Rate();
        discountTypeAmount = new Amount();
        food = new Category("food");
        campaign = new Campaign(food, CampaignTest.AMOUNT, CampaignTest.PRODUCT_COUNT, discountTypeRate);
    }

    @AfterEach
    public void tearDown() {
        discountTypeRate = null;
        discountTypeAmount = null;
        food = null;
        campaign = null;
    }

    @Test
    public void testIsCategoryCorrectWhenInitialize() {
        assertEquals(food, campaign.getCategory());
    }

    @Test
    public void testIsAmountCorrectWhenInitialize() {
        assertEquals(CampaignTest.AMOUNT, campaign.getAmount());
    }

    @Test
    public void testIsProductCountCorrectWhenInitialize() {
        assertEquals(CampaignTest.PRODUCT_COUNT, campaign.getProductCount());
    }

    @Test
    public void testIsDiscountTypeRateCorrectWhenInitialize() {
        assertEquals(discountTypeRate, campaign.getDiscountType());
    }

    @Test
    public void testIsDiscountTypeAmountCorrectWhenInitialize() {
        campaign = new Campaign(food, CampaignTest.AMOUNT, CampaignTest.PRODUCT_COUNT, discountTypeAmount);

        assertEquals(discountTypeAmount, campaign.getDiscountType());
    }
}
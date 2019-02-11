package tests;

import main.Category;
import main.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private static final String PRODUCT_TITLE = "Apple";
    private static final double PRODUCT_PRICE = 10;
    private Category food;
    private Product apple;

    @BeforeEach
    void setUp() {
        food = new Category("food");
        apple = new Product(ProductTest.PRODUCT_TITLE, ProductTest.PRODUCT_PRICE, food);
    }

    @Test
    void testIsTitleCorrectWhenInitialize() {
        assertEquals(ProductTest.PRODUCT_TITLE, apple.getTitle());
    }

    @Test
    void testIsPriceCorrectWhenInitialize() {
        assertEquals(ProductTest.PRODUCT_PRICE, apple.getPrice());
    }

    @Test
    void testIsCategoryCorrectWhenInitialize() {
        assertEquals(food, apple.getCategory());
    }
}
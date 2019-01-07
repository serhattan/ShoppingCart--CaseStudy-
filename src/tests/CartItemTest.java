package tests;

import main.CartItem;
import main.Category;
import main.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {
    private static final int QUANTITY = 3;
    private Category food;
    private Product apple;
    private CartItem cartItem;
    private int quantity;

    @BeforeEach
    public void setUp() {
        quantity = CartItemTest.QUANTITY;
        food = new Category("food");
        apple = new Product("apple", 10.0, food);
        cartItem = new CartItem(apple, quantity);
    }

    @AfterEach
    public void tearDown() {
        food = null;
        apple = null;
    }

    @Test
    public void testIsProductCorrectWhenInitialize() {
        assertEquals(apple, cartItem.getProduct());
    }

    @Test
    public void testIsQuantityCorrectWhenInitialize() {
        assertEquals(quantity, cartItem.getQuantity());
    }
}
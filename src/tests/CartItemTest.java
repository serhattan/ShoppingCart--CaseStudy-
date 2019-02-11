package tests;

import main.CartItem;
import main.Category;
import main.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {
    private static final int QUANTITY = 3;
    private Product apple;
    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        Category food = new Category("food");
        apple = new Product("apple", 10.0, food);
        cartItem = new CartItem(apple, CartItemTest.QUANTITY);
    }

    @Test
    void testIsProductCorrectWhenInitialize() {
        assertEquals(apple, cartItem.getProduct());
    }

    @Test
    void testIsQuantityCorrectWhenInitialize() {
        assertEquals(CartItemTest.QUANTITY, cartItem.getQuantity());
    }
}
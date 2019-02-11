package tests;

import main.CartItem;
import main.Category;
import main.Product;
import main.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    private Product apple;
    private Product banana;
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        Category food = new Category("food");
        apple = new Product("apple", 10.0, food);
        banana = new Product("banana", 12.0, food);
        shoppingCart = new ShoppingCart();
    }

    @Test
    void testIsCartEmptyWhenInitialize() {
        assertEquals(0, shoppingCart.getCart().size());
    }

    @Test
    void testIsProductAdded() {
        shoppingCart.addItem(apple, 1);

        assertEquals(1, shoppingCart.getCart().size());
    }

    @Test
    void testIsProductQuantityCorrect() {
        shoppingCart.addItem(apple, 4);

        CartItem item = shoppingCart.getCart().get(apple.getCategory()).get(0);

        assertEquals(4, item.getQuantity());
    }

    private void addThreeAppleAndTwoBananaIntoCart() {
        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(banana, 2);
    }

    @Test
    void testIsCategorizationCorrect() {
        this.addThreeAppleAndTwoBananaIntoCart();
        assertEquals(1, shoppingCart.getCart().size());
    }

    @Test
    void testAddNewCategoryInCart() {
        Category technology = new Category("technology");
        Product phone = new Product("phone", 3000.0, technology);

        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(phone, 1);

        assertEquals(2, shoppingCart.getCart().size());
    }

    @Test
    void testAddExistProductAndCheckQuantity() {
        this.addThreeAppleAndTwoBananaIntoCart();
        shoppingCart.addItem(apple, 5);

        CartItem item = shoppingCart.getCart().get(apple.getCategory()).get(0);

        assertEquals(8, item.getQuantity());
    }

    @Test
    void testAddExistProductAndCheckCategorySize() {
        this.addThreeAppleAndTwoBananaIntoCart();
        shoppingCart.addItem(apple, 5);

        ArrayList<CartItem> categoryProductList = shoppingCart.getCart().get(apple.getCategory());

        assertEquals(2, categoryProductList.size());
    }
}
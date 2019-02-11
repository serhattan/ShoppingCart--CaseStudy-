package tests;

import main.Category;
import main.DeliveryCostCalculator;
import main.Product;
import main.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryCostCalculatorTest {
    private static final int COST_PER_DELIVERY = 5;
    private static final int COST_PER_PRODUCT = 7;
    private DeliveryCostCalculator deliveryCostCalculator;
    private Category food;
    private Product apple;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        deliveryCostCalculator = new DeliveryCostCalculator(
                DeliveryCostCalculatorTest.COST_PER_DELIVERY,
                DeliveryCostCalculatorTest.COST_PER_PRODUCT
        );

        food = new Category("food");
        apple = new Product("apple", 6.5, food);
        cart = new ShoppingCart();
    }

    @Test
    void testIsCostPerDeliveryCorrectWhenInitialize() {
        assertEquals(DeliveryCostCalculatorTest.COST_PER_DELIVERY, deliveryCostCalculator.getCostPerDelivery());
    }

    @Test
    void testIsCostPerProductCorrectWhenInitialize() {
        assertEquals(DeliveryCostCalculatorTest.COST_PER_PRODUCT, deliveryCostCalculator.getCostPerProduct());
    }

    @Test
    void testIsFixedCostCorrectWhenNotInitialize() {
        assertEquals(DeliveryCostCalculator.FIXED_COST, deliveryCostCalculator.getFixedCost());
    }

    @Test
    void testIsFixedCostCorrectWhenInitialize() {
        DeliveryCostCalculator deliveryCalculator = new DeliveryCostCalculator(
                DeliveryCostCalculatorTest.COST_PER_DELIVERY,
                DeliveryCostCalculatorTest.COST_PER_PRODUCT,
                2.99
        );

        assertEquals(2.99, deliveryCalculator.getFixedCost());
    }

    @Test
    void testDeliveryCostCalculateForEmptyCart() {
        deliveryCostCalculator.calculateFor(cart);
        assertEquals(deliveryCostCalculator.getFixedCost(), cart.getDeliveryCost());
    }

    @Test
    void testDeliveryCostCalculateForOneCategoryOneProduct() {
        cart.addItem(apple, 2);

        deliveryCostCalculator.calculateFor(cart);
        assertEquals(15.99, cart.getDeliveryCost());
    }

    @Test
    void testDeliveryCostCalculateForOneCategoryTwoProduct() {
        Product banana = new Product("banana", 12.0, food);

        cart.addItem(apple, 2);
        cart.addItem(banana, 1);

        deliveryCostCalculator.calculateFor(cart);

        assertEquals(22.990000000000002, cart.getDeliveryCost());
    }

    @Test
    void testDeliveryCostCalculateForTwoCategoryTwoProduct() {
        Category technology = new Category("technology");
        Product smartWatch = new Product("smartWatch", 1000.0, technology);

        cart.addItem(apple, 2);
        cart.addItem(smartWatch, 3);

        DeliveryCostCalculator deliveryCalculator = new DeliveryCostCalculator(
                DeliveryCostCalculatorTest.COST_PER_DELIVERY,
                DeliveryCostCalculatorTest.COST_PER_PRODUCT,
                1.99
        );
        deliveryCalculator.calculateFor(cart);

        assertEquals(25.99, cart.getDeliveryCost());
    }

    @Test
    void testDeliveryCostCalculateForTwoCategoryThreeProduct() {
        Category technology = new Category("technology");
        Product smartWatch = new Product("smartWatch", 1000.0, technology);
        Product macbook = new Product("macbook", 7000.0, technology);

        cart.addItem(apple, 2);
        cart.addItem(smartWatch, 4);
        cart.addItem(macbook, 3);

        DeliveryCostCalculator deliveryCalculator = new DeliveryCostCalculator(
                DeliveryCostCalculatorTest.COST_PER_DELIVERY,
                DeliveryCostCalculatorTest.COST_PER_PRODUCT,
                4.99
        );
        deliveryCalculator.calculateFor(cart);

        assertEquals(35.99, cart.getDeliveryCost());
    }
}
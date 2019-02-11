package main;

import main.discounttype.DiscountTypeInterface;
import main.discounttype.Rate;

public class Base {
    public static void main(String[] args) {
        Category food = new Category("food");
        Category technology = new Category("technology");
        Category motherBoard = new Category("electronic", technology);

        Category furniture = new Category("furniture");

        Product apple = new Product("Apple", 5.0, food);
        Product orange = new Product("Orange", 3.0, food);
        Product pear = new Product("Pear", 12.0, food);

        Product cable = new Product("Cable", 1.0, motherBoard);
        Product phone = new Product("Phone", 1200.0, motherBoard);

        Product chair = new Product("Chair", 500.0, furniture);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(orange, 21);
        cart.addItem(pear, 6);
        cart.addItem(cable, 33);
        cart.addItem(apple, 5);
        cart.addItem(phone, 4);
        cart.addItem(chair, 3);

        DiscountTypeInterface discountTypeRate = new Rate();
        Campaign campaign1 = new Campaign(food, 20.0, 3, discountTypeRate);
        Campaign campaign4 = new Campaign(technology, 22.0, 3, discountTypeRate);
        Campaign campaign5 = new Campaign(furniture, 20.0, 5, discountTypeRate);

        Coupon coupon = new Coupon(109.0, 50.0, discountTypeRate);

        cart.applyDiscounts(campaign5, campaign1, campaign4);
        cart.applyCoupon(coupon);

        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(6.0, 3.0, 9.99);
        deliveryCostCalculator.calculateFor(cart);

        cart.print();
    }
}

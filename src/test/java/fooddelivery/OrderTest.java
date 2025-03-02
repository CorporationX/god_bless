package fooddelivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order;
    Product burger;
    Product fries;

    @BeforeEach
    void setUp() {
        burger = new Product("Burger", 30.0);
        fries = new Product("Fries", 25.0);
        order = new Order(List.of(burger, fries));
    }

    @Nested
    class TotalPriceTests {
        @Test
        void totalPriceCalculation() {
            double expectedTotal = 30.0 + 25.0;
            assertEquals(expectedTotal, order.getTotalPrice());
        }

        @Test
        void orderWithEmptyProductListReturnsZeroTotal() {
            Order emptyOrder = new Order(List.of());
            assertEquals(0.0, emptyOrder.getTotalPrice());
        }
    }

    @Nested
    class DiscountTests {
        @Test
        void applyDiscountCalculatesDiscountedPrice() {
            double discountPercent = 10.0;
            order.applyDiscount(discountPercent);
            double expectedDiscounted = order.getTotalPrice() - (order.getTotalPrice() * discountPercent / 100.0);
            assertEquals(expectedDiscounted, order.getDiscountedPrice());
        }
    }
}

package fooddelivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    DeliveryService deliveryService;
    PromoCode promo10;
    PromoCode promo20;
    PromoCode promo15;

    @BeforeEach
    void setUp() {
        deliveryService = new DeliveryService();
        promo10 = new PromoCode("PROMO10", 10, LocalDateTime.now().plusDays(1), 50);
        promo20 = new PromoCode("PROMO20", 20, LocalDateTime.now().plusDays(1), 100);
        promo15 = new PromoCode("PROMO15", 15, LocalDateTime.now().plusDays(1), 75);
        deliveryService.addPromoCode(promo10);
        deliveryService.addPromoCode(promo20);
        deliveryService.addPromoCode(promo15);
    }

    @Nested
    class ProcessOrderTests {
        @Test
        void processOrderAppliesBestPromoCode() {
            Order order = new Order(List.of(new Product("Steak", 120)));
            deliveryService.processOrder(order, List.of("PROMO10", "PROMO20", "PROMO15"));
            double expectedDiscounted = 120 - (120 * 20 / 100.0);
            assertEquals(expectedDiscounted, order.getDiscountedPrice());
        }

        @Test
        void processOrderDoesNotApplyAnyPromoWhenNoneValid() {
            Order order = new Order(List.of(new Product("Fries", 20)));
            deliveryService.processOrder(order, List.of("PROMO10", "PROMO20", "PROMO15"));
            assertEquals(-1, order.getDiscountedPrice());
        }

        @Test
        void processOrderWithEmptyPromoCodeListAppliesNoDiscount() {
            Order order = new Order(List.of(new Product(
                    "Burger", 30), new Product("Fries", 25)));
            deliveryService.processOrder(order, List.of());
            assertEquals(-1, order.getDiscountedPrice());
        }

        @Test
        void processOrderEnsuresPromoCodeIsUsedOnlyOnce() {
            Order order1 = new Order(List.of(new Product("Pizza", 60)));
            Order order2 = new Order(List.of(new Product("Pizza", 60)));
            deliveryService.processOrder(order1, List.of("PROMO10"));
            deliveryService.processOrder(order2, List.of("PROMO10"));
            assertNotEquals(-1, order1.getDiscountedPrice());
            assertEquals(-1, order2.getDiscountedPrice());
        }
    }
}

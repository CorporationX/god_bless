package school.faang.sprint_4.task_51094;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryServiceTest {
    private DeliveryService deliveryService;
    ExecutorService executorService = Executors.newCachedThreadPool();
    PromoCode promo1;
    PromoCode promo2;
    PromoCode promo3;
    Product product1;
    Product product2;
    Product product3;

    @BeforeEach
    void setUp() {
        deliveryService = new DeliveryService();
        promo1 = new PromoCode(
                "DISCOUNT10",
                10,
                LocalDate.now().plusDays(1),
                BigDecimal.valueOf(100),
                false
        );
        promo2 = new PromoCode(
                "BIGSALE20",
                20,
                LocalDate.now().plusDays(1),
                BigDecimal.valueOf(150),
                false
        );
        promo3 = new PromoCode(
                "BIGSALE40",
                40,
                LocalDate.now().plusDays(1),
                BigDecimal.valueOf(150),
                false
        );
        deliveryService.addPromoCode(promo1);
        deliveryService.addPromoCode(promo2);
        deliveryService.addPromoCode(promo3);
        product1 = new Product("Burger", BigDecimal.valueOf(120));
        product2 = new Product("Fries", BigDecimal.valueOf(50));
        product3 = new Product("Pizza", BigDecimal.valueOf(200));
    }

    @Test
    void testProcessOrderBaseCase() {
        Order order = new Order(List.of(product1, product2));
        var expectedPromoCodesMap = Map.of(
                promo1.getCode(), promo1,
                promo2.getCode(), promo2
        );
        final var expectedProcessedOrders = List.of(order);
        final var promoCodesSet = Set.of(promo1.getCode(), promo2.getCode(), promo3.getCode());

        assertAll(
                () -> assertDoesNotThrow(() -> deliveryService.processOrder(order, promoCodesSet)),
                () -> assertEquals(BigDecimal.valueOf(102), order.getTotalPrice()),
                () -> assertEquals(expectedPromoCodesMap, deliveryService.getPromoCodes()),
                () -> assertEquals(expectedProcessedOrders, deliveryService.getProcessedOrders())
        );
    }

    @RepeatedTest(20)
    void testProcessOrderParallelProcessSomeOrders() {
        Order order1 = new Order(List.of(product1, product2));
        Order order2 = new Order(List.of(product1, product2));
        Order order3 = new Order(List.of(product1, product2));
        final var expectedPromoCodesMap = Map.of();
        final var promoCodesSet = Set.of(promo1.getCode(), promo2.getCode(), promo3.getCode());

        executorService.submit(() -> {
            try {
                deliveryService.processOrder(order1, promoCodesSet);
            } catch (OrderException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                deliveryService.processOrder(order2, promoCodesSet);
            } catch (OrderException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                deliveryService.processOrder(order3, promoCodesSet);
            } catch (OrderException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BigDecimal order1TotalPrice = order1.getTotalPrice();
        BigDecimal order2TotalPrice = order2.getTotalPrice();
        BigDecimal order3TotalPrice = order3.getTotalPrice();
        assertAll(
                () -> assertTrue(
                        order1TotalPrice.compareTo(order2TotalPrice) != 0
                                && order2TotalPrice.compareTo(order3TotalPrice) != 0
                                && order1TotalPrice.compareTo(order3TotalPrice) != 0
                ),
                () -> assertEquals(expectedPromoCodesMap, deliveryService.getPromoCodes()),
                () -> assertTrue(deliveryService.getProcessedOrders().contains(order1)),
                () -> assertTrue(deliveryService.getProcessedOrders().contains(order2)),
                () -> assertTrue(deliveryService.getProcessedOrders().contains(order3))
        );

    }

    @Test
    void testProcessOrderNotValidPromoCodes() {
        Order order = new Order(List.of(product1, product2));
        final var expectedPromoCodesMap = Map.of(
                promo1.getCode(), promo1,
                promo2.getCode(), promo2,
                promo3.getCode(), promo3
        );
        final var expectedProcessedOrders = List.of();

        assertAll(
                () -> assertEquals(order.getPrice(), order.getTotalPrice()),
                () -> assertFalse(order.isDiscountApplied()),
                () -> assertEquals(expectedPromoCodesMap, deliveryService.getPromoCodes()),
                () -> assertEquals(expectedProcessedOrders, deliveryService.getProcessedOrders()),
                () -> assertThrows(IllegalArgumentException.class, () ->
                        deliveryService.processOrder(order, Set.of("a", "b", "c"))
                )
        );
    }

    @Test
    void testProcessOrderWithNoPromoCodes() {
        Order order = new Order(List.of(product1, product2));
        final var expectedPromoCodesMap = Map.of(
                promo1.getCode(), promo1,
                promo2.getCode(), promo2,
                promo3.getCode(), promo3
        );
        final var expectedProcessedOrders = List.of(order);

        assertAll(
                () -> assertDoesNotThrow(() -> deliveryService.processOrder(order)),
                () -> assertEquals(order.getPrice(), order.getTotalPrice()),
                () -> assertFalse(order.isDiscountApplied()),
                () -> assertEquals(expectedPromoCodesMap, deliveryService.getPromoCodes()),
                () -> assertEquals(expectedProcessedOrders, deliveryService.getProcessedOrders())
        );
    }
}

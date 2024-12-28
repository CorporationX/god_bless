package school.faang.sprint_4.task_51094;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    Product product1;
    Product product2;
    Product product3;

    public OrderTest() {
        product1 = new Product("Burger", BigDecimal.valueOf(120));
        product2 = new Product("Fries", BigDecimal.valueOf(50));
        product3 = new Product("Pizza", BigDecimal.valueOf(200));
    }

    @Test
    void testApplyDiscountBaseCase() {
        final Order order = new Order(List.of(product1, product2, product3));
        try {
            order.applyDiscount(10);
        } catch (OrderException e) {
            throw new RuntimeException(e);
        }
        assertAll(
                () -> assertEquals(BigDecimal.valueOf(333), order.getTotalPrice()),
                () -> assertEquals(List.of(product1, product2, product3), order.getProducts()),
                () -> assertTrue(order.isDiscountApplied())
        );
    }

    @Test
    void testApplyDiscountApplyDiscountAgain() {
        final Order order = new Order(List.of(product1, product2, product3));
        try {
            order.applyDiscount(10);
        } catch (OrderException e) {
            throw new RuntimeException(e);
        }
        assertAll(
                () -> assertThrows(OrderException.class, () -> order.applyDiscount(10)),
                () -> assertEquals(BigDecimal.valueOf(333), order.getTotalPrice()),
                () -> assertEquals(List.of(product1, product2, product3), order.getProducts()),
                () -> assertTrue(order.isDiscountApplied())
        );
    }

    @Test
    void testApplyDiscountWithNegativeDiscount() {
        final Order order = new Order(List.of(product1, product2, product3));

        assertAll(
                () -> assertThrows(OrderException.class, () -> order.applyDiscount(-3)),
                () -> assertEquals(BigDecimal.valueOf(370), order.getTotalPrice()),
                () -> assertEquals(List.of(product1, product2, product3), order.getProducts()),
                () -> assertFalse(order.isDiscountApplied())
        );
    }

    @Test
    void testApplyDiscountWithBigDiscount() {
        final Order order = new Order(List.of(product1, product2, product3));

        assertAll(
                () -> assertThrows(OrderException.class, () -> order.applyDiscount(124)),
                () -> assertEquals(BigDecimal.valueOf(370), order.getTotalPrice()),
                () -> assertEquals(List.of(product1, product2, product3), order.getProducts()),
                () -> assertFalse(order.isDiscountApplied())
        );
    }
}

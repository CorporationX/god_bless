package fooddelivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PromoCodeTest {

    PromoCode validPromo;
    Order validOrder;

    @BeforeEach
    void setUp() {
        validPromo = new PromoCode("TEST10", 10, LocalDateTime.now().plusDays(1), 50);
        validOrder = new Order(List.of(new Product("Pizza", 60)));
    }

    @Nested
    class ValidityTests {
        @Test
        void isValidForOrderReturnsTrueForValidPromo() {
            assertTrue(validPromo.isValidForOrder(validOrder));
        }

        @Test
        void isValidForOrderReturnsFalseIfOrderTotalBelowMinimum() {
            Order lowValueOrder = new Order(List.of(new Product("Soda", 30)));
            assertFalse(validPromo.isValidForOrder(lowValueOrder));
        }

        @Test
        void isValidForOrderReturnsFalseIfPromoExpired() {
            PromoCode expiredPromo = new PromoCode(
                    "EXPIRED", 15, LocalDateTime.now().minusDays(1), 20);
            Order order = new Order(List.of(new Product("Sandwich", 25)));
            assertFalse(expiredPromo.isValidForOrder(order));
        }

        @Test
        void isValidForOrderReturnsFalseIfPromoAlreadyUsed() {
            validPromo.markAsUsed();
            assertFalse(validPromo.isValidForOrder(validOrder));
        }
    }

    @Nested
    class MarkAsUsedTests {
        @Test
        void markAsUsedThrowsExceptionWhenCalledTwice() {
            validPromo.markAsUsed();
            IllegalStateException exception = assertThrows(IllegalStateException.class, validPromo::markAsUsed);
            assertTrue(exception.getMessage().contains("has already been used"));
        }
    }
}

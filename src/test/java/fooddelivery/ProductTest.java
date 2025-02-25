package fooddelivery;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Nested
    class ProductCreationTests {
        @Test
        void productCreationAndGetters() {
            Product product = new Product("Burger", 30.0);
            assertEquals("Burger", product.getName());
            assertEquals(30.0, product.getPrice());
        }
    }
}

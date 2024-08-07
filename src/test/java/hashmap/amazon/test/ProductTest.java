package hashmap.amazon.test;

import hashmap.amazon.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    @DisplayName("Create product with null arguments")
    void productTest_createProductWithNullArguments() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> new Product(1, null, "test")),
                () -> assertThrows(NullPointerException.class, () -> new Product(2, "test", null))
        );
    }
}

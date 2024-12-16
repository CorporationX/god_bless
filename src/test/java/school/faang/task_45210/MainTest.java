package school.faang.task_45210;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("groupProductsByCategory: should group products by category")
    void groupProductsByCategory_shouldGroupProductsByCategory() {
        // Arrange
        Set<Product> products = new HashSet<>();
        products.add(new Product("Tablet", "Electronics"));
        products.add(new Product("Smartphone", "Electronics"));
        products.add(new Product("Sofa", "Furniture"));
        products.add(new Product("Chair", "Furniture"));

        // Act
        Map<String, List<Product>> grouped = Main.groupProductsByCategory(products);

        // Assert
        assertAll("Grouped by category",
                () -> assertTrue(grouped.containsKey("Electronics"), "Should contain Electronics category"),
                () -> assertTrue(grouped.containsKey("Furniture"), "Should contain Furniture category"),
                () -> assertEquals(2, grouped.get("Electronics").size(), "Electronics should contain 2 products"),
                () -> assertEquals(2, grouped.get("Furniture").size(), "Furniture should contain 2 products")
        );
    }

    @Test
    @DisplayName("groupProductsByCategory: should throw exception when no products available")
    void groupProductsByCategory_shouldThrowException_whenNoProducts() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Main.groupProductsByCategory(new HashSet<>()));

        assertEquals("Product list is null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("groupProductsByCategory: should handle products in one category")
    void groupProductsByCategory_shouldHandleOneCategory() {
        // Arrange
        Set<Product> products = new HashSet<>();
        products.add(new Product("Smartphone", "Electronics"));
        products.add(new Product("Tablet", "Electronics"));

        // Act
        Map<String, List<Product>> grouped = Main.groupProductsByCategory(products);

        // Assert
        assertTrue(grouped.containsKey("Electronics"), "Should contain Electronics category");
        assertEquals(2, grouped.get("Electronics").size(), "Electronics should contain 2 products");
    }

    @Test
    @DisplayName("groupProductsByCategory: should handle single product")
    void groupProductsByCategory_shouldHandleSingleProduct() {
        // Arrange
        Set<Product> products = new HashSet<>();
        products.add(new Product("Smartphone", "Electronics"));

        // Act
        Map<String, List<Product>> grouped = Main.groupProductsByCategory(products);

        // Assert
        assertTrue(grouped.containsKey("Electronics"), "Should contain Electronics category");
        assertEquals(1, grouped.get("Electronics").size(), "Electronics should contain 1 product");
    }

    @Test
    @DisplayName("groupProductsByCategory: should throw exception when null products")
    void groupProductsByCategory_shouldThrowException_whenNullProducts() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Main.groupProductsByCategory(null));

        assertEquals("Product list is null or empty", exception.getMessage());
    }
}
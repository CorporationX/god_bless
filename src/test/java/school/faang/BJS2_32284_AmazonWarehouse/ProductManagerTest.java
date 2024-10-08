package school.faang.BJS2_32284_AmazonWarehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager;
    private Set<Product> products;
    private Product laptop;
    private Product smartphone;
    private Product chair;

    @BeforeEach
    void setUp() {
        manager = new ProductManager();
        products = new HashSet<>();
        laptop = new Product(1, "Laptop", "Electronics");
        smartphone = new Product(2, "Smartphone", "Electronics");
        chair = new Product(3, "Chair", "Furniture");
    }

    @Test
    @DisplayName("Getting products grouped by categories with valid products set")
    void testGetProductsByCategoryValidSet() {
        products.add(laptop);
        products.add(smartphone);
        products.add(chair);

        Map<String, List<Product>> productsByCategory = manager.getProductsByCategory(products);

        assertEquals(2, productsByCategory.size());
        assertEquals(2, productsByCategory.get("Electronics").size());
        assertEquals(1, productsByCategory.get("Furniture").size());
    }

    @Test
    @DisplayName("Getting products grouped by categories with empty products set")
    void testGetProductsByCategoryEmptySet() {
        Map<String, List<Product>> productsByCategory = manager.getProductsByCategory(products);

        assertEquals(0, productsByCategory.size());
    }

    @Test
    @DisplayName("Getting products grouped by categories with null products set")
    void testGetProductsByCategoryNullSet() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> manager.getProductsByCategory(null));
        assertEquals("Products set can't be null.", exception.getMessage());
    }

    @Test
    @DisplayName("Printing products grouped by categories with null productsByCategory")
    void testPrintProductsByCategory() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> manager.printProductsByCategory(null));
        assertEquals("productsByCategories can't be null.", exception.getMessage());
    }
}
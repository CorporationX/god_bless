package school.faang.task_45210;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductManagerTest {
    private ProductManager productManager;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager();
    }

    @Test
    @DisplayName("addItem: should add product successfully")
    void addItem_shouldAddProductSuccessfully() {
        // Act
        Product product = productManager.addItem("Electronics", "Smartphone");

        // Assert
        assertNotNull(product, "Product should not be null");
        assertEquals("Smartphone", product.getName(), "Product name should match");
    }

    @Test
    @DisplayName("addItem: should throw exception when category is blank")
    void addItem_shouldThrowException_whenCategoryIsBlank() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productManager.addItem("", "New Product"));

        assertEquals("Category cannot be null or blank.", exception.getMessage());
    }

    @Test
    @DisplayName("addItem: should throw exception when product name is blank")
    void addItem_shouldThrowException_whenProductNameIsBlank() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productManager.addItem("Electronics", ""));

        assertEquals("Product name cannot be null or blank.", exception.getMessage());
    }

    @Test
    @DisplayName("addItem: should throw exception when product already exists in category")
    void addItem_shouldThrowException_whenProductAlreadyExists() {
        // Arrange
        productManager.addItem("Electronics", "Smartphone");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productManager.addItem("Electronics", "Smartphone"));

        assertEquals("Product 'Smartphone' already exists in category 'Electronics'.", exception.getMessage());
    }

    @Test
    @DisplayName("removeItem: should remove product successfully")
    void removeItem_shouldRemoveProductSuccessfully() {
        // Arrange
        productManager.addItem("Electronics", "Smartphone");

        // Act
        boolean removed = productManager.removeItem("Electronics", "Smartphone");

        // Assert
        assertTrue(removed, "Product should be removed");
    }

    @Test
    @DisplayName("removeItem: should throw exception when product not found")
    void removeItem_shouldThrowException_whenProductNotFound() {
        // Arrange
        productManager.addItem("Electronics", "Smartphone");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productManager.removeItem("Electronics", "NonExistingProduct"));

        assertEquals("Product not found in category 'Electronics'.", exception.getMessage());
    }

    @Test
    @DisplayName("removeItem: should remove category when all products are deleted")
    void removeItem_shouldRemoveCategory_whenAllProductsDeleted() {
        // Arrange
        productManager.addItem("Electronics", "Smartwatch");
        productManager.addItem("Electronics", "Tablet");

        // Act
        productManager.removeItem("Electronics", "Smartwatch");
        productManager.removeItem("Electronics", "Tablet");

        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productManager.findItemsByCategory("Electronics"));
        assertEquals("Category not found", exception.getMessage());
    }

    @Test
    @DisplayName("findItemsByCategory: should throw exception when category not found")
    void findItemsByCategory_shouldThrowException_whenCategoryNotFound() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productManager.findItemsByCategory("NonExistingCategory"));

        assertEquals("Category not found", exception.getMessage());
    }

    @Test
    @DisplayName("findItemsByCategory: should find products by category")
    void findItemsByCategory_shouldFindProductsByCategory() {
        // Arrange
        productManager.addItem("Electronics", "Smartphone");
        productManager.addItem("Electronics", "Laptop");

        // Act
        List<Product> products = productManager.findItemsByCategory("Electronics");

        // Assert
        assertEquals(2, products.size(), "There should be 2 products in Electronics");
    }

    @Test
    @DisplayName("groupProductsByCategory: should group products correctly")
    void groupProductsByCategory_shouldGroupProductsCorrectly() {
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
                () -> assertEquals(2, grouped.get("Electronics").size(), "Electronics should contain 2 products")
        );
    }

    @Test
    @DisplayName("groupProductsByCategory: should throw exception when no products are available")
    void groupProductsByCategory_shouldThrowException_whenNoProducts() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Main.groupProductsByCategory(new HashSet<>()));

        assertEquals("No products found", exception.getMessage());
    }

    @Test
    @DisplayName("addItem: should handle adding a large number of products")
    void addItem_shouldHandleLargeNumberOfProducts() {
        // Arrange
        for (int i = 0; i < 1000; i++) {
            productManager.addItem("Electronics", "Product " + i);
        }

        // Act
        List<Product> products = productManager.findItemsByCategory("Electronics");

        // Assert
        assertEquals(1000, products.size(), "There should be 1000 products in the category");
    }
}
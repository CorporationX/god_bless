package school.faang.sprint_1.task_45180;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testAddItem() {
        productService.addItem("Электроника", "Наушники");
        List<Product> electronics = productService.findItemsByCategory("Электроника");
        assertEquals(1, electronics.size());
        assertEquals("Наушники", electronics.get(0).getName());
    }

    @Test
    void testRemoveItem() {
        productService.addItem("Электроника", "Наушники");
        productService.removeItem("Электроника", "Наушники");
        List<Product> electronics = productService.findItemsByCategory("Электроника");
        assertTrue(electronics.isEmpty());
    }

    @Test
    void testFindItemsByCategory() {
        productService.addItem("Электроника", "Ноутбук");
        productService.addItem("Электроника", "Наушники");
        List<Product> electronics = productService.findItemsByCategory("Электроника");
        assertEquals(2, electronics.size());
    }

    @Test
    void testGroupProductsByCategory() {
        productService.addItem("Электроника", "Smartphone");
        productService.addItem("Музыкальные инструменты", "Гитара");

        Map<String, List<Product>> groupedProducts = productService.groupProductsByCategory();

        assertEquals(2, groupedProducts.size());
        assertTrue(groupedProducts.containsKey("Электроника"));
        assertTrue(groupedProducts.containsKey("Музыкальные инструменты"));
        assertEquals(1, groupedProducts.get("Электроника").size());
        assertEquals(1, groupedProducts.get("Музыкальные инструменты").size());
    }

    @Test
    void testPrintAllItems() {
        productService.addItem("Электроника", "Ноутбук");
        productService.addItem("Музыкальные инструменты", "Гитара");

        productService.printAllItems();
    }
}

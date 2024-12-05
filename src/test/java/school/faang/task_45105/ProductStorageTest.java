package school.faang.task_45105;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductStorageTest {

    private ProductStorage productStorage;

    @BeforeEach
    void setUp() {
        productStorage = new ProductStorage();
    }

    @Test
    void findItemsByCategory() {
        String inputCategory = "Meat";
        String inputNameFirst = "Pork";
        String inputNameSecond = "Chicken";

        productStorage.addItem(inputCategory, inputNameFirst);
        productStorage.addItem(inputCategory, inputNameSecond);

        List<Product> result = productStorage.findItemsByCategory(inputCategory);

        assertEquals(2, result.size());
        assertTrue(result.stream()
                .anyMatch(product -> product.getName().equals(inputNameFirst)));
        assertTrue(result.stream()
                .anyMatch(product -> product.getName().equals(inputNameSecond)));
    }

    @Test
    void findItemsByNullCategory() {
        String inputCategory = null;

        List<Product> result = productStorage.findItemsByCategory(inputCategory);

        assertEquals(0, result.size());
    }

    @Test
    void groupProductsByCategory() {
        String inputCategory = "Meat";
        String inputNameFirst = "Pork";
        String inputNameSecond = "Chicken";

        productStorage.addItem(inputCategory, inputNameFirst);
        productStorage.addItem(inputCategory, inputNameSecond);

        Map<String, List<Product>> groupedProductsByCategory = ProductStorage
                .groupProductsByCategory(productStorage.getProducts());

        assertEquals(1, groupedProductsByCategory.size());
        assertEquals(2, groupedProductsByCategory.get(inputCategory).size());
    }
}
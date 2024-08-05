import hashmap.amazon.Main;
import hashmap.amazon.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryMapTest {
    private Set<Product> productSet;
    private Map<String, List<Product>> categoryMap;

    @BeforeEach
    void setUp() {
        productSet = new HashSet<>();
        categoryMap = new HashMap<>();
        Product product1 = new Product(1, "smartphone", "electronics");
        Product product2 = new Product(2, "t-shirt", "clothes");
        Product product3 = new Product(3, "smart tv", "electronics");
        Product product4 = new Product(4, "hat", "clothes");
        Product product5 = new Product(5, "aspirin", "medicine");
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        productSet.add(product5);
    }
    @Test
    @DisplayName("Test createCategoryMap method with valid arguments")
    void categoryMapTest_createMap() {
        categoryMap = Main.createCategoryMap(productSet);

        assertEquals(3, categoryMap.size());
    }

    @Test
    @DisplayName("Test createCategoryMap method with empty set")
    void categoryMapTest_createMapWithEmptySet() {
        categoryMap = Main.createCategoryMap(new HashSet<>());

        assertTrue(categoryMap.isEmpty());
    }

    @Test
    @DisplayName("Test createCategoryMap method with null set")
    void categoryMapTest_createMapWithNullSet() {
        assertThrows(NullPointerException.class, () -> Main.createCategoryMap(null));
    }

    @Test
    @DisplayName("Test printCategoryMap method with null arguments")
    void categoryMapTest_printCategoryMapWithNullArguments() {
        assertThrows(NullPointerException.class, () -> Main.printCategoryMap(null));
    }
}

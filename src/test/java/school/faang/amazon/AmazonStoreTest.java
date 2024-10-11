package school.faang.amazon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AmazonStoreTest {

    private AmazonStore amazonStore;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @BeforeEach
    public void setUp() {
        amazonStore = new AmazonStore();

        product1 = new Product(1, "Product1", "Category1");
        product2 = new Product(2, "Product2", "Category2");
        product3 = new Product(3, "Product3", "Category1");
        product4 = new Product(4, "Product4", "Category3");
    }

    @Test
    public void groupProductsTest() {
        Set<Product> products = new HashSet<>(Arrays.asList(product1, product2, product3, product4));

        Map<String, List<Product>> grouped = amazonStore.groupProducts(products);

        assertEquals(3, grouped.size());
        assertEquals(2, grouped.get("Category1").size());
        assertTrue(grouped.get("Category1").contains(product1));
        assertTrue(grouped.get("Category1").contains(product3));
    }

    @Test
    public void printAllGroupProductsTest() {
        Set<Product> products = new HashSet<>(Arrays.asList(product1, product2, product3, product4));
        amazonStore.printAllGroupProducts(products);
    }
}

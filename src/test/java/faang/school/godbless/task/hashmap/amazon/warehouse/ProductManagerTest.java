package faang.school.godbless.task.hashmap.amazon.warehouse;

import faang.school.godbless.task.hashmap.amazon.warehouse.Product;
import faang.school.godbless.task.hashmap.amazon.warehouse.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    Product product1 = new Product(1, "Laptop", "Electronics");
    Product product2 = new Product(2, "Smartphone", "Electronics");
    Product product3 = new Product(3, "Headphones", "Electronics");
    Product product4 = new Product(4, "TV", "Electronics");
    Product product5 = new Product(5, "Sofa", "Furniture");
    Product product6 = new Product(6, "Chair", "Furniture");
    Product product7 = new Product(7, "Table", "Furniture");
    Product product8 = new Product(8, "Jeans", "Clothing");
    Product product9 = new Product(9, "T-Shirt", "Clothing");
    Product product10 = new Product(10, "Jacket", "Clothing");

    ProductManager productManager;
    Set<Product> productSet;
    Map<String, List<Product>> expectedMap;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager(new HashSet<>());
        productSet = new HashSet<>(Set.of(product1, product2, product3, product4, product5,
                product6, product7, product8, product9, product10
        ));
        expectedMap = new HashMap<>();
        productSet.forEach(product -> expectedMap.computeIfAbsent(product.category(), k ->
                new ArrayList<>()).add(product));
    }

    @Test
    void testGroupingByCategory() {
        assertEquals(expectedMap, productManager.groupingByCategory(productSet));
    }

    @Test
    void testPrintProductsByCategory() {
        productManager.setProductSet(productSet);
        productManager.printProductsByCategory();
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_43518.Product;
import school.faang.task_43518.ProductManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager productManager;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager(new HashSet<>());
    }

    @Test
    void testAddItem() {
        String productName = "Apple iPhone 14";
        String productCategory = "Electronics";

        productManager.addItem(productCategory, productName);

        Map<String, List<Product>> productsMap = productManager.getProductsMap();
        List<Product> products = productsMap.get(productCategory);

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals(productName, products.get(0).getName());
        assertEquals(productCategory, products.get(0).getCategory());
    }

    @Test
    void testRemoveItem() {
        String productName = "Apple iPhone 14";
        String productCategory = "Electronics";

        productManager.addItem(productCategory, productName);
        productManager.removeItem(productCategory, productName);

        Map<String, List<Product>> productsMap = productManager.getProductsMap();
        List<Product> products = productsMap.get(productCategory);

        assertNotNull(products);
        assertTrue(products.isEmpty());
    }

    @Test
    void testFindItemsByCategory() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String productName = "Apple iPhone 14";
        String productCategory = "Electronics";


        productManager.addItem(productCategory, productName);
        productManager.findItemsByCategory(productCategory);

        String output = outputStream.toString().trim();
        assertTrue(output.contains(productCategory + ": "));
        assertTrue(output.contains("   " + productName));

        System.setOut(originalOut);
    }

    @Test
    void testPrintAllItems() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String productName = "Apple iPhone 14";
        String productCategory = "Electronics";

        productManager.addItem(productCategory, productName);
        productManager.printAllItems();

        String output = outputStream.toString().trim();
        assertTrue(output.contains(productName));

        System.setOut(originalOut);
    }

    @Test
    void testGroupProductsByCategory() {
        String category1 = "Electronics";
        String category2 = "Furniture";
        Set<Product> products = new HashSet<>();
        products.add(new Product("Apple iPhone 14", category1));
        products.add(new Product("Samsung Galaxy S23", category1));
        products.add(new Product("Herman Miller Aeron Chair", category2));

        Map<String, List<Product>> gropedProducts = productManager
                .groupProductsByCategory(products);

        assertEquals(2, gropedProducts.size());
        assertTrue(gropedProducts.containsKey(category1));
        assertTrue(gropedProducts.containsKey(category2));
        assertEquals(2, gropedProducts.get(category1).size());
        assertEquals(1, gropedProducts.get(category2).size());
    }

    @Test
    void printProductsByCategory() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String category1 = "Electronics";
        String category2 = "Furniture";
        Product product1 = new Product("Apple iPhone 14", category1);
        Product product2 = new Product("Samsung Galaxy S23", category1);
        Product product3 = new Product("Herman Miller Aeron Chair", category2);
        Map<String, List<Product>> productsMap = new HashMap<>();
        productsMap.put(category1, Arrays.asList(product1, product2));
        productsMap.put(category2, List.of(product3));

        productManager.printProductsByCategory(productsMap);

        String output = outputStream.toString().trim();
        assertTrue(output.contains(category1 + ": "));
        assertTrue(output.contains("   " + product1));
        assertTrue(output.contains("   " + product2));
        assertTrue(output.contains(category2 + ": "));
        assertTrue(output.contains("   " + product3));

        System.setOut(originalOut);
    }
}
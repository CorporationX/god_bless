import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_43518.Category;
import school.faang.task_43518.Product;
import school.faang.task_43518.ProductManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductManagerTest {
    private ProductManager productManager;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager();
    }

    @Test
    void testAddItem() {
        String productName = "Apple iPhone 14";
        Category productCategory = Category.ELECTRONICS;

        productManager.addItem(productCategory, productName);

        Map<Category, List<Product>> productsMap = productManager.getProductsMap();
        List<Product> products = productsMap.get(productCategory);

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals(productName, products.get(0).getName());
        assertEquals(productCategory, products.get(0).getCategory());
    }

    @Test
    void testRemoveItem() {
        String productName = "Apple iPhone 14";
        Category productCategory = Category.ELECTRONICS;

        productManager.addItem(productCategory, productName);
        productManager.removeItem(productCategory, productName);

        Map<Category, List<Product>> productsMap = productManager.getProductsMap();
        List<Product> products = productsMap.get(productCategory);

        assertNotNull(products);
        assertTrue(products.isEmpty());
    }

    @Test
    void testFindItemsByCategory() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String productName = "Apple iPhone 14";
        Category productCategory = Category.ELECTRONICS;


        productManager.addItem(productCategory, productName);
        productManager.findItemsByCategory(productCategory);

        String actualOutput = outputStream.toString().trim();
        String expectedOutput = String.format("%s: \n\t%s", productCategory, productName);
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }

    @Test
    void testPrintAllItems() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String productName = "Apple iPhone 14";
        Category productCategory = Category.ELECTRONICS;

        productManager.addItem(productCategory, productName);
        productManager.printAllItems();

        String actualOutput = outputStream.toString().trim();
        String expectedOutput = String.format("%s: \n\t%s", productCategory, productName);
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }

    @Test
    void testGroupProductsByCategory() {
        Category category1 = Category.ELECTRONICS;
        Category category2 = Category.FURNITURE;
        Product product1 = new Product("Apple iPhone 14", category1);
        Product product2 = new Product("Samsung Galaxy S23", category1);
        Product product3 = new Product("Herman Miller Aeron Chair", category2);
        Set<Product> products = Set.of(product1, product2, product3);

        Map<Category, List<Product>> gropedProducts = productManager
                .groupProductsByCategory(products);

        assertEquals(2, gropedProducts.size());
        assertTrue(gropedProducts.containsKey(category1));
        assertTrue(gropedProducts.containsKey(category2));
        assertTrue(gropedProducts.get(category1).get(0).equals(product1)
                || gropedProducts.get(category1).get(1).equals(product1));
        assertEquals(product3, gropedProducts.get(category2).get(0));
    }

    @Test
    void printProductsByCategory() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Category category1 = Category.ELECTRONICS;
        Category category2 = Category.FURNITURE;
        Product product1 = new Product("Apple iPhone 14", category1);
        Product product2 = new Product("Samsung Galaxy S23", category1);
        Product product3 = new Product("Herman Miller Aeron Chair", category2);
        Map<Category, List<Product>> productsMap = new HashMap<>();
        productsMap.put(category1, Arrays.asList(product1, product2));
        productsMap.put(category2, List.of(product3));

        productManager.printProductsByCategory(productsMap);

        String actualOutput = outputStream.toString().trim();
        String expectedOutput = String.format("%s: %n\t%s%n\t%s%n%s: %n\t%s",
                category1, product1, product2, category2, product3).trim();

        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }
}
package faang.school.godbless.javahashmap.amazone;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StoreTest {

    private static final String ELECTRONICS_CATEGORY = "Electronics";
    private static final String STATIONERY_CATEGORY = "Stationery";
    private static final String BOOKS_CATEGORY = "Books";
    private static final Product LAPTOP = new Product(1, "Laptop", ELECTRONICS_CATEGORY);
    private static final Product PHONE = new Product(2, "Phone", ELECTRONICS_CATEGORY);
    private static final Product MOUSE = new Product(3, "Mouse", ELECTRONICS_CATEGORY);
    private static final Product PEN = new Product(4, "Pen", STATIONERY_CATEGORY);
    private static final Product BOOK = new Product(5, "Book", BOOKS_CATEGORY);
    private static final Product MAGAZINE = new Product(6, "Magazine", BOOKS_CATEGORY);

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final String ALL_PRODUCTS_INFO = """
            Category: Electronics\r
                id: 3, name: Mouse\r
                id: 2, name: Phone\r
                id: 1, name: Laptop\r
            Category: Stationery\r
                id: 4, name: Pen\r
            Category: Books\r
                id: 6, name: Magazine\r
                id: 5, name: Book\r
            """;

    @Test
    void testGroupProductsByCategory() {
        Set<Product> products = new HashSet<>();
        products.add(LAPTOP);
        products.add(PHONE);
        products.add(MOUSE);
        products.add(PEN);
        products.add(BOOK);
        products.add(MAGAZINE);
        Store store = new Store();

        Map<String, List<Product>> groupedProducts = store.groupProductsByCategory(products);

        assertEquals(3, groupedProducts.size());

        List<Product> productsOfElectronics = groupedProducts.get(ELECTRONICS_CATEGORY);
        assertEquals(3, productsOfElectronics.size());
        assertTrue(productsOfElectronics.contains(LAPTOP));
        assertTrue(productsOfElectronics.contains(PHONE));
        assertTrue(productsOfElectronics.contains(MOUSE));

        List<Product> productsOfStationery = groupedProducts.get(STATIONERY_CATEGORY);
        assertEquals(1, productsOfStationery.size());
        assertTrue(productsOfStationery.contains(PEN));

        List<Product> productsOfBooks = groupedProducts.get(BOOKS_CATEGORY);
        assertEquals(2, productsOfBooks.size());
        assertTrue(productsOfBooks.contains(BOOK));
        assertTrue(productsOfBooks.contains(MAGAZINE));
    }

    @Test
    void testPrintGroupedByCategoryProducts() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        Set<Product> products = new HashSet<>();
        products.add(LAPTOP);
        products.add(PHONE);
        products.add(MOUSE);
        products.add(PEN);
        products.add(BOOK);
        products.add(MAGAZINE);
        Store store = new Store();

        Map<String, List<Product>> groupedProducts = store.groupProductsByCategory(products);
        store.printGroupedByCategoryProducts(groupedProducts);

        assertEquals(ALL_PRODUCTS_INFO, outContent.toString());
        System.setOut(originalOut);
    }
}
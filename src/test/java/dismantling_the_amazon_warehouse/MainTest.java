package dismantling_the_amazon_warehouse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @BeforeEach
    void setUp() {
        Main.products.add(new Product(1, "Laptop", "Electronics"));
        Main.products.add(new Product(2, "Car", "Vehicles"));
    }

    @AfterEach
    void tearDown() {
        Main.products.clear();
    }

    @Test
    void groupProductsByCategory() {
        Map<String, List<Product>> result = Main.groupProductsByCategory(Main.products);

        assertEquals(2, result.size());
        assertEquals(1, result.get("Electronics").size());
        assertEquals(1, result.get("Vehicles").size());
    }

    @Test
    void printAllProducts() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Map<String, List<Product>> result = Main.groupProductsByCategory(Main.products);
        Main.printAllProducts(result);

        assertEquals(
                "Category: Electronics\n" +
                        "Products: [Product(id=1, name=Laptop, category=Electronics)]\n" +
                        "Category: Vehicles\n" +
                        "Products: [Product(id=2, name=Car, category=Vehicles)]\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}
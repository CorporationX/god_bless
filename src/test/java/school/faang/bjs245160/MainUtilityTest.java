package school.faang.bjs245160;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainUtilityTest {
    public static final Set<Product> products = new HashSet<>();

    @BeforeEach
    public void setUp() {
        products.add(ProductData.PRODUCT_A.createProduct());
        products.add(ProductData.PRODUCT_B.createProduct());
        products.add(ProductData.PRODUCT_C.createProduct());
    }

    @Test
    public void groupProductsByCategoryTest() {
        Map<String, List<Product>> map = Main.groupProductsByCategory(products);

        Assertions.assertEquals(3, map.size());
        Assertions.assertTrue(map.containsKey(ProductData.PRODUCT_A.getCategory()));
        Assertions.assertTrue(map.containsKey(ProductData.PRODUCT_B.getCategory()));
        Assertions.assertTrue(map.containsKey(ProductData.PRODUCT_C.getCategory()));

        Assertions.assertTrue(map.get(ProductData.PRODUCT_A.getCategory()).contains(
                ProductData.PRODUCT_A.createProduct()));
        Assertions.assertTrue(map.get(ProductData.PRODUCT_B.getCategory()).contains(
                ProductData.PRODUCT_B.createProduct()));
        Assertions.assertTrue(map.get(ProductData.PRODUCT_C.getCategory()).contains(
                ProductData.PRODUCT_C.createProduct()));
    }

    @Test
    public void printProductsByCategoryTest() {
        Map<String, List<Product>> map = Main.groupProductsByCategory(products);
        Main.printProductsByCategory(map);
    }
}

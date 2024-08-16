package faang.school.godbless.BJS2_19456;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    Set<Product> products;

    @BeforeEach
    void setUp() {
        products = new HashSet<>(
                Set.of(
                        new Product(1, "Laptop", "Electronics"),
                        new Product(2, "Smartphone", "Electronics"),
                        new Product(3, "Refrigerator", "Home Appliances"),
                        new Product(4, "Microwave", "Home Appliances"),
                        new Product(5, "Jeans", "Clothing"),
                        new Product(6, "T-Shirt", "Clothing"),
                        new Product(7, "Blender", "Kitchen Appliances"),
                        new Product(8, "Toaster", "Kitchen Appliances"),
                        new Product(9, "Sneakers", "Footwear"),
                        new Product(10, "Boots", "Footwear"),
                        new Product(11, "Sofa", "Furniture"),
                        new Product(12, "Chair", "Furniture"),
                        new Product(13, "Table", "Furniture"),
                        new Product(14, "Washing Machine", "Home Appliances"),
                        new Product(15, "Jacket", "Clothing"),
                        new Product(16, "Sandals", "Footwear"),
                        new Product(17, "Headphones", "Electronics"),
                        new Product(18, "Watch", "Accessories"),
                        new Product(19, "Necklace", "Accessories"),
                        new Product(20, "Earrings", "Accessories")
                )
        );
    }

    @Test
    void groupProductsByCategory() {
        var result = Main.groupProductsByCategory(products);
        assertThat(result).hasSize(7)
                .containsKeys("Electronics", "Home Appliances", "Clothing", "Kitchen Appliances",
                        "Footwear", "Furniture", "Accessories");
        assertThat(result.get("Electronics")).hasSize(3);
        assertThat(result.get("Home Appliances")).hasSize(3);
        assertThat(result.get("Clothing")).hasSize(3);
    }

    @Test
    void printProducts() {
        var categories = Main.groupProductsByCategory(products);
        Main.printProducts(categories);
    }
}
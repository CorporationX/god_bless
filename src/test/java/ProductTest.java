import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45141.Category;
import school.faang.task_45141.Product;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    // testing constructor for notnull
    @Test
    @DisplayName("Testing null as a parameter for category")
    void testProductCreation_NullAsCategoryParameter() {
        Category category = null;
        String name = "Socks";

        assertThrows(NullPointerException.class, () -> new Product(category, name));
    }

    @Test
    @DisplayName("Testing null as a parameter for name")
    void testProductCreation_NullAsNameParameter() {
        Category category = Category.CLOTHES;
        String name = null;

        assertThrows(NullPointerException.class, () -> new Product(category, name));
    }
}

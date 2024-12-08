package faang.school.godbless.sprint_1.task_19319;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.sprint_1.task_19319.Constants.CORRECT_PRODUCT_CATEGORY_MAP;
import static faang.school.godbless.sprint_1.task_19319.Constants.INCORRECT_PRODUCT_CATEGORY_MAP;
import static faang.school.godbless.sprint_1.task_19319.Main.products;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final Map<String, List<Product>> GROUP_PRODUCTS_BY_CATEGORY_RESULT
            = Main.groupProductsByCategory(products);

    @Test
    void testGroupProductsByCategoryCorrect() {
        assertEquals(CORRECT_PRODUCT_CATEGORY_MAP, GROUP_PRODUCTS_BY_CATEGORY_RESULT);
    }

    @Test
    void testGroupProductsByCategoryIncorrect() {
        assertNotEquals(INCORRECT_PRODUCT_CATEGORY_MAP, GROUP_PRODUCTS_BY_CATEGORY_RESULT);
    }
}
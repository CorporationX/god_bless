package school.faang.sprint_2.task_47968;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecommendationServiceTest {

    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        List<UserProfile> users = new ArrayList<>();
        users.add(new UserProfile(1, "Male", 30, "New York", List.of("electronics", "gaming")));
        users.add(new UserProfile(2, "Female", 28, "New York", List.of("fashion", "electronics")));

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", BigDecimal.valueOf(1000), List.of("electronics")));
        products.add(new Product(2, "Dress", "Fashion", BigDecimal.valueOf(50), List.of("fashion")));

        List<ProductOrder> orders = new ArrayList<>();
        orders.add(new ProductOrder(1, 1, LocalDateTime.now()));
        orders.add(new ProductOrder(2, 2, LocalDateTime.now()));

        recommendationService = new RecommendationService(users, products, orders);
    }

    @Test
    void testGetProductsByUserInterests() {
        List<Product> actual = recommendationService.getProductsByUserInterests(1);

        assertEquals(1, actual.size());
        assertEquals("Laptop", actual.get(0).getName());
    }

    @Test
    void testGetProductsBuyingSimilarUsers() {
        List<Product> actual = recommendationService.getProductsBuyingSimilarUsers(1);

        assertEquals(1, actual.size());
        assertEquals("Laptop", actual.get(0).getName());
    }

    @Test
    void testGetDiscountCategoryByUserId() {
        String actual = recommendationService.getDiscountCategoryByUserId(1);

        assertEquals("electronics", actual);
    }
}

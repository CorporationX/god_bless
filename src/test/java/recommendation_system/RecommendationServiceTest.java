package recommendation_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecommendationServiceTest {
    private RecommendationService recommendationService;
    private List<UserProfile> userProfiles;
    private List<Product> products;
    private List<ProductOrder> productOrders;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    void setUp() {
        userProfiles = Arrays.asList(
                new UserProfile(1, "male", 25, "New York", Arrays.asList("Сноубординг", "Фантастика")),
                new UserProfile(2, "female", 30, "Los Angeles", Arrays.asList("Кулинария", "Видеоигры")),
                new UserProfile(3, "male", 35, "Chicago", Collections.emptyList())
        );

        products = Arrays.asList(
                new Product(1, "Сноуборд", "Спортивные товары", 500, Arrays.asList("Спорт", "Сноубординг")),
                new Product(2, "Кулинарная книга", "Книги", 25, Arrays.asList("Кулинария", "Книги")),
                new Product(3, "Видеоигра", "Развлечения", 60, Arrays.asList("Видеоигры", "Развлечения"))
        );

        productOrders = Arrays.asList(
                new ProductOrder(2, "1", LocalDateTime.parse("2022-12-12 07:29:14", FORMATTER)),
                new ProductOrder(1, "1", LocalDateTime.parse("2022-03-15 12:30:00", FORMATTER)),
                new ProductOrder(4, "4", LocalDateTime.parse("2022-06-01 10:20:00", FORMATTER)),
                new ProductOrder(1, "2", LocalDateTime.parse("2022-03-20 11:45:00", FORMATTER))
        );

        recommendationService = new RecommendationService(userProfiles, products, productOrders);
    }

    @Test
    void recommendProductsByInterests_UserFound_ReturnsMatchingProducts() {
        List<Product> recommendedProducts = recommendationService.recommendProductsByInterests(1);
        assertEquals(1, recommendedProducts.size());
        assertEquals("Сноуборд", recommendedProducts.get(0).getName());
    }

    @Test
    void recommendProductsByInterests_UserNotFound_ReturnsEmptyList() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->  recommendationService.recommendProductsByInterests(999));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void recommendProductsByInterests_NoMatchingInterests_ReturnsEmptyList() {
        List<Product> recommendedProducts = recommendationService.recommendProductsByInterests(2);
        assertEquals(2, recommendedProducts.size());
        assertTrue(recommendedProducts.stream().anyMatch(product -> product.getName().equals("Кулинарная книга")));
        assertTrue(recommendedProducts.stream().anyMatch(product -> product.getName().equals("Видеоигра")));
    }

    @Test
    void recommendPopularProductsAmongSimilarUsers_UserFound_ReturnsTop5Products() {
        List<Optional<Product>> recommendedProducts = recommendationService.recommendPopularProductsAmongSimilarUsers(1);
        assertEquals(2, recommendedProducts.size());
        assertTrue(recommendedProducts.stream().anyMatch(product -> product.get().getName().equals("Сноуборд")));
        assertTrue(recommendedProducts.stream().anyMatch(product -> product.get().getName().equals("Кулинарная книга")));
    }

    @Test
    void recommendPopularProductsAmongSimilarUsers_UserNotFound_ReturnsEmptyList() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->  recommendationService.recommendPopularProductsAmongSimilarUsers(999));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void recommendPopularProductsAmongSimilarUsers_SimilarUsersFound_ReturnsTop5Products() {
        List<Optional<Product>> recommendedProducts = recommendationService.recommendPopularProductsAmongSimilarUsers(1);
        assertEquals(2, recommendedProducts.size());
        assertTrue(recommendedProducts.stream().anyMatch(product -> product.get().getName().equals("Сноуборд")));
        assertTrue(recommendedProducts.stream().anyMatch(product -> product.get().getName().equals("Кулинарная книга")));
    }

    @Test
    void recommendPopularProductsAmongSimilarUsers_NoOrders_ReturnsEmptyList() {
        List<Optional<Product>> recommendedProducts = recommendationService.recommendPopularProductsAmongSimilarUsers(3);
        assertTrue(recommendedProducts.isEmpty());
    }


    @Test
    public void testRecommendDiscountCategory_WhenUserHasOrders_ReturnsMostFrequentCategory() {
        String result = recommendationService.recommendDiscountCategory(1);
        assertEquals("Книги", result);
    }
}
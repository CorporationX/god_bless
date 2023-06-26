package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationServiceTest {
    private RecommendationService recommendationService;
    @BeforeEach
    void setUp() {
        List<UserProfile> users = new ArrayList<>();
        users.add(new UserProfile(1, "MALE", 20, "Москва", Arrays.asList("Сноубординг", "Фантастика", "Видеоигры")));
        users.add(new UserProfile(2, "FEMALE", 35, "Урюпинск", Arrays.asList("Мода", "Красота", "Косметика")));
        users.add(new UserProfile(3, "MALE", 20, "Москва", Arrays.asList("Скалолазание", "Детектив", "Спорт")));
        users.add(new UserProfile(4, "MALE", 20, "Москва", Arrays.asList("Скалолазание", "Детектив", "Спорт")));

        List<Product> products = new ArrayList<>();
        products.add(new Product(123, "Ботинки для сноуборда", "Спортивные товары", 100.0, Arrays.asList("Спорт", "Сноубординг", "Зимний спорт")));
        products.add(new Product(456, "Книга по фантастике", "Книги", 20.0, Arrays.asList("Фантастика", "Книги")));
        products.add(new Product(457, "Книга детектив", "Книги", 20.0, Arrays.asList("Детектив", "Книги")));
        products.add(new Product(789, "Игровая приставка", "Электроника", 300.0, Arrays.asList("Видеоигры", "Электроника")));
        products.add(new Product(858, "Шкаф", "Утварь", 200.0, Arrays.asList("Быт", "Интерьер")));
        products.add(new Product(857, "Форма для скалолазания", "Одежда", 200.0, Arrays.asList("Одежда", "Скалолазание")));
        products.add(new Product(859, "Спортивный костюм", "Одежда", 200.0, Arrays.asList("Одежда", "Спорт")));

        List<ProductOrder> orders = new ArrayList<>();
        orders.add(new ProductOrder(1, 123, "2022-11-05 18:48:24"));
        orders.add(new ProductOrder(3, 457, "2022-11-06 10:15:42"));
        orders.add(new ProductOrder(3, 857, "2022-11-06 10:15:42"));
        orders.add(new ProductOrder(3, 859, "2022-11-06 10:15:42"));
        orders.add(new ProductOrder(4, 859, "2022-11-06 10:15:42"));
        orders.add(new ProductOrder(4, 859, "2022-11-06 10:15:42"));

        recommendationService = new RecommendationService(users, products, orders);
    }

    @Test
    void getRecommendationsTest() {
        List<Product> recommendedProducts = recommendationService.getRecommendations(1);

        assertEquals(3, recommendedProducts.size());
        assertEquals(123, recommendedProducts.get(0).getProductId());
        assertEquals(456, recommendedProducts.get(1).getProductId());
        assertEquals(789, recommendedProducts.get(2).getProductId());
    }

    @Test
    void getTopProductsTest() {
        List<Product> recommendedProducts = recommendationService.getTopProducts(1);

        assertEquals(4, recommendedProducts.size());
        assertEquals(859, recommendedProducts.get(0).getProductId());
        assertEquals(457, recommendedProducts.get(1).getProductId());
    }

    @Test
    void getCategoryDiscountTest() {
        String category = recommendationService.getCategoryDiscount(1);

        assertEquals("Спортивные товары", category);
    }
}
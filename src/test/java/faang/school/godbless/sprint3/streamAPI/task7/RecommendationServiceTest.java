package faang.school.godbless.sprint3.streamAPI.task7;

import faang.school.godbless.sprint3.streamAPI.task7.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationServiceTest {

    private RecommendationService recommendationService = new RecommendationService();

    @Test
    void testSortedProducts() {
        List<Product> expected = List.of(
                new Product(2, "Хоббит", "Фантастика", 700, List.of("Фантастика", "Книги")),
                new Product(3, "Ботинки для сноуборда", "Спортивные товары", 700, List.of("Спорт", "Сноубординг", "Зимний спорт")),
                new Product(4, "Ведьмак 3", "Видеоигры", 2000, List.of("Фантастика", "Видеоигры")),
                new Product(1, "Футбольный мяч", "Спортивные товары", 2000, List.of("Спорт", "Футбол"))
        );

        List<Product> actual = recommendationService.sortedProducts(1);

        assertEquals(expected, actual);
    }

    @Test
    void testGetPopularProducts() {
        List<Product> expected = List.of(
                new Product(2, "Хоббит", "Фантастика", 700, List.of("Фантастика", "Книги")),
                new Product(3, "Ботинки для сноуборда", "Спортивные товары", 700, List.of("Спорт", "Сноубординг", "Зимний спорт")),
                new Product(4, "Ведьмак 3", "Видеоигры", 2000, List.of("Фантастика", "Видеоигры")),
                new Product(1, "Футбольный мяч", "Спортивные товары", 2000, List.of("Спорт", "Футбол"))
        );

        List<String> actual = recommendationService.getPopularProducts(1);

        assertEquals(expected, actual);
    }

    @Test
    void testGetCategoryForPersonalDiscount() {
        List<Product> expected = List.of(
                new Product(2, "Хоббит", "Фантастика", 700, List.of("Фантастика", "Книги")),
                new Product(3, "Ботинки для сноуборда", "Спортивные товары", 700, List.of("Спорт", "Сноубординг", "Зимний спорт")),
                new Product(4, "Ведьмак 3", "Видеоигры", 2000, List.of("Фантастика", "Видеоигры")),
                new Product(1, "Футбольный мяч", "Спортивные товары", 2000, List.of("Спорт", "Футбол"))
        );

        String actual = recommendationService.getCategoryForPersonalDiscount(5);

        assertEquals(expected, actual);
    }
}
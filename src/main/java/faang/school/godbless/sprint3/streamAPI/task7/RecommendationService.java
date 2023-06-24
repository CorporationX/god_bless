package faang.school.godbless.sprint3.streamAPI.task7;

import faang.school.godbless.sprint3.streamAPI.task7.model.Gender;
import faang.school.godbless.sprint3.streamAPI.task7.model.Product;
import faang.school.godbless.sprint3.streamAPI.task7.model.ProductOrder;
import faang.school.godbless.sprint3.streamAPI.task7.model.UserProfile;

import java.time.LocalDateTime;
import java.util.List;

public class RecommendationService {

    private List<UserProfile> userProfiles = List.of(
            new UserProfile(1, Gender.MALE, 20, "Москва", List.of("Сноубординг", "Фантастика", "Видеоигры")),
            new UserProfile(2, Gender.MALE, 20, "Москва", List.of("Футбол", "Фантастика", "Видеоигры")),
            new UserProfile(3, Gender.MALE, 20, "Москва", List.of("Книги", "Фантастика", "Хоккей")),
            new UserProfile(4, Gender.MALE, 20, "Москва", List.of("Скалолазание", "Фантастика", "Видеоигры")),
            new UserProfile(5, Gender.MALE, 20, "Москва", List.of("Сноубординг", "Футбол", "Рисование"))
    );

    private List<Product> products = List.of(
            new Product(1, "Футбольный мяч", "Спортивные товары", 2000, List.of("Спорт", "Футбол")),
            new Product(2, "Хоббит", "Фантастика", 700, List.of("Фантастика", "Книги")),
            new Product(3, "Ботинки для сноуборда", "Спортивные товары", 700, List.of("Спорт", "Сноубординг", "Зимний спорт")),
            new Product(4, "Ведьмак 3", "Видеоигры", 2000, List.of("Фантастика", "Видеоигры"))
    );

    private List<ProductOrder> productOrders = List.of(
            new ProductOrder(1, 4, LocalDateTime.now()),
            new ProductOrder(3, 2, LocalDateTime.now()),
            new ProductOrder(5, 3, LocalDateTime.now()),
            new ProductOrder(5, 1, LocalDateTime.now())
    );

    public List<Product> sortedProducts(int userId) {
        return null;
    }
}

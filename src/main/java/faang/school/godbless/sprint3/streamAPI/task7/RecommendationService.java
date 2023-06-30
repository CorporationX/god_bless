package faang.school.godbless.sprint3.streamAPI.task7;

import faang.school.godbless.sprint3.streamAPI.task7.model.Gender;
import faang.school.godbless.sprint3.streamAPI.task7.model.Product;
import faang.school.godbless.sprint3.streamAPI.task7.model.ProductOrder;
import faang.school.godbless.sprint3.streamAPI.task7.model.UserProfile;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationService {

    private final List<UserProfile> userProfiles = List.of(
            new UserProfile(1, Gender.MALE, 20, "Москва", List.of("Сноубординг", "Фэнтези", "Видеоигры")),
            new UserProfile(2, Gender.MALE, 26, "Москва", List.of("Футбол", "Фэнтези", "Видеоигры")),
            new UserProfile(3, Gender.FEMALE, 20, "Москва", List.of("Книги", "Фэнтези", "Хоккей")),
            new UserProfile(4, Gender.MALE, 22, "Москва", List.of("Скалолазание", "Фэнтези", "Видеоигры")),
            new UserProfile(5, Gender.MALE, 20, "Москва", List.of("Сноубординг", "Футбол", "Фэнтези"))
    );

    private final List<Product> products = List.of(
            new Product(1, "Футбольный мяч", "Спортивные товары", 2000, List.of("Спорт", "Футбол")),
            new Product(2, "Хоббит", "Фэнтези", 700, List.of("Фэнтези", "Книги")),
            new Product(3, "Ботинки для сноуборда", "Спортивные товары", 700, List.of("Спорт", "Сноубординг", "Зимний спорт")),
            new Product(4, "Ведьмак 3", "Видеоигры", 2000, List.of("Фэнтези", "Видеоигры")),
            new Product(5, "Клюшка", "Спортивные товары", 2000, List.of("Хоккей"))
    );

    private final List<ProductOrder> productOrders = List.of(
            new ProductOrder(1, 4, LocalDateTime.now()),
            new ProductOrder(1, 2, LocalDateTime.now()),
            new ProductOrder(3, 2, LocalDateTime.now()),
            new ProductOrder(5, 3, LocalDateTime.now()),
            new ProductOrder(5, 1, LocalDateTime.now()),
            new ProductOrder(5, 4, LocalDateTime.now()),
            new ProductOrder(5, 1, LocalDateTime.now()),
            new ProductOrder(5, 1, LocalDateTime.now()),
            new ProductOrder(5, 5, LocalDateTime.now())
    );

    public List<Product> sortedProducts(int userId) {
        UserProfile userProfile = getUserProfileById(userId);

        List<String> interests = userProfile.getInterests();

        return products.stream()
                .filter(x -> interests.stream().anyMatch(y -> x.getTags().contains(y)))
                .collect(Collectors.toList());
    }

    public List<String> getPopularProducts(int userId) {
        UserProfile userProfileById = getUserProfileById(userId);

        List<UserProfile> userProfilesFiltered = userProfiles.stream()
                .filter(x -> x.getGender().equals(userProfileById.getGender()))
                .filter(x -> x.getAge() == userProfileById.getAge())
                .filter(x -> x.getLocation().equals(userProfileById.getLocation()))
                .toList();

        List<ProductOrder> orderProfiles = userProfilesFiltered.stream()
                .map(x -> productOrders.stream()
                        .filter(y -> y.getUserId() == x.getUserId())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        return orderProfiles.stream()
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .map(Map.Entry::getKey)
                .toList()
                .stream().map(x -> products.stream()
                        .filter(y -> y.getProductId() == x)
                        .toList())
                .limit(5)
                .flatMap(Collection::stream)
                .map(Product::getName)
                .toList();
    }

    public String getCategoryForPersonalDiscount(int userId) {
        UserProfile userProfileById = getUserProfileById(userId);

        List<ProductOrder> ordersUser = productOrders.stream()
                .filter(x -> x.getUserId() == userId)
                .toList();

        Map<String, Integer> result = new HashMap<>();

        userProfileById.getInterests().stream()
                .map(up -> products.stream()
                        .filter(prods -> prods.getTags().contains(up))
                        .map(p -> ordersUser.stream()
                                .filter(x -> x.getProductId() == p.getProductId())
                                .peek(f -> result.merge(p.getCategory(), 1, Integer::sum))
                                .toList()))
                .flatMap(x -> x.flatMap(Collection::stream))
                .toList();

        return result.entrySet().stream().min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .get().getKey();
    }

    private UserProfile getUserProfileById(int userId) {
        return userProfiles.stream()
                .filter(x -> x.getUserId() == userId)
                .toList()
                .get(0);
    }
}

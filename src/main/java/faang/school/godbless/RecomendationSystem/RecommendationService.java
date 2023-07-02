package faang.school.godbless.RecomendationSystem;


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

    public List<Product> getRecommendedProductsByInterests(int userId) {
        UserProfile profile = getUserProfileById(userId);

        List<String> interests = profile.getInterests();

        return products.stream()
                .filter(product -> interests.stream().anyMatch(interest -> product.getTags().contains(interest)))
                .toList();

    }

    public List<String> getPopularProductsByAgeAndLocationAndGender(int userId) {

        UserProfile currentProfile = getUserProfileById(userId);

        List<UserProfile> filteredUserProfile = userProfiles.stream()
                .filter(userProfile -> userProfile.getGender().equals(currentProfile.getGender()))
                .filter(userProfile -> userProfile.getAge() == currentProfile.getAge())
                .filter(userProfile -> userProfile.getLocation().equals(currentProfile.getLocation()))
                .toList();

        List<ProductOrder> orders = filteredUserProfile.stream()
                .map(userProfile -> productOrders.stream()
                        .filter(productOrder -> userProfile.getUserId() == productOrder.getUserId())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        return orders.stream()
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .map(Map.Entry::getKey)
                .toList()
                .stream().map(productOrder -> products.stream()
                        .filter(product -> product.getProductId() == productOrder)
                        .toList())
                .limit(5)
                .flatMap(Collection::stream)
                .map(Product::getName)
                .toList();
    }

    public String getCategoryForPersonalDiscount(int userId) {
        UserProfile profile = getUserProfileById(userId);

        List<ProductOrder> orders = productOrders.stream()
                .filter(productOrder -> productOrder.getUserId() == profile.getUserId())
                .toList();

        Map<String, Integer> result = new HashMap<>();

        profile.getInterests().stream()
                .map(interest -> products.stream()
                        .filter(product -> product.getTags().contains(interest))
                        .map(product -> orders.stream()
                                .filter(order -> order.getProductId() == product.getProductId())
                                .peek(productOrder -> result.merge(product.getCategory(), 1, Integer::sum))
                                .toList()))
                .flatMap(listStream -> listStream.flatMap(Collection::stream))
                .toList();

        return result.entrySet().stream().min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .get().getKey();
    }

    private UserProfile getUserProfileById(int userId) {
        return userProfiles.stream()
                .filter(userProfile -> userProfile.getUserId() == userId)
                .toList()
                .get(0);
    }
}

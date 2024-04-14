package faang.school.godbless.bjs2_5319;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationService {

    private final List<UserProfile> users = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final List<ProductOrder> orders = new ArrayList<>();

    public RecommendationService() {

        products.add(new Product(1, "Samsung TV1", "Телевизоры", 25700, List.of("Электронника", "Видеотехника")));
        products.add(new Product(2, "Lenovo Yoga Slim", "Ноутбуки", 100200, List.of("Электронника", "Ноутбуки")));
        products.add(new Product(3, "Sony PlayStation", "Игры и консоли", 55964, List.of("Игры", "Приставки", "Консоли")));
        products.add(new Product(4, "Игра Spider Man 2", "Игры и консоли", 6121, List.of("Игры", "Приставки", "Консоли")));
        products.add(new Product(5, "Джинсы RUS AMOR Палаццо", "Одежда", 2310, List.of("Одежда", "Джинсы", "Женщинам")));

        UserProfile vasya = new UserProfile(1, Gender.MALE, 19, "Moscow", List.of("Игры", "Джинсы"));
        UserProfile petya = new UserProfile(2, Gender.MALE, 19, "Moscow", List.of("Игры", "Ноутбуки"));
        UserProfile nadya = new UserProfile(3, Gender.FEMALE, 20, "Moscow", List.of("Джинсы", "Женщинам"));
        users.add(vasya);
        users.add(petya);
        users.add(nadya);

        orders.add(new ProductOrder(2, 3, LocalDateTime.of(2023, 10, 20, 19, 20)));
        orders.add(new ProductOrder(1, 3, LocalDateTime.of(2023, 10, 20, 19, 20)));
        orders.add(new ProductOrder(1, 4, LocalDateTime.of(2023, 10, 20, 19, 21)));
        orders.add(new ProductOrder(1, 5, LocalDateTime.of(2023, 10, 20, 17, 15)));

    }

    public List<Product> findRecommendProductsForUserByUserId(int userId) {
        return products.stream()
                .filter(product -> product.getTags().stream()
                        .anyMatch(tag -> users.stream()
                                .filter(user -> user.getUserId() == userId)
                                .flatMap(user -> user.getInterests().stream())
                                .anyMatch(interest -> interest.equals(tag))
                        ))
                .toList();

    }

    public List<Product> findProductsForRelevantGroupUsers(int userId) {
        UserProfile user = findUserById(userId);
        List<Product> result = new ArrayList<>();
        if (user != null) {
            result = users.stream()
                    .filter(u -> u.getAge() == user.getAge() && u.getLocation().equals(user.getLocation()) && u.getGender().equals(user.getGender()))
                    .flatMap(userProfile -> orders.stream().filter(order -> order.getUserId() == userProfile.getUserId()))
                    .collect(Collectors.groupingBy(
                            ProductOrder::getProductId,
                            Collectors.counting()
                    )).entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                    .map(entry -> findProductById(entry.getKey()))
                    .limit(5)
                    .toList();
        }
        return result;
    }

    public String findCategoryForUserForSale(int userId) {
        List<String> interests = findUserById(userId).getInterests();
        return orders.stream()
                .filter(order -> order.getUserId() == userId)
                .flatMap(order -> findProductById(order.getProductId()).getTags().stream())
                .filter(interests::contains)
                .collect(Collectors.groupingBy(
                        category -> category,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse("No category");
    }

    private UserProfile findUserById(int userId) {
        return users.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);
    }

    private Product findProductById(int productId) {
        return products.stream().filter(product -> product.getProductId() == productId).findFirst().orElse(null);
    }

}

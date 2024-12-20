package school.faang.sprint2.task_47283;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> orders;


    public List<Product> findRecommendationsByInterests(int userId) {
        return userProfiles.stream()
                .filter((user) -> user.getUserId() == userId)
                .findFirst()
                .map(user -> products.stream()
                        .filter((product -> product.getTags().stream()
                                .anyMatch((tag) -> user.getInterests().contains(tag))))
                        .toList())
                .orElseThrow(() -> new IllegalArgumentException("There is no user with id: " + userId));
    }

    public List<Product> recommendPopularProducts(int userId) {
        return userProfiles.stream()
                .filter((user) -> user.getUserId() == userId)
                .findFirst()
                .map(foundedUser -> userProfiles.stream()
                        .filter((user) -> compareGenderAgeLocation(user, foundedUser))
                        .flatMap((user) -> orders.stream()
                                .filter((order) -> user.getUserId() == order.getUserId()))
                        .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()))
                        .entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .flatMap((entry) -> products.stream()
                                .filter((product) -> entry.getKey().equals(product.getProductId())))
                        .limit(5)
                        .toList())
                .orElseThrow(() -> new IllegalArgumentException("There is no user with id: " + userId));
    }

    public String findCategoryWithDiscount(int userId) {
        return userProfiles.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .map(foundedUser -> orders.stream()
                        .filter(order -> order.getUserId() == foundedUser.getUserId())
                        .flatMap(order -> products.stream()
                                .filter(product -> order.getProductId() == product.getProductId()))
                        .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()))
                        .entrySet().stream()
                        .max(Comparator.comparingLong(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElseThrow(() ->
                                new IllegalArgumentException("No category found for user with id: " + userId)))
                .orElseThrow(() ->
                        new IllegalArgumentException("There is no user with id: " + userId));
    }


    private boolean compareGenderAgeLocation(UserProfile user1, UserProfile user2) {
        return user1.getGender().equals(user2.getGender())
                && user1.getAge() == user2.getAge()
                && user1.getLocation().equals(user2.getLocation());
    }
}

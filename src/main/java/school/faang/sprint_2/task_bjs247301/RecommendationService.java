package school.faang.sprint_2.task_bjs247301;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class RecommendationService {
    private final List<UserProfile> users;
    private final List<Product> products;
    private final List<ProductOrder> orders;

    public List<Product> recommendProduct(int userId) {
        UserProfile user = findUserById(userId);
        return filterProductsByTags(products.stream(), user.interests())
                .toList();
    }

    public List<Product> mostPopularProducts(int userId, int maxProducts) {
        List<UserProfile> similarUserProfiles = findSimilarUsersByGenderAgeLocation(userId);
        List<Product> similarUsersProducts = getAllProductsByUsers(similarUserProfiles);

        return findMostFrequent(similarUsersProducts.stream(), Function.identity(), maxProducts);
    }

    public String recommendCategoriesForDiscount(int userId, int limit) {
        UserProfile profile = findUserById(userId);
        List<Product> profileOrders = getAllProductsByUsers(List.of(profile));

        return findMostFrequent(
                filterProductsByTags(profileOrders.stream(), profile.interests()),
                Product::category,
                limit)
                .stream()
                .findFirst()
                .orElse("No category found");
    }

    private UserProfile findUserById(int userId) {
        return users.stream()
                .filter(user -> Objects.equals(user.userId(), userId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Not found user with id: " + userId));
    }

    private List<UserProfile> findSimilarUsersByGenderAgeLocation(int userId) {
        UserProfile currentUser = findUserById(userId);

        return users.stream()
                .filter(profile -> Objects.equals(profile.gender(), currentUser.gender())
                        && Objects.equals(profile.age(), currentUser.age())
                        && Objects.equals(profile.location(), currentUser.location()))
                .toList();
    }

    private List<Product> getAllProductsByUsers(List<UserProfile> profiles) {
        List<Integer> userIds = profiles.stream()
                .map(UserProfile::userId)
                .toList();

        return products.stream()
                .filter(product -> isProductOrderedByUsers(product.productId(), userIds))
                .toList();
    }

    private boolean isProductOrderedByUsers(int productId, List<Integer> userIds) {
        return orders.stream()
                .anyMatch(order -> userIds.contains(order.userId()) && order.productId() == productId);
    }

    private Stream<Product> filterProductsByTags(Stream<Product> productStream, List<String> interests) {
        return productStream
                .filter(product -> product.tags().stream()
                        .anyMatch(interests::contains));
    }

    private <T, R> List<R> findMostFrequent(Stream<T> stream, Function<T, R> keyExtractor, int limit) {
        return stream.collect(Collectors.groupingBy(
                        keyExtractor,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<R, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}

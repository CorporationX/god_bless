package school.faang.sprint_2.task_bjs247301;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private final List<UserProfile> users;
    private final List<Product> products;
    private final List<ProductOrder> orders;

    public List<Product> recommendProduct(int userId) {
        UserProfile user = findUserById(userId);
        return filterProductsByTags(products, user.interests());
    }

    public List<Product> mostPopularProducts(int userId, int maxProducts) {
        List<UserProfile> similarUserProfiles = findSimilarUsersByGenderAgeLocation(userId);
        List<Product> similarUsersProducts = getAllProductsByUsers(similarUserProfiles);

        return findMostFrequent(similarUsersProducts, Function.identity(), maxProducts);
    }

    public String recommendCategoriesForDiscount(int userId, int limit) {
        UserProfile profile = findUserById(userId);
        List<Product> profileOrders = getAllProductsByUsers(List.of(profile));
        List<Product> filteredProducts = filterProductsByTags(profileOrders, profile.interests());
        List<String> mostFrequentCategories = findMostFrequent(filteredProducts, Product::category, limit);

        return mostFrequentCategories.stream()
                .findFirst()
                .orElse("No category found");
    }

    private UserProfile findUserById(int userId) {
        return users.stream()
                .filter(user -> Objects.equals(user.userId(), userId))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            if (list.isEmpty()) {
                                throw new NoSuchElementException("Not found user with id: " + userId);
                            }
                            if (list.size() > 1) {
                                throw new IllegalStateException("Multiple users found with id: " + userId);
                            }
                            return list.get(0);
                        }
                ));
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
                .filter(product -> orders.stream()
                        .anyMatch(order -> userIds.contains(order.userId())
                                && Objects.equals(order.productId(), product.productId())))
                .toList();
    }

    private List<Product> filterProductsByTags(List<Product> products, List<String> interests) {
        return products.stream()
                .filter(product -> product.tags().stream()
                        .anyMatch(interests::contains))
                .toList();
    }

    private <T, R> List<R> findMostFrequent(List<T> list, Function<T, R> keyExtractor, int limit) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        keyExtractor,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<R, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}

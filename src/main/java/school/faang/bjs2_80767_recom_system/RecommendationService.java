package school.faang.bjs2_80767_recom_system;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;

    public List<Product> getProductRecommendationsByUserInterests(int userId) {
        Optional<UserProfile> profile = getUserProfileById(userId);
        if (profile.isEmpty()) {
            return new ArrayList<>();
        }

        return getProductsMatchingInterests(profile.get().interests());
    }

    public List<Product> getProductsFromSimilarUsers(int userId) {
        Optional<UserProfile> maybeProfile = getUserProfileById(userId);
        if (maybeProfile.isEmpty()) {
            return new ArrayList<>();
        }
        int maxProductsToReturn = 5;
        UserProfile profile = maybeProfile.get();

        List<Integer> matchingProfileIds = userProfiles.stream()
                .filter(match ->
                        match.userId() != profile.userId()
                                && match.age() == profile.age()
                                && match.gender().equals(profile.gender())
                                && match.location().equals(profile.location())
                )
                .map(UserProfile::userId)
                .toList();

        List<ProductOrder> ordersFromMatchingUsers = productOrders.stream()
                .filter(o -> matchingProfileIds.contains(o.userId()))
                .toList();

        Map<Integer, Integer> productsWithCount = ordersFromMatchingUsers.stream()
                .collect(Collectors.groupingBy(
                        ProductOrder::productId, Collectors.collectingAndThen(Collectors.counting(), Long::intValue))
                );

        return productsWithCount.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .limit(maxProductsToReturn)
                .map(entry -> getProductById(entry.getKey()))
                .toList();
    }

    public String bestCategory(int userId) {
        List<ProductOrder> userOrders = productOrders.stream()
                .filter(o -> o.userId() == userId)
                .toList();
        UserProfile profile = getUserProfileById(userId).orElseThrow();
        Set<String> interests = profile.interests();

        Map<String, Integer> categoriesWithCount = userOrders.stream()
                .map(order -> getProductById(order.productId()))
                .filter(Objects::nonNull)
                .filter(product -> product.tags().stream().anyMatch(interests::contains))
                .collect(Collectors.groupingBy(
                        Product::category, Collectors.collectingAndThen(Collectors.counting(), Long::intValue))
                );

        return categoriesWithCount.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }


    private Optional<UserProfile> getUserProfileById(int userId) {
        return userProfiles.stream()
                .filter(p -> p.userId() == userId)
                .findFirst();
    }

    private List<Product> getProductsMatchingInterests(Set<String> interests) {
        return products.stream()
                .filter(p -> p.tags().stream().anyMatch(interests::contains))
                .toList();
    }

    private Product getProductById(int productId) {
        return products.stream()
                .filter(p -> p.productId() == productId)
                .findFirst().orElseThrow();
    }
}

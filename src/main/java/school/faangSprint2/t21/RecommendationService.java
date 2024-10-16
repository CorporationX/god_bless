package school.faangSprint2.t21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;
    private final Map<String, Product> productMap;

    public RecommendationService(List<UserProfile> userProfiles, List<Product> products, List<ProductOrder> productOrders) {
        this.userProfiles = userProfiles;
        this.products = filterValidProducts(products);
        this.productOrders = filterValidOrders(productOrders, this.products);
        this.productMap = this.products.stream()
                .collect(Collectors.toMap(Product::getProductId, p -> p));
    }

    private List<Product> filterValidProducts(List<Product> rawProducts) {
        if (rawProducts == null) return new ArrayList<>();

        return rawProducts.stream()
                .filter(this::isValidProduct)
                .collect(Collectors.toList());
    }

    private boolean isValidProduct(Product product) {
        return product != null &&
                product.getProductId() != null &&
                !product.getProductId().trim().isEmpty() &&
                product.getName() != null &&
                !product.getName().trim().isEmpty() &&
                product.getCategory() != null &&
                !product.getCategory().trim().isEmpty() &&
                product.getTags() != null &&
                !product.getTags().isEmpty();
    }

    private List<ProductOrder> filterValidOrders(List<ProductOrder> orders, List<Product> validProducts) {
        if (orders == null) return new ArrayList<>();

        Set<String> validProductIds = validProducts.stream()
                .map(Product::getProductId)
                .collect(Collectors.toSet());

        return orders.stream()
                .filter(order -> order != null &&
                        order.getProductId() != null &&
                        validProductIds.contains(order.getProductId()) &&
                        order.getUserId() != null &&
                        order.getOrderDate() != null)
                .collect(Collectors.toList());
    }

    public List<Product> getRecommendationsByInterests(String userId) {
        UserProfile user = findUserById(userId);
        if (user == null) return Collections.emptyList();

        return products.stream()
                .filter(product -> hasMatchingInterests(product, user))
                .sorted((p1, p2) -> calculateInterestScore(p2, user) - calculateInterestScore(p1, user))
                .collect(Collectors.toList());
    }

    private boolean hasMatchingInterests(Product product, UserProfile user) {
        if (product == null || user == null ||
                product.getTags() == null || user.getInterests() == null) {
            return false;
        }

        return user.getInterests().stream()
                .anyMatch(interest -> product.getTags().contains(interest));
    }

    private int calculateInterestScore(Product product, UserProfile user) {
        if (product == null || user == null ||
                product.getTags() == null || user.getInterests() == null) {
            return 0;
        }

        return (int) user.getInterests().stream()
                .filter(interest -> product.getTags().contains(interest))
                .count();
    }

    public List<Product> getPopularProductsForSimilarUsers(String userId) {
        UserProfile user = findUserById(userId);
        if (user == null) return Collections.emptyList();

        List<UserProfile> similarUsers = findSimilarUsers(user);
        if (similarUsers.isEmpty()) return Collections.emptyList();

        Map<String, Long> productFrequency = productOrders.stream()
                .filter(order -> similarUsers.stream()
                        .anyMatch(u -> u.getUserId().equals(order.getUserId())))
                .filter(order -> productMap.containsKey(order.getProductId()))
                .collect(Collectors.groupingBy(
                        ProductOrder::getProductId,
                        Collectors.counting()
                ));

        return productFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> productMap.get(entry.getKey()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<UserProfile> findSimilarUsers(UserProfile user) {
        return userProfiles.stream()
                .filter(u -> !u.getUserId().equals(user.getUserId()))
                .filter(u -> isSimilarUser(u, user))
                .collect(Collectors.toList());
    }

    private boolean isSimilarUser(UserProfile u1, UserProfile u2) {
        if (u1 == null || u2 == null) return false;

        boolean ageMatches = Math.abs(u1.getAge() - u2.getAge()) <= 5;
        boolean locationMatches = u1.getLocation() != null &&
                u1.getLocation().equals(u2.getLocation());

        return ageMatches && locationMatches;
    }

    public String recommendCategory(String userId) {
        List<ProductOrder> userOrders = productOrders.stream()
                .filter(order -> order.getUserId().equals(userId))
                .filter(order -> productMap.containsKey(order.getProductId()))
                .collect(Collectors.toList());

        if (userOrders.isEmpty()) return null;

        Map<String, Long> categoryFrequency = userOrders.stream()
                .map(order -> productMap.get(order.getProductId()))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.counting()
                ));

        return categoryFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private UserProfile findUserById(String userId) {
        return userProfiles.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
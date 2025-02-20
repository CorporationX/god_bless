package bjs2_58096;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record RecommendationService(
        List<UserProfile> userProfiles,
        List<Product> products,
        List<ProductOrder> productOrders
) {
    private static final int TOP_ORDERS_COUNT = 5;

    public List<Product> getProductByUserInterests(int userId) {
        Optional<UserProfile> userOrEmpty = getUserProfileOrEmpty(userId);

        if (userOrEmpty.isEmpty()) {
            return List.of();
        }

        UserProfile requestedUser = userOrEmpty.get();

        return products.stream()
                .filter(p -> requestedUser.interests()
                        .stream()
                        .anyMatch(interest -> p.tags().contains(interest)))
                .toList();
    }

    public List<Product> getTopTheSameFavorites(int userId) {
        Optional<UserProfile> userOrEmpty = getUserProfileOrEmpty(userId);

        if (userOrEmpty.isEmpty()) {
            return List.of();
        }

        UserProfile requestedUser = userOrEmpty.get();

        Map<Integer, UserProfile> usersWithSameParameters = userProfiles.stream()
                .filter(user -> user.age() == requestedUser.age()
                        && user.gender() == requestedUser.gender()
                        && user.location().equals(requestedUser.location()))
                .collect(Collectors.toMap(UserProfile::userId, x -> x));

        Map<Integer, Product> productsById = products.stream()
                .collect(Collectors.toMap(Product::productId, x -> x));

        var ordersCountByProduct = productOrders.stream()
                .filter(order -> usersWithSameParameters.containsKey(order.userId()))
                .map(order -> productsById.getOrDefault(order.productId(), null))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return ordersCountByProduct.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(TOP_ORDERS_COUNT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public String getProductsWithDiscount(int userId) {
        Optional<UserProfile> userOrEmpty = getUserProfileOrEmpty(userId);

        if (userOrEmpty.isEmpty()) {
            return "";
        }

        UserProfile requestedUser = userOrEmpty.get();
        Set<String> userInterests = new HashSet<>(requestedUser.interests());

        var categories = productOrders.stream()
                .filter(order -> order.userId() == userId)
                .map(order -> products.stream()
                        .filter(product -> product.productId() == order.productId()
                                && product.tags().stream().anyMatch(userInterests::contains))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Product::category, Collectors.counting()));

        return categories.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет подходящей категории");
    }

    private Optional<UserProfile> getUserProfileOrEmpty(int userId) {
        return userProfiles.stream()
                .filter(user -> user.userId() == userId)
                .findFirst();
    }
}

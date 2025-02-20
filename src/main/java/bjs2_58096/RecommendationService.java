package bjs2_58096;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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

        Map<Integer, ProductOrder> orderedProductIds = productOrders.stream()
                .filter(x -> x.userId() == userId)
                .collect(Collectors.toMap(ProductOrder::productId, x -> x));

        var mostPopularTag = products.stream()
                .filter(x -> orderedProductIds.containsKey(x.productId()))
                .flatMap(x -> x.tags().stream())
                .distinct()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));

        if (mostPopularTag.isEmpty()) {
            return "";
        }

        return mostPopularTag.get().getKey();
    }

    private Optional<UserProfile> getUserProfileOrEmpty(int userId) {
        return userProfiles.stream()
                .filter(user -> user.userId() == userId)
                .findFirst();
    }
}

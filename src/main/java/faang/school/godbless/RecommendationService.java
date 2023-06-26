package faang.school.godbless;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecommendationService {
    private List<UserProfile> allUsers;
    private List<Product> allProducts;
    private List<ProductOrder> allOrders;

    public RecommendationService(List<UserProfile> allUsers, List<Product> allProducts, List<ProductOrder> allOrders) {
        this.allUsers = allUsers;
        this.allProducts = allProducts;
        this.allOrders = allOrders;
    }

    public List<Product> getRecommendations(int userId) {
        UserProfile user = findUserById(userId);
        if (user == null) {
            return Collections.emptyList();
        }

        List<String> interests = user.getInterests();

        return allProducts.stream().filter(product -> product.getTags().stream()
                .anyMatch(interests::contains)).collect(Collectors.toList());
    }

    public List<Product> getTopProducts(int userId) {
        UserProfile user = findUserById(userId);
        if (user == null) {
            return Collections.emptyList();
        }
        List<ProductOrder> relevantProducts = allOrders.stream()
                .filter(order -> isSameDemographic(user, findUserById(order.getUserId())))
                .collect(Collectors.toList());

        Map<Integer, Integer> productCounts = new HashMap<>();
        for (ProductOrder order : relevantProducts) {
            int productId = order.getProductId();
            productCounts.put(productId, productCounts.getOrDefault(productId, 0) + 1);
        }

        return productCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(entry -> findProductById(entry.getKey()))
                .collect(Collectors.toList());
    }

    public String getCategoryDiscount(int userId) {
        UserProfile user = findUserById(userId);
        if (user == null) {
            return null;
        }

        List<String> interests = user.getInterests();

        Map<String, Long> categoryCount = allOrders.stream()
                .filter(order -> isSameDemographic(user, findUserById(order.getUserId())))
                .flatMap(order -> {
                    Product product = findProductById(order.getProductId());
                    if (product != null && product.getTags().stream().anyMatch(interests::contains)) {
                        return Stream.of(product.getCategory());
                    }
                    return Stream.empty();
                })
                .collect(Collectors.groupingBy(element -> element, Collectors.counting()));

        return categoryCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }


    private UserProfile findUserById(int userId) {
        return allUsers.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    private Product findProductById(int productId) {
        return allProducts.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    private boolean isSameDemographic(UserProfile user1, UserProfile user2) {
        return user1 != null && user2 != null &&
                user1.getAge() == user2.getAge() &&
                user1.getLocation().equals(user2.getLocation()) &&
                user1.getGender().equals(user2.getGender());
    }
}

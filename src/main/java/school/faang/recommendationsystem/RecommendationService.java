package school.faang.recommendationsystem;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecommendationService {
    private List<UserProfile> userProfiles;
    private List<Product> products;
    private List<ProductOrder> productOrders;

    public RecommendationService(List<UserProfile> userProfiles, List<Product> products, List<ProductOrder> productOrders) {
        this.userProfiles = userProfiles;
        this.products = products;
        this.productOrders = productOrders;
    }

    public List<Product> recommendProductsByInterests(int userId) {
        UserProfile user = userProfiles.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElse(null);

        if (user == null) {
            return Collections.emptyList();
        }

        return products.stream()
                .filter(product -> product.getTags().stream().anyMatch(user.getInterests()::contains))
                .collect(Collectors.toList());
    }

    public List<Product> recommendPopularProducts(int userId) {
        UserProfile user = userProfiles.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElse(null);

        if (user == null) {
            return Collections.emptyList();
        }

        List<Integer> similarUserIds = userProfiles.stream()
                .filter(u -> u.getAge() == user.getAge() && u.getGender().equals(user.getGender())
                        && u.getLocation().equals(user.getLocation()) && u.getUserId() != userId)
                .map(UserProfile::getUserId)
                .collect(Collectors.toList());

        Map<Integer, Long> productCountMap = productOrders.stream()
                .filter(order -> similarUserIds.contains(order.getUserId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));

        return productCountMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> products.stream()
                        .filter(product -> product.getProductId() == entry.getKey())
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String recommendDiscountCategory(int userId) {
        List<ProductOrder> userOrders = productOrders.stream()
                .filter(order -> order.getUserId() == userId)
                .collect(Collectors.toList());

        UserProfile user = userProfiles.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElse(null);

        if (user == null || userOrders.isEmpty()) {
            return null;
        }

        Map<String, Long> categoryCountMap = userOrders.stream()
                .map(order -> products.stream()
                        .filter(product -> product.getProductId() == order.getProductId())
                        .map(Product::getCategory)
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(category -> category, Collectors.counting()));

        return categoryCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}

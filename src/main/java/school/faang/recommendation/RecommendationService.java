package school.faang.recommendation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RecommendationService {
    private final List<UserProfile> profiles;
    private final List<Product> products;
    private final List<ProductOrder> orders;

    public List<Product> recommendByInterests(int userId) {
        UserProfile user = getUserProfileBy(userId);
        return products.stream()
                .filter(product -> product.getTags().stream()
                        .anyMatch(tag -> user.getInterests().contains(tag)))
                .toList();
    }

    private UserProfile getUserProfileBy(int userId) {
        return profiles.stream()
                .filter(userProfile -> userProfile.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с id=" + userId + " не найден"));
    }

    public List<Product> recommendPopularProductSimilarUsers(int userId) {
        UserProfile user = getUserProfileBy(userId);

        List<Integer> similarUserIds = profiles.stream()
                .filter(profile -> profile.getGender().equals(user.getGender())
                        && profile.getAge() == user.getAge()
                        && profile.getLocation().equals(user.getLocation()))
                .map(UserProfile::getUserId)
                .toList();

        Map<Integer, Long> productPopularity = orders.stream()
                .filter(order -> similarUserIds.contains(order.getUserId()))
                .collect(Collectors.groupingBy(
                        ProductOrder::getProductId,
                        Collectors.counting()
                ));

        return productPopularity.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> products.stream()
                        .filter(product -> product.getProductId() == entry.getKey())
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }

    public String recommendDiscountCategory(int userId) {
        List<Integer> userProductIds = orders.stream()
                .filter(order -> order.getUserId() == userId)
                .map(ProductOrder::getProductId)
                .toList();

        Map<String, Long> categoryCount = products.stream()
                .filter(product -> userProductIds.contains(product.getProductId()))
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        return categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}

package faang.school.godbless;

import lombok.Getter;

import java.util.Collections;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class RecommendationService {
    private List<UserProfile> users;
    private List<Product> products;
    private List<ProductOrder> orders;

    public RecommendationService(List<UserProfile> users, List<Product> products, List<ProductOrder> orders) {
        this.users = users;
        this.products = products;
        this.orders = orders;
    }

    public List<Product> recommendProductsByInterests(int userId) {
        UserProfile user = users.get(userId);
        if (user == null) return Collections.emptyList();

        Set<String> userInterests = new HashSet<>(user.getInterests());

        return products.stream()
                .filter(product -> product.getTags().stream().anyMatch(userInterests::contains))
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public List<Product> recommendTopPurchasedProducts(int userId) {
        UserProfile user = getUserById(userId);
        if (user == null) return Collections.emptyList();

        List<UserProfile> similarUsers = users.stream()
                .filter(u -> u.getGender().equals(user.getGender()) &&
                        u.getAge() == user.getAge() &&
                        u.getLocation().equals(user.getLocation()))
                .collect(Collectors.toList());

        List<Integer> similarUsersIds = similarUsers.stream()
                .map(UserProfile::getUserId)
                .collect(Collectors.toList());

        Map<Integer, Long> productFrequency = orders.stream()
                .filter(order -> similarUsersIds.contains(order.getUserId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));

        return productFrequency.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .map(e -> getProductById(e.getKey()))
                .collect(Collectors.toList());
    }


    public String recommendCategoryForDiscount(int userId) {
        UserProfile user = getUserById(userId);
        if (user == null) return null;

        Set<String> userInterests = new HashSet<>(user.getInterests());

        Map<String,Long> categoryFrequency = orders.stream()
                .filter(order -> order.getUserId() == userId)
                .map(order -> getProductById(order.getProductId()))
                .filter(product -> product.getTags().stream().anyMatch(userInterests::contains))
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        return categoryFrequency.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private UserProfile getUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    private Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }
}

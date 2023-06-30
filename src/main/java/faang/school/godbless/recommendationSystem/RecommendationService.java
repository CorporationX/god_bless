package faang.school.godbless.recommendationSystem;

import java.util.*;
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

    public List<Product> getRecommendedProductsByInterests(int userId) {
        UserProfile user = getUserProfile(userId);
        if (user == null) {
            return new ArrayList<>();
        }

        return products.stream()
                .filter(product -> containsAnyTag(product.getTags(), user.getInterests()))
                .collect(Collectors.toList());
    }

    public List<Product> getPopularProductsByAgeAndLocationAndGender(int userId) {
        UserProfile user = getUserProfile(userId);
        if (user == null) {
            return new ArrayList<>();
        }

        return productOrders.stream()
                .filter(order -> isMatchingUser(user, order))
                .flatMap(order -> products.stream()
                        .filter(product -> product.getProductId() == order.getProductId()))
                .collect(Collectors.groupingBy(Product::getProductId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> getProductById(entry.getKey()))
                .collect(Collectors.toList());
    }

    public String getCategoryForPersonalDiscount(int userId) {
        UserProfile user = getUserProfile(userId);
        if (user == null) {
            return "";
        }

        List<ProductOrder> userOrders = productOrders.stream()
                .filter(order -> order.getUserId() == userId)
                .collect(Collectors.toList());

        return userOrders.stream()
                .flatMap(order -> products.stream()
                        .filter(product -> containsAnyTag(product.getTags(), user.getInterests()))
                        .filter(product -> product.getProductId() == order.getProductId())
                        .map(Product::getCategory))
                .collect(Collectors.groupingBy(category -> category, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    private UserProfile getUserProfile(int userId) {
        return userProfiles.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    private boolean containsAnyTag(List<String> tags, List<String> interests) {
        return tags.stream().anyMatch(interests::contains);
    }

    private boolean isMatchingUser(UserProfile user, ProductOrder order) {
        UserProfile orderUser = getUserProfile(order.getUserId());
        return orderUser != null && orderUser.getGender().equals(user.getGender())
                && orderUser.getAge() == user.getAge() && orderUser.getLocation().equals(user.getLocation());
    }

    private Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

}

package school.faang.task_47256;

import lombok.AllArgsConstructor;
import school.faang.task_47256.model.Product;
import school.faang.task_47256.model.ProductOrder;
import school.faang.task_47256.model.UserProfile;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;

    public List<Product> getProducts(int userId) {
        UserProfile user = getUserById(userId);

        return products.stream()
                .filter(product -> product.tags().stream()
                        .anyMatch(tag -> user.interests().contains(tag)))
                .toList();
    }

    public List<Product> findPopularProductsOtherUsers(int userId) {
        UserProfile user = getUserById(userId);

        Set<Integer> usersOther = userProfiles.stream()
                .filter(u -> u.age() == user.age()
                        && u.gender() == user.gender()
                        && u.location().equals(user.location()))
                .map(UserProfile::userId)
                .collect(Collectors.toSet());

        return productOrders.stream()
                .filter(order -> usersOther.contains(order.productId()))
                .collect(Collectors.groupingBy(ProductOrder::productId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(entry -> findProductById(entry.getKey()))
                .toList();
    }

    public String getCategoryForDiscount(int userId) {
        UserProfile user = getUserById(userId);

        return productOrders.stream()
                .filter(order -> order.userId() == userId)
                .map(order -> findProductById(order.productId()))
                .filter(product -> product.tags().stream()
                        .anyMatch(tag -> user.interests().contains(tag)))
                .collect(Collectors.groupingBy(Product::category, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private UserProfile getUserById(int userId) {
        return userProfiles.stream()
                .filter(userProfile -> userProfile.userId() == userId)
                .findFirst()
                .orElseThrow();
    }

    private Product findProductById(long productId) {
        return products.stream()
                .filter(product -> product.productId() == productId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found for ID: " + productId));
    }
}

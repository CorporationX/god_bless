package faang.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> users;
    private List<Product> products;
    private List<ProductOrder> orders;

    public List<Product> getRecommendedProducts(int userId) {
        UserProfile user = findUser(userId);
        return products.stream()
                .filter(product -> product.getTags().stream()
                        .anyMatch(user.getInterests()::contains))
                .toList();
    }

    public List<Product> mostCommonProducts(int userId) {
        UserProfile currentUser = findUser(userId);

        var res = orders.stream()
                .filter(order -> areMatching(order.getUserId(), currentUser))
                .map(ProductOrder::getProductId)
                .flatMap(
                        productId -> products.stream()
                                .filter(product -> product.getProductId() == productId))
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
        return res;
    }

    public String getPersonalDiscount(int userId) {
        UserProfile currentUser = findUser(userId);
        var userInterests = currentUser.getInterests();

        var userProductIds = orders.stream()
                .filter(order -> order.getUserId() == userId)
                .map(ProductOrder::getProductId)
                .toList();

        var userProducts = userProductIds.stream()
                .map(this::getProductById)
                .filter(product -> userInterests.contains(product.getCategory()))
                .toList();

        var res = userProducts.stream()
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .map(Map.Entry::getKey)
                .toList();
        if (res.size() > 0) {
            return res.get(0).getCategory();
        }
        return "No category";
    }

    private Product getProductById(int id) {
        return products.stream().filter(product -> product.getProductId() == id).findFirst().orElse(null);
    }

    private UserProfile findUser(int userId) {
        return users.stream()
                .filter(userProfile -> userProfile.getUserId() == userId)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("User doesn`t exist"));
    }

    private boolean areMatching(int userId, UserProfile user) {
        UserProfile currentUser = findUser(userId);
        return !currentUser.equals(user)
                && user.getAge() == currentUser.getAge()
                && Objects.equals(user.getGender(), currentUser.getGender())
                && Objects.equals(user.getLocation(), currentUser.getLocation());
    }
}

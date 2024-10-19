package school.faang.recommender.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> users;
    private List<Product> products;
    private List<ProductOrder> orders;

    public List<Product> getProductsSortedByUserInterests(int userId) {
        UserProfile userProfile = findUserById(userId);

        Map<String, List<Product>> tagToProducts = new HashMap<>();
        for (Product product : products) {
            product.getTags().forEach(tag -> {
                List<Product> products = tagToProducts.getOrDefault(tag, new ArrayList<>());
                products.add(product);
                tagToProducts.put(tag, products);
            });
        }

        return userProfile.getInterests().stream()
                .flatMap(interest -> tagToProducts.getOrDefault(interest, new ArrayList<>()).stream())
                .distinct()
                .toList();
    }

    public List<Product> findTopProductsForSimilarUsers(int userId) {
        UserProfile currUser = findUserById(userId);
        List<UserProfile> similarUsers = users.stream()
                .filter(currUser::similar)
                .toList();

        List<ProductOrder> similarProducts = orders.stream()
                .filter(order -> similarUsers.stream()
                        .anyMatch(user -> user.getUserId() == order.getUserId())
                )
                .toList();

        Map<Integer, Long> productIdToCount = similarProducts.stream()
                .collect(Collectors.groupingBy(
                        ProductOrder::getProductId,
                        Collectors.counting()
                ));

        Map<Integer, Product> productIdToProduct = products.stream()
                .collect(Collectors.toMap(
                        Product::getProductId,
                        Function.identity()
                ));
        return productIdToCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> productIdToProduct.get(entry.getKey()))
                .toList();
    }

    public String suggestDiscountCategoryForUser(int userId) {
        List<ProductOrder> userOrders = orders.stream()
                .filter(order -> order.getUserId() == userId)
                .toList();
        List<Product> userProducts = products.stream()
                .filter(product -> userOrders.stream()
                        .anyMatch(order -> order.getProductId() == product.getProductId()))
                .toList();
        Map<String, Long> categoryToCount = userProducts.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.counting()
                ));
        return categoryToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("для пользователя " + userId + "не существует заказов"));
    }

    private UserProfile findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не был найден"));
    }
}

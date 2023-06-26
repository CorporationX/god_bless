package faang.school.godbless.secondSprint.RecommenderSystem;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> users;
    private List<Product> products;
    private List<ProductOrder> orders;

    public List<Product> filterProductByInterest(int userId) {
        UserProfile rightUser = findRightUser(userId);

        return products.stream()
                .filter(product -> product.tags().stream().anyMatch(tag -> rightUser.interest().contains(tag)))
                .toList();
    }

    public List<Product> findMostPopularProduct(int userId) {
        UserProfile rightUser = findRightUser(userId);

        List<Integer> similarUsersIds = users.stream()
                .filter(user -> user.age() == rightUser.age() && user.gender().equals(rightUser.gender())
                        && user.location().equals(rightUser.location()) && user.userId() != userId)
                .map(UserProfile::userId)
                .toList();

        Map<Product, Long> groupedProducts = orders.stream()
                .filter(order -> similarUsersIds.contains(order.userId()))
                .map(order -> {
                    for (Product product : products) {
                        if (product.productId() == order.productId()) {
                            return product;
                        }
                    }
                    throw new IllegalArgumentException("Incorrect orders list");
                })
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        return groupedProducts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public Optional<String> findCategoryForDiscount(int userId) {
        UserProfile user = findRightUser(userId);

        List<Product> rightUserProducts = orders.stream()
                .filter(order -> order.userId() == userId)
                .flatMap(order -> products.stream().filter(product -> product.productId() == order.productId()))
                .toList();

        Map<String, Integer> sortedCategory = new HashMap<>();

        rightUserProducts.forEach(product -> {
            if (product.tags().stream().anyMatch(tag -> user.interest().contains(tag))) {
                String category = product.category();
                if (sortedCategory.containsKey(category)) {
                    sortedCategory.put(category, sortedCategory.get(category) + 1);
                } else {
                    sortedCategory.put(category, 1);
                }
            }
        });

        return sortedCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    private UserProfile findRightUser(int userId) {
        return users.stream()
                .filter(user -> user.userId() == userId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal id value"));
    }
}

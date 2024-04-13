package faang.school.godbless.RecommendationSystem;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private final List<UserProfile> users;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;

    public List<Product> getInterestProducts(int userId) {
        UserProfile user = getUserById(userId);
        List<String> interests = user.getInterests();

        Map<Product, Long> interceptionsCount = products.stream()
                .filter(product -> interests.stream().anyMatch(interest -> product.getTags().contains(interest)))
                .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.flatMapping(product -> product.getTags().stream()
                                                .filter(tag -> interests.stream().anyMatch(interest -> interest.equals(tag))),
                                        Collectors.counting())
                        )
                );

        return interceptionsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Product> getFrequentProducts(int userId) {
        UserProfile user = getUserById(userId);
        int age = user.getAge();
        String location = user.getLocation();
        Gender gender = user.getGender();

        List<UserProfile> profiles = users.stream()
                .filter(userProfile -> userProfile.getUserId() != userId &&
                        userProfile.getAge() == age &&
                        userProfile.getLocation().equals(location) &&
                        userProfile.getGender().equals(gender))
                .toList();

        Map<Product, Long> productsCount = profiles.stream()
                .flatMap(userProfile -> getOrdersByUserId(userProfile.getUserId()).stream())
                .collect(Collectors.groupingBy(order -> getProductById(order.getProductId()), Collectors.counting()));

        return productsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public String getPersonalDiscountCategory(int userId) {
        UserProfile user = getUserById(userId);
        List<ProductOrder> orders = getOrdersByUserId(userId);
        List<String> interests = user.getInterests();

        Map<String, Long> categoryCount = orders.stream()
                .map(order -> getProductById(order.getProductId()))
                .filter(product -> interests.stream().anyMatch(interest -> product.getTags().contains(interest)))
                .map(Product::getCategory)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("NaN");
    }

    private UserProfile getUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Пользователь с id-" + userId + " не найден"));
    }

    private List<ProductOrder> getOrdersByUserId(int userId) {
        return productOrders.stream()
                .filter(order -> order.getUserId() == userId)
                .toList();
    }

    private Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Продукт с id-" + productId + " не найден"));
    }
}

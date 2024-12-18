package school.faang.sprint_2.task_47311;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;

    public List<Product> getRecommendedProducts(int userId) {
        UserProfile user = getUserProfileById(userId);

        return getRecommendedProductsAsStream(user).toList();
    }

    public List<Product> getRecommendedProductsFromSimilarUsers(int userId) {
        UserProfile user = getUserProfileById(userId);
        List<UserProfile> similarUserProfiles = getSimilarUserProfiles(user);

        return similarUserProfiles.stream()
                .flatMap(this::getRecommendedProductsAsStream)
                .sorted((product1, product2) -> compareAmountOfProductsSells(product2, product1))
                .limit(5)
                .toList();
    }

    public String getDiscountedCategory(int userId) {
        List<Product> orderedProducts = getOrderedProducts(userId);

        return orderedProducts.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No such category"));
    }

    private List<Product> getOrderedProducts(int userId) {
        return productOrders.stream()
                .filter(productOrder -> productOrder.userId() == userId)
                .map(productOrder -> getProductById(productOrder.productId()))
                .filter(Objects::nonNull)
                // пришлось сделать систему игнорирования несуществующих данных,
                // ибо в таблицах с данными есть ложные значения, в order id продукта есть,
                // а продукта такого почему-то нет
                // Не уверен насколько правильно это сделал
                .toList();
    }

    private Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.productId() == productId)
                .findFirst()
                .orElse(null);
    }

    private int compareAmountOfProductsSells(Product product1, Product product2) {
        return Long.compare(getProductSales(product1), getProductSales(product2));
    }

    private long getProductSales(Product product1) {
        return productOrders.stream()
                .filter(productOrder -> productOrder.productId() == product1.productId())
                .count();
    }


    private Stream<Product> getRecommendedProductsAsStream(UserProfile user) {
        return products.stream()
                .filter(product -> !Collections.disjoint(product.tags(), user.interests()));
    }

    private List<UserProfile> getSimilarUserProfiles(UserProfile rootUser) {
        return userProfiles.stream()
                .filter(userProfile -> rootUser.age() == userProfile.age()
                        && rootUser.gender() == userProfile.gender()
                        && rootUser.location().equals(userProfile.location()))
                .toList();
    }

    private UserProfile getUserProfileById(int userId) {
        return userProfiles.stream()
                .filter(userProfile -> userProfile.userId() == userId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<UserProfile> getUserProfiles() {
        return List.copyOf(userProfiles);
    }
}

package school.faang.sprint_2.task_47600;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    List<UserProfile> users;
    List<Product> products;
    List<ProductOrder> orders;

    public List<Product> getUserRecommendByInterests(int userId) {
        return users.stream()
                .filter(user -> user.userId() == userId)
                .findFirst()
                .map(user -> products.stream()
                        .filter(product -> product.tags().stream().anyMatch(tag -> user.interests().contains(tag)))
                        .toList())
                .orElse(Collections.emptyList());
    }

    public List<Product> getPopularUsersProduct(int userId) {
        UserProfile currentUser = getUserById(userId);
        List<Integer> similarUsersId = getSimilarUsers(currentUser);
        Map<Integer, Long> productCount = countProductOrdersForSimilarUsers(similarUsersId);

        return productCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> products.stream()
                        .filter(product -> product.productId() == entry.getKey())
                        .findFirst()
                        .orElse(null))
                .toList();
    }

    public String getCategoryDiscountForUser(int userId) {
        UserProfile currentUser = getUserById(userId);
        Map<String, Long> categoryCount = countCategoriesFromOrders(currentUser);

        return categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет подходящей категории");
    }

    private UserProfile getUserById(int userId) {
        return users.stream()
                .filter(user -> user.userId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(String.format("Пользователь с ID %d не найден", userId)));
    }

    private List<Integer> getSimilarUsers(UserProfile currentUser) {
        ValidationUtils.isNotNull(currentUser);

        return users.stream()
                .filter(user -> user.age() == currentUser.age()
                        && user.gender().equals(currentUser.gender())
                        && user.location().equals(currentUser.location()))
                .map(UserProfile::userId)
                .toList();
    }

    private Map<Integer, Long> countProductOrdersForSimilarUsers(List<Integer> similarUsersId) {
        ValidationUtils.isNotNull(similarUsersId);

        return orders.stream()
                .filter(order -> similarUsersId.contains(order.userId()))
                .collect(Collectors.groupingBy(ProductOrder::productId, Collectors.counting()));
    }

    private Map<String, Long> countCategoriesFromOrders(UserProfile currentUser) {
        ValidationUtils.isNotNull(currentUser);

        return orders.stream()
                .filter(orders -> orders.userId() == currentUser.userId())
                .map(order -> products.stream()
                        .filter(product -> product.productId() == order.productId()
                                && product.tags().stream().anyMatch(tag -> currentUser.interests().contains(tag)))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Product::category, Collectors.counting()));
    }

    public void printProductList(List<Product> products) {
        ValidationUtils.isNotNull(products);

        products.forEach(product -> System.out.printf("ID:%s, Наименование: %s, Цена: %.2f, Категория: %s, Метки: %s\n",
                product.productId(), product.name(), product.price(), product.category(), product.tags()));
    }

}

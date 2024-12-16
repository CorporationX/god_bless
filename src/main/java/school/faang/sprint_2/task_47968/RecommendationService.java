package school.faang.sprint_2.task_47968;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> users;
    private List<Product> products;
    private List<ProductOrder> orders;

    public List<Product> getProductsByUserInterests(int userId) {
        var user = getUserProfilerById(userId);
        return products.stream().filter(
                product -> product.getTags().stream().anyMatch(tag -> user.getInterests().contains(tag))
        ).toList();
    }

    public List<Product> getProductsBuyingSimilarUsers(int userId) {
        var user = getUserProfilerById(userId);
        return users.stream()
                .filter(similarUser -> similarUser.getAge() == user.getAge()
                        && similarUser.getLocation().equals(user.getLocation())
                        && similarUser.getGender().equals(user.getGender())
                )
                .flatMap(similarUser -> orders.stream().filter(order -> order.getUserId() == similarUser.getUserId()))
                .map(productOrder -> getProductById(productOrder.getProductId()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted((a, b) -> Math.toIntExact(b.getValue() - a.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public String getDiscountCategoryByUserId(int userId) {
        var user = getUserProfilerById(userId);
        return orders.stream()
                .filter(order -> order.getUserId() == user.getUserId())
                .map(order -> getProductById(order.getProductId()))
                .flatMap(product -> product.getTags().stream())
                .distinct()
                .filter(category -> user.getInterests().contains(category))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("User could not find category");
    }

    private Product getProductById(int productId) {
        return products.stream().filter(product -> product.getProductId() == productId).findFirst().orElseThrow(
                () -> new NoSuchElementException("Product with id" + productId + " not exist")
        );
    }

    private UserProfile getUserProfilerById(int userId) {
        return users.stream().filter(userProfile -> userProfile.getUserId() == userId).findFirst().orElseThrow(
                () -> new NoSuchElementException("User with id" + userId + " not exist")
        );
    }
}

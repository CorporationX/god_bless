package school.faang.services;

import school.faang.models.Product;
import school.faang.models.ProductOrder;
import school.faang.models.UserProfile;
import school.faang.exceptions.ProductNotFoundException;
import school.faang.exceptions.UserNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationService {
    private final Map<Integer, UserProfile> userById = new HashMap<>();
    private final Map<Integer, Product> productById = new HashMap<>();
    private final List<UserProfile> users;
    private final List<Product> products;
    private final List<ProductOrder> orders;

    public RecommendationService(List<UserProfile> users, List<Product> products, List<ProductOrder> orders) {
        validateList(users, "user");
        validateList(products, "product");
        validateList(orders, "order");
        for (UserProfile userProfile : users) {
            userById.put(userProfile.getUserId(), userProfile);
        }
        for (Product product : products) {
            productById.put(product.getProductId(), product);
        }
        this.users = users;
        this.products = products;
        this.orders = orders;
    }

    public List<Product> getRecommendationsBasedOnInterests(int userId) {
        UserProfile user = getUserById(userId);
        return products.stream()
                .filter(product -> !Collections.disjoint(user.getInterests(), product.getTags()))
                .toList();
    }

    public List<Product> getRecommendationsAmongSimilarUsers(int userId) {
        UserProfile user = getUserById(userId);
        List<UserProfile> similarUsers = users.stream()
                .filter(user2 -> areUsersSimilar(user, user2))
                .toList();

        Map<Product, Long> productCount = orders.stream()
                .filter(order -> similarUsers.contains(getUserById(order.getUserId())))
                .collect(Collectors.groupingBy(order -> getProductById(order.getProductId()),
                        Collectors.counting()));
        return productCount.entrySet().stream()
                .sorted(Map.Entry.<Product, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public String getProductsWithDiscountForUser(int userId) {
        UserProfile user = getUserById(userId);
        return orders.stream()
                .filter(order -> order.getUserId() == user.getUserId())
                .filter(order -> !Collections.disjoint(user.getInterests(),
                        getProductById(order.getProductId()).getTags()))
                .collect(Collectors.groupingBy(
                        order -> getProductById(order.getProductId()).getCategory().name(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    private boolean areUsersSimilar(UserProfile user1, UserProfile user2) {
        return user1.getAge() == user2.getAge() && user1.getGender().equals(user2.getGender())
                && user1.getInterests().equals(user2.getInterests());
    }

    private <T> void validateList(List<T> list, String message) {
        if (list == null) {
            throw new IllegalArgumentException("List of " + message + "s can't be null.");
        }
        for (var entry : list) {
            if (entry == null) {
                throw new IllegalArgumentException(message + " in list can't be null.");
            }
        }
    }

    private Product getProductById(int productId) {
        Product product = productById.get(productId);
        if (product == null) {
            throw new ProductNotFoundException("No product with id " + productId + " in recommendation service.");
        }
        return product;
    }

    private UserProfile getUserById(int userId) {
        UserProfile user = userById.get(userId);
        if (user == null) {
            throw new UserNotFoundException("No user with id " + userId + " in recommendation service.");
        }
        return user;
    }
}

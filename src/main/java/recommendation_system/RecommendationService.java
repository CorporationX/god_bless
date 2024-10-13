package recommendation_system;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> userProfiles;
    private List<Product> products;
    private List<ProductOrder> productOrders;
    private static final int MAX_LIST_SIZE = 5;


    /**
     * Recommend products to a user based on the products that have common
     * interests with the user.
     *
     * @param userId - The ID of the user to recommend products for.
     * @return - A list of products that match the user's interests.
     */
    public List<Product> recommendProductsByInterests(int userId) {
        Optional<UserProfile> user = findUserById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        return products.stream()
                .filter(product -> hasCommonInterests(user.get(), product))
                .toList();
    }


    /**
     * Finds the 5 most popular products among users of the same gender, age, and location as the given user.
     *
     * @param userId - The ID of the user to find the most popular products for.
     * @return - A list of the 5 most popular products, sorted by popularity in descending order.
     */
    public List<Optional<Product>> recommendPopularProductsAmongSimilarUsers(int userId) {
        Optional<UserProfile> user = findUserById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        List<UserProfile> similarUsers = userProfiles.stream()
                .filter(u -> u.getGender().equals(user.get().getGender()) &&
                        u.getAge() == user.get().getAge() &&
                        u.getLocation().equals(user.get().getLocation()))
                .toList();

        Set<Integer> similarUserIds = similarUsers.stream()
                .map(UserProfile::getUserId)
                .collect(Collectors.toSet());

        Map<String, Long> productOrderCount = productOrders.stream()
                .filter(order -> similarUserIds.contains(order.getUserId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));

        return productOrderCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(MAX_LIST_SIZE)
                .map(entry -> findProductById(Integer.parseInt(entry.getKey())))
                .toList();
    }


    /**
     * Find the category that the user has ordered the most products from.
     *
     * @param userId - The ID of the user to find the category for.
     * @return - The category that the user has ordered the most products from, or null if the user has not ordered any products.
     */
    public String recommendDiscountCategory(int userId) {
        Map<String, Long> categoryCount = productOrders.stream()
                .filter(order -> order.getUserId() == userId)
                .map(order -> {
                    Optional<Product> product = findProductById(Integer.parseInt(order.getProductId()));
                    return product.isPresent() ? product.get().getCategory() : "Unknown";
                })
                .collect(Collectors.groupingBy(category -> category, Collectors.counting()));


        return categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * Find a user by ID.
     *
     * @param userId - The ID of the user to find.
     * @return - The user with the given ID, or null if the user is not found.
     */
    private Optional<UserProfile> findUserById(int userId) {
        return userProfiles.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
    }


    /**
     * Find a product by ID.
     *
     * @param productId - The ID of the product to find.
     * @return - The product with the given ID, or null if the product is not found.
     */
    private Optional<Product> findProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }

    /**
     * Determine if a user has any interests in common with a product.
     *
     * @param user    - The user to compare to the product.
     * @param product - The product to compare to the user.
     * @return - True if there is at least one interest in common, false otherwise.
     */
    private boolean hasCommonInterests(UserProfile user, Product product) {
        return product.getTags().stream()
                .anyMatch(tag -> user.getInterests().contains(tag));
    }
}

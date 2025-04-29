package school.faang.bjs2_71088;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final RecommendationServiceMain SERVICE = RecommendationServiceMain.INSTANCE;
    private static final List<UserProfile> PROFILES = ParseJson.parseUserProfiles();
    private static final List<Product> PRODUCTS = ParseJson.parseProducts();
    private static final List<ProductOrder> ORDERS = ParseJson.parseOrders();

    public static void main(String[] args) {
        SERVICE.configure(PROFILES, PRODUCTS, ORDERS);

        SERVICE.getProfiles().stream()
            .forEach(user -> log.info(
                "Matching products by interest of user {} is {}.", 
                user.getUserId(), 
                getProductsByInterests(user.getUserId()).stream().map(Product::getName).toList()
        ));

        SERVICE.getProfiles().stream()
            .forEach(user -> log.info(
                "Matching products by similar users of user {} is {}.", 
                user.getUserId(),
                getProductBySimilarUsers(user.getUserId()).stream().map(Product::getName).toList().toString()
        ));

        SERVICE.getProfiles().stream()
            .forEach(user -> log.info(
                "Matching category for user {} is {}.", 
                user.getUserId(),
                getCategoryForDiscount(user.getUserId())
            ));
    }

    private static List<Product> getProductsByInterests(int userId) {
        return SERVICE.getProfiles().stream()
            .filter(user -> user.getUserId() == userId)
            .findFirst()
            .map(user -> SERVICE.getProducts().stream()
                .filter(product -> product.getTags().stream().anyMatch(tag -> user.getInterests().contains(tag)))
                .toList()
            )
            .orElse(Collections.emptyList());
    }

    private static List<Product> getProductBySimilarUsers(int userId) {
        long listLimit = 5;
        UserProfile currentUser = SERVICE.getProfiles().stream()
            .filter(u -> u.getUserId() == userId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<UserProfile> similarUsers = SERVICE.getProfiles().stream()
            .filter(u -> isSimilarUser(currentUser, u) && !currentUser.equals(u))
            .peek(u -> log.info("Similar user: {} for user {}.", u.getUserId(), currentUser.getUserId()))
            .toList();

        Map<Integer, Long> productCount = SERVICE.getOrders().stream()
            .filter(order -> similarUsers.stream().map(UserProfile::getUserId).anyMatch(i -> i == order.getUserId()))
            .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));
        log.info("!!! {} !!!", productCount);

        return productCount.entrySet().stream()
            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
            .limit(listLimit)
            .map(entry -> SERVICE.getProducts().stream()
                .filter(product -> product.getProductId() == entry.getKey())
                .toList()
            )
            .flatMap(list -> list.stream())
            .toList();
    }

    private static String getCategoryForDiscount(int userId) {
        UserProfile currentUser = SERVICE.getProfiles().stream()
            .filter(user -> user.getUserId() == userId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("User does noet exist."));

        Map<String, Long> categories = SERVICE.getOrders().stream()
            .filter(order -> order.getUserId() == userId)
            .map(order -> SERVICE.getProducts().stream()
                .filter(product -> isSameProductForUser(product, order.getProductId(), currentUser))
                .findFirst()
                .orElse(null)    
            )
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        return categories.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No matching category");
    }

    private static boolean isSameProductForUser(Product product1, int productId2, UserProfile user) {
        boolean isSameId = product1.getProductId() == productId2;
        boolean isSameTag = product1.getTags().stream().anyMatch(tag -> user.getInterests().contains(tag));

        return isSameId && isSameTag;
    }

    private static boolean isSimilarUser(UserProfile u1, UserProfile u2) {
        boolean isSameAge = u1.getAge() == u2.getAge();
        boolean isSameGender = u1.getGender().equals(u2.getGender());
        boolean isSameLocation = u1.getLocation().equals(u2.getLocation());

        return isSameAge && isSameGender && isSameLocation;
    }
}

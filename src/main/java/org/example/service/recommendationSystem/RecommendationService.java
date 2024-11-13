package org.example.service.recommendationSystem;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import org.example.model.recommendationSystem.Product;
import org.example.model.recommendationSystem.ProductOrder;
import org.example.model.recommendationSystem.UserProfile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private static final ObjectMapper OBJECT_MAPPER = new JsonMapper();
    public static List<UserProfile> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ProductOrder> orders = new ArrayList<>();

    public RecommendationService(URL userProfileJson, URL productJson, URL productOrderJson) {
        try (InputStream userProfileJsonStream = userProfileJson.openStream();
             InputStream productJsonStream = productJson.openStream();
             InputStream productOrderStream = productOrderJson.openStream()) {
            Reader userProfileReader = new BufferedReader(new InputStreamReader(userProfileJsonStream, StandardCharsets.UTF_8));
            Reader productReader = new BufferedReader(new InputStreamReader(productJsonStream, StandardCharsets.UTF_8));
            Reader orderReader = new BufferedReader(new InputStreamReader(productOrderStream, StandardCharsets.UTF_8));
            RecommendationService.users = OBJECT_MAPPER.readValue(userProfileReader, new TypeReference<List<UserProfile>>() {
            });
            RecommendationService.products = OBJECT_MAPPER.readValue(productReader, new TypeReference<List<Product>>() {
            });
            RecommendationService.orders = OBJECT_MAPPER.readValue(orderReader, new TypeReference<List<ProductOrder>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static List<Product> getProductsByUserInterests(long userId) {
        List<String> userInterests = users.stream()
                .filter(user -> user.getUserId() == userId)
                .flatMap(user -> user.getInterests().stream())
                .toList();

        return products.stream()
                .filter(product -> userInterests.stream().anyMatch(userInterest -> product.getTags().contains(userInterest)))
                .collect(Collectors.toList());
    }

    public static List<Product> findTopFiveProductsByUserDemographic(long userId) {
        Optional<UserProfile> optionalUserProfile = users.stream()
                .filter(currentUser -> currentUser.getUserId() == userId)
                .findFirst();

        if (optionalUserProfile.isPresent()) {
            List<UserProfile> sortedUsers = getSortedUsersByAgeGenderLocation(optionalUserProfile.get());
            return getTopBoughtProductsByUsersOrder(sortedUsers, 5);
        } else {
            throw new IllegalArgumentException(String.format("user not found by id: {}", userId));
        }
    }

    public static List<UserProfile> getSortedUsersByAgeGenderLocation(UserProfile userProfile) {
        return users.stream()
                .filter(
                        user -> user.getAge() == userProfile.getAge() ||
                                user.getGender().equals(userProfile.getGender()) ||
                                user.getLocation().equals(userProfile.getLocation()))
                .toList();
    }

    public static List<Product> getTopBoughtProductsByUsersOrder(List<UserProfile> users, int limit) {
        Map<Long, Long> sortedProductsByCount = orders.stream()
                .filter(order -> users.stream()
                        .anyMatch(user -> order.getUserId() == user.getUserId()) &&
                        products.stream().anyMatch(product -> product.getProductId() == order.getProductId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));

        return sortedProductsByCount.entrySet().stream()
                .sorted((order1, order2) -> Math.toIntExact(order2.getValue() - order1.getValue()))
                .limit(limit)
                .map(order -> {
                    return products.stream()
                            .filter(product -> product.getProductId() == order.getKey())
                            .findAny().orElse(null);
                })
                .toList();
    }

    public static Optional<String> getCategoryForDiscount(long userId) {
        List<Product> orderedProducts = getUsersOrderedProducts(userId);
        Map<Product, Long> orderedProductsByCount = orderedProducts.stream()
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        return orderedProductsByCount.entrySet().stream()
                .sorted((product1, product2) -> Math.toIntExact(product2.getValue() - product1.getValue()))
                .limit(1)
                .map(productCount -> productCount.getKey().getCategory())
                .findAny();
    }

    private static List<Product> getUsersOrderedProducts(long userId) {
        return orders.stream()
                .filter(order -> order.getUserId() == userId &&
                        products.stream()
                                .anyMatch(product -> product.getProductId() == order.getProductId())
                )
                .map(order -> {
                    return products.stream()
                            .filter(product -> product.getProductId() == order.getProductId())
                            .findAny().orElse(null);
                })
                .toList();
    }
}

package school.faang.recommender.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static final String PATH_TO_PRODUCTS = "src/main/resources/products.json";
    public static final String PATH_TO_PRODUCT_ORDERS = "src/main/resources/product_orders.json";
    public static final String PATH_TO_USER_PROFILES = "src/main/resources/user_profiles.json";

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<Product> products = objectMapper.readValue(
                new File(PATH_TO_PRODUCTS),
                new TypeReference<>() {
                }
        );
        List<ProductOrder> orders = objectMapper.readValue(
                new File(PATH_TO_PRODUCT_ORDERS),
                new TypeReference<>() {
                }
        );
        List<UserProfile> users = objectMapper.readValue(
                new File(PATH_TO_USER_PROFILES),
                new TypeReference<>() {
                }
        );

        RecommendationService recommendationService = new RecommendationService(users, products, orders);

        System.out.println("\nРекомендаций на основе интересов пользователя с id 1");
        System.out.println(recommendationService.getProductsSortedByUserInterests(1));

        System.out.println("\nРекомендаций популярных товаров среди схожих пользователей для пользователя с id 1");
        System.out.println(recommendationService.findTopProductsForSimilarUsers(1));

        System.out.println("\nКатегория со скидкой для пользователя с id 1");
        System.out.println(recommendationService.suggestDiscountCategoryForUser(1));

    }
}

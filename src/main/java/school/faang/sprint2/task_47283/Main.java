package school.faang.sprint2.task_47283;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<Product> products = new ArrayList<>();
        List<ProductOrder> productOrders = new ArrayList<>();
        List<UserProfile> userProfiles = new ArrayList<>();

        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        try {
            products = objectMapper.readValue(
                    new File("src/main/java/school/faang/sprint2/task_47283/products.json"),
                    new TypeReference<List<Product>>() {
                    });
            productOrders = objectMapper.readValue(
                    new File("src/main/java/school/faang/sprint2/task_47283/product_orders.json"),
                    new TypeReference<List<ProductOrder>>() {
                    });
            userProfiles = objectMapper.readValue(
                    new File("src/main/java/school/faang/sprint2/task_47283/user_profiles.json"),
                    new TypeReference<List<UserProfile>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        RecommendationService recommendationService = new RecommendationService(userProfiles, products, productOrders);
        List<Product> recomendations = recommendationService.findRecommendationsByInterests(15);
        List<Product> recommendMostPurchased = recommendationService.recommendPopularProducts(6);
        String recommendCategory = recommendationService.findCategoryWithDiscount(6);
        recomendations.forEach(System.out::println);
        recommendMostPurchased.forEach(System.out::println);
        System.out.println("Recommended category: " + recommendCategory);
    }
}

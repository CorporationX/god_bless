package school.faangSprint2.t21;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class RecommendationDemo {
    private static final String USER_PROFILES_PATH = "user_profiles.json";
    private static final String PRODUCTS_PATH = "products.json";
    private static final String PRODUCT_ORDERS_PATH = "product_orders.json";

    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            List<UserProfile> userProfiles = loadFromJson(USER_PROFILES_PATH,
                    new TypeToken<List<UserProfile>>() {
                    }, gson);
            List<Product> products = loadFromJson(PRODUCTS_PATH,
                    new TypeToken<List<Product>>() {
                    }, gson);
            List<ProductOrder> productOrders = loadFromJson(PRODUCT_ORDERS_PATH,
                    new TypeToken<List<ProductOrder>>() {
                    }, gson);

            RecommendationService recommendationService = new RecommendationService(
                    userProfiles, products, productOrders);

            if (!userProfiles.isEmpty()) {
                String testUserId = userProfiles.get(0).getUserId();

                System.out.println("\nRecommendations based on interests for user " + testUserId + ":");
                List<Product> recommendations = recommendationService.getRecommendationsByInterests(testUserId);
                if (recommendations.isEmpty()) {
                    System.out.println("No recommendations found based on interests.");
                } else {
                    recommendations.forEach(product ->
                            System.out.println("- " + product.getName() + " (" + product.getCategory() + ")"));
                }

                System.out.println("\nPopular products among similar users for user " + testUserId + ":");
                List<Product> popularProducts = recommendationService.getPopularProductsForSimilarUsers(testUserId);
                if (popularProducts.isEmpty()) {
                    System.out.println("No popular products found among similar users.");
                } else {
                    popularProducts.forEach(product ->
                            System.out.println("- " + product.getName() + " (" + product.getCategory() + ")"));
                }

                System.out.println("\nRecommended category for user " + testUserId + ":");
                String recommendedCategory = recommendationService.recommendCategory(testUserId);
                System.out.println(recommendedCategory != null ? "- " + recommendedCategory : "No category recommendation available.");
            } else {
                System.out.println("No valid user profiles found.");
            }

        } catch (Exception e) {
            System.err.println("Error running recommendation service: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static <T> T loadFromJson(String filePath, TypeToken<T> typeToken, Gson gson) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return gson.fromJson(reader, typeToken.getType());
        }
    }
}
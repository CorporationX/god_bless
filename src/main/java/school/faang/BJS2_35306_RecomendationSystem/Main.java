package school.faang.BJS2_35306_RecomendationSystem;

import java.util.List;
import java.util.Optional;

public class Main {
    private static final JsonLoader JSON_LOADER = new JsonLoader();
    private static final String USERS_PROFILES_FILE_PATH = "src/main/files/user_profiles.json";
    private static final String PRODUCTS_FILE_PATH = "src/main/files/products.json";
    private static final String PRODUCTS_ORDERS_FILE_PATH = "src/main/files/product_orders.json";

    public static void main(String[] args) {
        List<UserProfile> users = JSON_LOADER.loadJson(USERS_PROFILES_FILE_PATH, UserProfile.class);
        List<Product> products = JSON_LOADER.loadJson(PRODUCTS_FILE_PATH, Product.class);
        List<ProductOrder> orders = JSON_LOADER.loadJson(PRODUCTS_ORDERS_FILE_PATH, ProductOrder.class);

        RecommendationService recommendationService = new RecommendationService(users, products, orders);

        System.out.println("Recommendations for user 4:");
        List<Product> recommendedProducts = recommendationService.getRecommendationProducts(4);
        recommendedProducts.forEach(product -> System.out.println(product.getName()));

        System.out.println("\nTop products among similar users for user 10:");
        List<Product> topProducts = recommendationService.getTopProductsAmongSimilarUsers(10);
        topProducts.forEach(product -> System.out.println(product.getName()));

        System.out.println("\nTop category with discount for user 6:");
        Optional<String> topCategory = recommendationService.getCategoryWithDiscount(6);
        topCategory.ifPresent(System.out::println);
    }
}

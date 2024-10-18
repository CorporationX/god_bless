package school.faang.recommendationsystem;

import java.util.List;

public class Main {
    private static final JsonDataLoader dataLoader = new JsonDataLoader();

    public static void main(String[] args) throws Exception {
        List<UserProfile> userProfiles = dataLoader.loadUserProfiles("src/main/resources/user_profiles.json");
        List<Product> products = dataLoader.loadProducts("src/main/resources/products.json");
        List<ProductOrder> productOrders = dataLoader.loadProductOrders("src/main/resources/product_orders.json");

        RecommendationService recommendationService = new RecommendationService(userProfiles, products, productOrders);

        int userId = 1;
        List<Product> recommendations = recommendationService.recommendProductsByInterests(userId);
        System.out.println("Recommendations based on interests: " + recommendations);

        List<Product> popularProducts = recommendationService.recommendPopularProducts(userId);
        System.out.println("Popular products among similar users: " + popularProducts);

        String discountCategory = recommendationService.recommendDiscountCategory(userId);
        System.out.println("Recommended discount category: " + discountCategory);
    }
}
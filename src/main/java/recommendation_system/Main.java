package recommendation_system;

import java.util.List;

public class Main {
    private static final JsonReader JSON_READER = new JsonReader();

    public static void main(String[] args) {
        List<Product> products = JSON_READER.readFile("/products.json", Product.class);
        System.out.println(products);

        List<ProductOrder> productOrders = JSON_READER.readFile("/product_orders.json", ProductOrder.class);
        System.out.println(productOrders);

        List<UserProfile> userProfiles = JSON_READER.readFile("/user_profiles.json", UserProfile.class);
        System.out.println(userProfiles);

        RecommendationService recommendationService = new RecommendationService(userProfiles, products, productOrders);

        System.out.println("\nRecommendation for user with id 7:");
        System.out.println(recommendationService.recommendProductsByInterests(7));

        System.out.println("\nRecommendation popular products for user with id 7:");
        System.out.println(recommendationService.recommendPopularProductsAmongSimilarUsers(7));

        System.out.println("\nRecommendation discount category for user with id 7:");
        System.out.println(recommendationService.recommendDiscountCategory(7));
    }
}

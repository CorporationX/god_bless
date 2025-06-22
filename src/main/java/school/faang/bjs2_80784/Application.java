package school.faang.bjs2_80784;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<UserProfile> profiles = JsonLoader
                    .loadListFromResource("user_profiles.json", new TypeReference<>() {});
            List<Product> products = JsonLoader
                    .loadListFromResource("products.json", new TypeReference<>() {});
            List<ProductOrder> orders = JsonLoader
                    .loadListFromResource("product_orders.json", new TypeReference<>() {});

            RecommendationService service = new RecommendationService(profiles, products, orders);

            int testUserId = profiles.get(0).getUserId();
            System.out.println("Recommendations by interests for user " + testUserId + ":");
            service.recommendByInterests(testUserId).forEach(p ->
                    System.out.println(" - " + p.getName())
            );

            System.out.println("\nPopular products among similar users:");
            service.recommendPopularAmongSimilarUsers(testUserId).forEach(p ->
                    System.out.println(" - " + p.getName())
            );

            System.out.println("\nSuggested discount category:");
            service.suggestDiscountCategory(testUserId).ifPresentOrElse(
                    cat -> System.out.println("Category: " + cat),
                    () -> System.out.println("No suitable category found.")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package school.faang.bjs2_80767_recom_system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            InputStream isProfiles = Main.class.getClassLoader().getResourceAsStream("BJS2-80767/user_profiles.json");
            List<UserProfile> userProfiles = mapper.readValue(isProfiles, new TypeReference<>() {
            });

            InputStream isProducts = Main.class.getClassLoader().getResourceAsStream("BJS2-80767/products.json");
            List<Product> products = mapper.readValue(isProducts, new TypeReference<>() {
            });

            InputStream isOrders = Main.class.getClassLoader().getResourceAsStream("BJS2-80767/product_orders.json");
            List<ProductOrder> orders = mapper.readValue(isOrders, new TypeReference<>() {
            });

            RecommendationService recommendationService = new RecommendationService(userProfiles, products, orders);

            List<Product> interestMatches = recommendationService.getProductRecommendationsByUserInterests(4);
            System.out.println("User interest based matches: ");
            System.out.println(interestMatches);

            List<Product> profileBasedMatches = recommendationService.getProductsFromSimilarUsers(1);
            System.out.println("Similar user based matches: ");
            System.out.println(profileBasedMatches);

            System.out.println("Best categories for user: ");
            System.out.println(recommendationService.bestCategory(16));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

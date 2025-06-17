package school.faang.bjs2_80767_recom_system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Slf4j
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
            log.info("User interest based matches: {}", interestMatches);

            List<Product> profileBasedMatches = recommendationService.getProductsFromSimilarUsers(1);
            log.info("Similar user based matches: {}", profileBasedMatches);

            Optional<String> bestCategory = recommendationService.bestCategory(16);
            if (bestCategory.isEmpty()) {
                log.info("No category matches conditions for recommendation.");
            } else {
                log.info("Best category for user: {}", bestCategory);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

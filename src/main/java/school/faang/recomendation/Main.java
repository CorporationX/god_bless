package school.faang.recomendation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import school.faang.recomendation.domain.Product;
import school.faang.recomendation.domain.ProductOrder;
import school.faang.recomendation.domain.UserProfile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        var userProfiles = mapper.readValue(
                Paths.get("src/main/resources/user_profiles.json").toFile(),
                new TypeReference<List<UserProfile>>() {
                }
        );
        var products = mapper.readValue(
                Paths.get("src/main/resources/products.json").toFile(),
                new TypeReference<List<Product>>() {
                }
        );
        var productOrders = mapper.readValue(
                Paths.get("src/main/resources/product_orders.json").toFile(),
                new TypeReference<List<ProductOrder>>() {
                }
        );
        var service = new RecommendationService(userProfiles, products, productOrders);

        var productsByUserInterests = service.getProductsByUserInterestsAndUserId(4);
        System.out.printf("PRODUCTS BY INTERESTS FOR USER WITH ID = %s%n", 4);
        productsByUserInterests.forEach(System.out::println);
        System.out.println();

        var mostPopularProductsAmongSameUsers = service.getMostPopularProductsAmongSameUsersByUserId(1);
        System.out.println("MOST POPULAR PRODUCTS AMONG SAME USERS");
        mostPopularProductsAmongSameUsers.forEach(System.out::println);
        System.out.println();

        var categoryWithTax = service.getCategoryWithTaxByUserId(7);
        System.out.printf("CATEGORY WITH TAX FOR USER WITH ID = %s: %s%n", 7, categoryWithTax);
    }
}

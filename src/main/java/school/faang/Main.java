package school.faang;

import school.faang.models.Category;
import school.faang.models.Gender;
import school.faang.models.Product;
import school.faang.models.ProductOrder;
import school.faang.models.UserProfile;
import school.faang.services.RecommendationService;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserProfile user = new UserProfile(1, Gender.MALE, 26, "LA", List.of("Art", "Electronics", "Travel"));
        UserProfile user2 = new UserProfile(2, Gender.MALE, 26, "LA", List.of("Running", "Travel"));
        Product product = new Product(1, "Bike", Category.AUTOMOTIVE, 1000, List.of("Travel", "Vehicle"));
        ProductOrder order = new ProductOrder(1, 1, LocalDate.now());
        ProductOrder order2 = new ProductOrder(2, 1, LocalDate.now());

        RecommendationService recommendationService = new RecommendationService(
                List.of(user, user2), List.of(product), List.of(order, order2));
        System.out.println(recommendationService.getRecommendationsBasedOnInterests(1));
        System.out.println(recommendationService.getRecommendationsAmongSimilarUsers(2));
        System.out.println(recommendationService.getProductsWithDiscountForUser(1));
    }
}

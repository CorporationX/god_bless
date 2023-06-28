package faang.school.godbless.sprint2.RecommendationSystem;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecommendationServiceTest {
    List<UserProfile> userProfileList = List.of(
            new UserProfile(1, "male", 20, "Moscow", List.of("coding", "cooking", "games")),
            new UserProfile(2, "male", 30, "London", List.of("running", "coding", "eating")),
            new UserProfile(3, "male", 20, "Moscow", List.of("skateboarding", "coding", "videoGames")),
            new UserProfile(4, "male", 30, "New-York", List.of("driving", "cooking", "skateboarding"))
    );
    List<Product> productList = List.of(
            new Product(1, "keyboard", "device", 100.0, List.of("coding", "games")),
            new Product(2, "Nike", "shoes", 100.0, List.of("running", "feet")),
            new Product(3, "BMW 3", "Car", 100.0, List.of("driving", "cars")),
            new Product(4, "pan", "kitchen", 100.0, List.of("cooking", "kitchen"))
    );
    List<ProductOrder> productOrders = List.of(
            new ProductOrder(1, 1, LocalDateTime.now()),
            new ProductOrder(3, 1, LocalDateTime.now()),
            new ProductOrder(1, 4, LocalDateTime.now()),
            new ProductOrder(1, 1, LocalDateTime.now())
    );
    RecommendationService recommendationService = new RecommendationService(userProfileList, productList, productOrders);

    @Test
    public void interestListTest() {
        List<Product> expected = List.of(new Product(1, "keyboard", "device", 100.0, List.of("coding", "games")));
        List<Product> result = recommendationService.findUserInterestedProducts(1);
        assertEquals(expected.get(0), result.get(0));
    }

    @Test
    public void findMostPopularProductTest() {
        List<Product> expected = List.of(new Product(1, "keyboard", "device", 100.0, List.of("coding", "games")));
        List<Product> result = recommendationService.findMostPopularProducts(1);
        assertEquals(expected.get(0), result.get(0));
    }

    @Test
    public void findPersonalSaleTest() {
        String expected = "device";
        String result = recommendationService.userOrderedProducts(1);
        assertEquals(expected, result);
    }

}
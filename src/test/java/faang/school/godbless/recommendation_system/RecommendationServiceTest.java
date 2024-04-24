package faang.school.godbless.recommendation_system;

import faang.school.godbless.recommendation_system.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationServiceTest {

    private static final RecommendationService RECOMMENDATION_SERVICE = new RecommendationService(
            Main.getUserProfileRepository(),
            Main.getProductRepository(),
            Main.getProductOrderRepository()
    );

    @Test
    void findProductsByInterestsOfUser() {
        List<Product> result = RECOMMENDATION_SERVICE.findProductsByInterestsOfUser(0);
        List<Product> expectedResult = List.of(
                new Product(0, "Ball", "Sport", 3300, List.of("Football", "Volleyball", "Basketball")),
                new Product(4, "Chess figure", "Sport", 130, List.of("Chess"))
        );
        assertEquals(result, expectedResult);
    }

    @Test
    void findTopFiveProductBuyingBySimilarUsers() {
        List<Product> result = RECOMMENDATION_SERVICE.findTopFiveProductBuyingBySimilarUsers(0);
        List<Product> expectedResult = List.of(
                new Product(3, "Swimming cap", "Sport", 2400, List.of("Swimming")),
                new Product(4, "Chess figure", "Sport", 130, List.of("Chess")),
                new Product(0, "Ball", "Sport", 3300, List.of("Football", "Volleyball", "Basketball"))
        );
        assertEquals(result, expectedResult);
    }

    @Test
    void getPersonalDiscountByUserId() {
        String result = RECOMMENDATION_SERVICE.getPersonalDiscountByUserId(0);
        assertEquals(result, "Football");
    }
}
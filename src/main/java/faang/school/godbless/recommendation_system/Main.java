package faang.school.godbless.recommendation_system;

import faang.school.godbless.recommendation_system.model.Gender;
import faang.school.godbless.recommendation_system.model.Product;
import faang.school.godbless.recommendation_system.model.ProductOrder;
import faang.school.godbless.recommendation_system.model.UserProfile;
import faang.school.godbless.recommendation_system.repository.ProductOrderRepository;
import faang.school.godbless.recommendation_system.repository.ProductRepository;
import faang.school.godbless.recommendation_system.repository.UserProfileRepository;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RecommendationService recommendationService = new RecommendationService(
                getUserProfileRepository(),
                getProductRepository(),
                getProductOrderRepository()
        );

        System.out.println(recommendationService.findProductsByInterestsOfUser(0));
        System.out.println(recommendationService.findTopFiveProductBuyingBySimilarUsers(0));
        System.out.println(recommendationService.getPersonalDiscountByUserId(0));
    }

    public static UserProfileRepository getUserProfileRepository() {
        UserProfileRepository userProfileRepository = new UserProfileRepository();
        userProfileRepository.addUserProfile(new UserProfile(Gender.MALE, 18, "Moscow", List.of("Football", "Chess")));
        userProfileRepository.addUserProfile(new UserProfile(Gender.MALE, 18, "Moscow", List.of("Football", "Chess", "Swimming")));
        userProfileRepository.addUserProfile(new UserProfile(Gender.MALE, 33, "London", List.of("TV", "Volleyball")));
        userProfileRepository.addUserProfile(new UserProfile(Gender.FEMALE, 34, "Korolev", List.of("Swimming")));
        userProfileRepository.addUserProfile(new UserProfile(Gender.MALE, 50, "New York", List.of("Basketball", "Golf")));
        return userProfileRepository;
    }

    public static ProductRepository getProductRepository() {
        ProductRepository productRepository = new ProductRepository();
        productRepository.addProduct(new Product("Ball", "Sport", 3300, List.of("Football", "Volleyball", "Basketball")));
        productRepository.addProduct(new Product("Small ball", "Sport", 1200, List.of("Golf")));
        productRepository.addProduct(new Product("TV", "Electronic", 50000, List.of("Tv")));
        productRepository.addProduct(new Product("Swimming cap", "Sport", 2400, List.of("Swimming")));
        productRepository.addProduct(new Product("Chess figure", "Sport", 130, List.of("Chess")));
        return productRepository;
    }

    public static ProductOrderRepository getProductOrderRepository() {
        ProductOrderRepository productOrderRepository = new ProductOrderRepository();
        productOrderRepository.addProductOrder(new ProductOrder(0, 0, LocalDateTime.now()));
        productOrderRepository.addProductOrder(new ProductOrder(0, 4, LocalDateTime.now().minusDays(1)));
        productOrderRepository.addProductOrder(new ProductOrder(0, 4, LocalDateTime.now().minusDays(1)));
        productOrderRepository.addProductOrder(new ProductOrder(1, 0, LocalDateTime.now().minusDays(10)));
        productOrderRepository.addProductOrder(new ProductOrder(1, 4, LocalDateTime.now().minusDays(10)));
        productOrderRepository.addProductOrder(new ProductOrder(1, 3, LocalDateTime.now().minusDays(10)));
        productOrderRepository.addProductOrder(new ProductOrder(2, 2, LocalDateTime.now().minusDays(4)));
        productOrderRepository.addProductOrder(new ProductOrder(3, 3, LocalDateTime.now().minusMonths(2)));
        return productOrderRepository;
    }
}
package faang.school.godbless.sprint_2.recommendation_system;

import faang.school.godbless.sprint_2.recommendation_system.model.Product;
import faang.school.godbless.sprint_2.recommendation_system.model.UserProfile;
import faang.school.godbless.sprint_2.recommendation_system.repository.ProductOrderRepository;
import faang.school.godbless.sprint_2.recommendation_system.repository.ProductRepository;
import faang.school.godbless.sprint_2.recommendation_system.repository.UserProfileRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationService {

    private UserProfileRepository userProfileRepository;
    private ProductRepository productRepository;
    private ProductOrderRepository productOrderRepository;

    public RecommendationService(
            UserProfileRepository userProfileRepository,
            ProductRepository productRepository,
            ProductOrderRepository productOrderRepository
    ) {
        this.userProfileRepository = userProfileRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public List<Product> findProductsByInterestsOfUser(int userId) {
        return productRepository.findAllProducts().stream()
                .filter(product -> product.getTags().stream()
                        .anyMatch(tag -> userProfileRepository.findUserProfileById(userId).getInterests().contains(tag)))
                .toList();
    }

    public List<Product> findTopFiveProductBuyingBySimilarUsers(int userId) {
        UserProfile userProfile = userProfileRepository.findUserProfileById(userId);
        return userProfileRepository.findAllUserProfiles().stream()
                .filter(currentUser -> currentUser.getAge() == userProfile.getAge())
                .filter(currentUser -> currentUser.getLocation().equals(userProfile.getLocation()))
                .filter(currentUser -> currentUser.getGender().equals(userProfile.getGender()))
                .flatMap(user -> productOrderRepository.findProductOrdersByUserId(user.getId()).stream())
                .filter(order -> order.getUserId() != userId)
                .map(order -> productRepository.findProductById(order.getProductId()))
                .collect(Collectors.groupingBy(
                        product -> product,
                        Collectors.counting()
                )).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public String getPersonalDiscountByUserId(int userId) {
        List<String> userInterests = userProfileRepository.findUserProfileById(userId).getInterests();
        Map<String, Long> mapOfTagsFromPreviousOrders = productOrderRepository.findProductOrdersByUserId(userId).stream()
                .flatMap(order -> productRepository.findProductById(order.getProductId()).getTags().stream())
                .collect(Collectors.groupingBy(
                        tag -> tag,
                        Collectors.counting()
                ));
        userInterests.forEach(userInterest ->
                mapOfTagsFromPreviousOrders.put(
                        userInterest,
                        mapOfTagsFromPreviousOrders.getOrDefault(userInterest, 0L) + 1
                )
        );
        return mapOfTagsFromPreviousOrders.entrySet().stream()
                .filter(entry -> userInterests.contains(entry.getKey()))
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
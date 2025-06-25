package school.faang.recomendation;

import lombok.RequiredArgsConstructor;
import school.faang.recomendation.domain.Product;
import school.faang.recomendation.domain.ProductOrder;
import school.faang.recomendation.domain.UserProfile;
import school.faang.recomendation.exception.CategoryNotFoundException;
import school.faang.recomendation.exception.UserNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@RequiredArgsConstructor
public class RecommendationService {

    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;

    public List<Product> getProductsByUserInterestsAndUserId(int userId) {
        var user = getUserById(userId);
        return products.stream()
                .filter(product -> product.getTags().stream()
                        .anyMatch(tag -> user.getInterests().contains(tag)))
                .toList();
    }


    public List<Product> getMostPopularProductsAmongSameUsersByUserId(int userId) {
        var user = getUserById(userId);
        var sameUsersId = userProfiles.stream()
                .filter(profile -> profile.getAge() == user.getAge())
                .filter(profile -> profile.getGender() == user.getGender())
                .filter(profile -> profile.getLocation().equals(user.getLocation()))
                .map(UserProfile::getUserId)
                .collect(Collectors.toSet());
        var productsId = productOrders.stream()
                .filter(order -> sameUsersId.contains(order.getUserId()))
                .map(ProductOrder::getProductId)
                .collect(Collectors.toSet());
        return products.stream()
                .filter(product -> productsId.contains(product.getProductId()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Product, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public String getCategoryWithTaxByUserId(int userId) {
        var user = getUserById(userId);
        var productsId = productOrders.stream()
                .filter(order -> order.getUserId() == userId)
                .map(ProductOrder::getProductId)
                .collect(Collectors.toSet());
        return products.stream()
                .filter(product -> productsId.contains(product.getProductId()))
                .filter(product -> product.getTags().stream()
                        .anyMatch(tag -> user.getInterests().contains(tag)))
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new CategoryNotFoundException(userId));
    }

    private UserProfile getUserById(int userId) {
        return userProfiles.stream()
                .filter(profile -> profile.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}

package faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.service;

import faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model.Product;
import faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model.ProductOrder;
import faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model.UserProfile;
import lombok.Data;

import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@Data
public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;
    private final UserService userService;

    public RecommendationService(List<UserProfile> userProfiles, List<Product> products, List<ProductOrder> productOrders, UserService userService) {
        this.userProfiles = userProfiles;
        this.products = products;
        this.productOrders = productOrders;
        this.userService = userService;
    }

    public List<Product>sortedProducts(int userId) {
        UserProfile user = userService.findById(userId);

        return null;
    }
}

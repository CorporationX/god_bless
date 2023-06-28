package faang.school.godbless.RecomendationSystem;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationService {
    private final List<UserProfile> userProfiles;
    private final List<Product> products;
    private final List<ProductOrder> productOrders;

    public RecommendationService(List<UserProfile> userProfiles, List<Product> products, List<ProductOrder> productOrders) {
        this.userProfiles = userProfiles;
        this.products = products;
        this.productOrders = productOrders;
    }

    public List<Product> userInterests(int userId) {
        List<String> interests = userProfiles.stream().filter(e -> e.getUserId() == userId).map(UserProfile::getInterests).findFirst().orElseThrow();
        return products.stream().filter(product -> product.getTags().stream().anyMatch(interests::contains)).collect(Collectors.toList());
    }

    public List<Product> mostBought(int userId) {
        List<Integer> identical = userProfiles.stream()
                .filter(e -> {
                    UserProfile user = userProfiles.stream().filter(userProfile -> userProfile.getUserId() == userId).findFirst().orElseThrow();
                    return e.getAge() == user.getAge() && e.getLocation().equals(user.getLocation()) && e.getGender().equals(user.getGender());
                })
                .map(UserProfile::getUserId)
                .toList();
        return productOrders.stream()
                .filter(order -> identical.contains(order.getUserId()))
                .map(productOrder -> products.stream().filter(product -> product.getProductId() == productOrder.getProductId()).findFirst().orElseThrow())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String sale(int userId) {
        List<String> interests = userProfiles.stream().filter(userProfile -> userProfile.getUserId() == userId).map(UserProfile::getInterests).findFirst().orElseThrow();
        return productOrders.stream()
                .filter(productOrder -> productOrder.getUserId() == userId)
                .map(productOrder -> products.stream()
                        .filter(product -> product.getProductId() == productOrder.getProductId())
                        .findFirst()
                        .orElseThrow())
                .filter(product -> product.getTags().stream().anyMatch(interests::contains))
                .flatMap(product -> product.getTags().stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .orElseThrow()
                .getKey();
    }
}

package RecommendSystem;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationService {
    private List<UserProfile> userProfiles;
    private List<Product> products;
    private List<ProductOrder> productOrders;

    public RecommendationService(List<UserProfile> userProfiles, List<Product> products, List<ProductOrder> productOrders) {
        this.userProfiles = userProfiles;
        this.products = products;
        this.productOrders = productOrders;
    }

    public List<Product> getRecommendedProductsByInterests(int userId) {
        Optional<UserProfile> userProfile = userProfiles.stream().filter(u -> u.getUserId() == userId).findFirst();
        if (userProfile.isPresent()) {
            List<String> userInterests = userProfile.get().getInterests();
            return products.stream()
                    .filter(product -> product.getTags().stream().anyMatch(userInterests::contains))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<Product> getTopPurchasedProducts(int userId) {
        Optional<UserProfile> userProfile = userProfiles.stream().filter(u -> u.getUserId() == userId).findFirst();
        if (userProfile.isPresent()) {
            String gender = userProfile.get().getGender();
            int age = userProfile.get().getAge();
            String location = userProfile.get().getLocation();

            List<Integer> similarUserIds = userProfiles.stream()
                    .filter(u -> u.getGender().equals(gender) && u.getAge() == age && u.getLocation().equals(location))
                    .filter(u -> u.getUserId() != userId)
                    .map(UserProfile::getUserId)
                    .collect(Collectors.toList());

            List<ProductOrder> similarUserOrders = productOrders.stream()
                    .filter(order -> similarUserIds.contains(order.getUserId()))
                    .collect(Collectors.toList());

            Map<Integer, Long> productPurchaseCounts = similarUserOrders.stream()
                    .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));

            List<Map.Entry<Integer, Long>> sortedProductCounts = productPurchaseCounts.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(5)
                    .collect(Collectors.toList());

            return sortedProductCounts.stream()
                    .map(entry -> products.stream().filter(p -> p.getProductId() == entry.getKey()).findFirst().orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public String getCategoryWithPersonalDiscount(int userId) {
        Optional<UserProfile> userProfile = userProfiles.stream().filter(u -> u.getUserId() == userId).findFirst();
        if (userProfile.isPresent()) {
            List<ProductOrder> userOrders = productOrders.stream()
                    .filter(order -> order.getUserId() == userId)
                    .collect(Collectors.toList());

            List<String> userInterests = userProfile.get().getInterests();

            Map<String, Long> categoryCounts = userOrders.stream()
                    .flatMap(order -> products.stream()
                            .filter(product -> product.getTags().stream().anyMatch(userInterests::contains))
                            .filter(product -> product.getProductId() == order.getProductId())
                            .map(Product::getCategory))
                    .collect(Collectors.groupingBy(category -> category, Collectors.counting()));

            return categoryCounts.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
        } else {
            return null;
        }
    }
}

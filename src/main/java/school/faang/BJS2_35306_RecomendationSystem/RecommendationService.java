package school.faang.BJS2_35306_RecomendationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationService {
    private static final int TOP_SIMILAR_USERS_PRODUCTS_LIMIT = 5;
    private static final int TOP_CATEGORY_LIMIT = 1;

    private List<UserProfile> usersProfiles;
    private List<Product> products;
    private List<ProductOrder> orders;
    private Map<Integer, UserProfile> usersByIds;
    private Map<Integer, Set<UserProfile>> usersByAge;
    private Map<String, Set<UserProfile>> usersByGender;
    private Map<String, Set<UserProfile>> usersByLocation;
    private Map<Integer, Product> productsByIds;
    private Map<Integer, List<ProductOrder>> ordersByUsersIds;
    private Map<String, List<Product>> productsByTags;

    public RecommendationService(List<UserProfile> usersProfiles, List<Product> products, List<ProductOrder> orders) {
        this.usersProfiles = usersProfiles;
        this.products = products;
        this.orders = orders;

        usersByIds = new HashMap<>();
        usersByAge = new HashMap<>();
        usersByGender = new HashMap<>();
        usersByLocation = new HashMap<>();
        initializeUsers();

        productsByIds = new HashMap<>();
        productsByTags = new HashMap<>();
        initializeProducts();

        ordersByUsersIds = new HashMap<>();
        initializeOrders();
    }

    public List<Product> getRecommendationProducts(int userId) {
        return usersByIds.get(userId).getInterests().stream()
                .flatMap(interest -> productsByTags.get(interest).stream().distinct())
                .toList();
    }

    public List<Product> getTopProductsAmongSimilarUsers(int userId) {
        UserProfile userProfile = usersByIds.get(userId);

        Set<UserProfile> usersWithSameAge = usersByAge.get(userProfile.getAge());
        Set<UserProfile> usersWithSameGender = usersByGender.get(userProfile.getGender());
        Set<UserProfile> usersWithSameLocation = usersByLocation.get(userProfile.getLocation());

        return usersWithSameAge.stream()
                .filter(usersWithSameGender::contains)
                .filter(usersWithSameLocation::contains)
                .flatMap(user ->
                        ordersByUsersIds.get(user.getUserId()).stream()
                                .map(order -> productsByIds.get(order.getProductId()))
                )
                .collect(Collectors.groupingBy(
                        product -> product,
                        Collectors.counting())
                )
                .entrySet().stream()
                .sorted(Map.Entry.<Product, Long>comparingByValue().reversed())
                .limit(TOP_SIMILAR_USERS_PRODUCTS_LIMIT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Optional<String> getCategoryWithDiscount(int userId) {
        return ordersByUsersIds.get(userId).stream()
                .map(order -> productsByIds.get(order.getProductId()).getCategory())
                .collect(Collectors.groupingBy(
                        category -> category,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_CATEGORY_LIMIT)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    private void initializeUsers() {
        usersProfiles.forEach(userProfile -> {
            usersByIds.put(userProfile.getUserId(), userProfile);
            usersByAge.computeIfAbsent(userProfile.getAge(), age -> new HashSet<>()).add(userProfile);
            usersByGender.computeIfAbsent(userProfile.getGender(), gender -> new HashSet<>()).add(userProfile);
            usersByLocation.computeIfAbsent(userProfile.getLocation(), location -> new HashSet<>()).add(userProfile);
        });
    }

    private void initializeProducts() {
        products.forEach(product -> productsByIds.put(product.getProductId(), product));
        products.forEach(product ->
                product.getTags().forEach(tag ->
                        productsByTags.computeIfAbsent(tag, productTag -> new ArrayList<>())
                                .add(product)
                )
        );
    }

    private void initializeOrders() {
        orders.forEach(order ->
                ordersByUsersIds.computeIfAbsent(order.getUserId(), userId -> new ArrayList<>()).add(order)
        );
    }
}

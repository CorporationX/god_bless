package faang.school.godbless.recomend_sys;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> userProfileList;
    private List<Product> productList;
    private List<ProductOrder> productOrderList;

    public List<Product> getUserInterestedProducts(int userId) {
        UserProfile userProfile = getUserProfileById(userId);

        List<String> userInterests = userProfile.getInterests();

        return productList.stream()
                .filter(product -> hasMutualElements(product.getTags(), userInterests))
                .toList();
    }

    public List<Optional<Product>> getTopNMostBoughtProductsBySimilarPeople(int userId, int top) {
        UserProfile primaryUserProfile = getUserProfileById(userId);

        List<Integer> similarPeopleId = userProfileList.stream()
                .filter(userProfile -> userProfile.getAge() == primaryUserProfile.getAge() &&
                        userProfile.getGender() == primaryUserProfile.getGender() &&
                        userProfile.getLocation().equals(primaryUserProfile.getLocation()))
                .map(UserProfile::getUserId)
                .toList();

        Map<Integer, Long> productIdAndBoughtNumberMap = productOrderList.stream()
                .filter(productOrder -> similarPeopleId.contains(productOrder.getProductId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId,
                        Collectors.counting()));

        List<Integer> mostBoughtProductIdList = productIdAndBoughtNumberMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();

        return mostBoughtProductIdList.stream()
                .map(productId -> productList.stream()
                        .filter(product -> product.getId() == productId)
                        .findFirst())
                .toList();
    }

    public String getCategoryPersonalDiscount(int userId) {
        List<ProductOrder> userProductOrderList = productOrderList.stream()
                .filter(productOrder -> productOrder.getUserId() == userId)
                .toList();

        List<Product> userProductList = userProductOrderList.stream()
                .map(productOrder -> productList.stream()
                        .filter(product -> productOrder.getProductId() == product.getId())
                        .findFirst().orElseThrow(() -> new RuntimeException("Product with this id is " +
                                "not registered in DataBase")))
                .toList();

        UserProfile userProfile = getUserProfileById(userId);
        List<String> userInterests = userProfile.getInterests();

        Map<String, Long> categoryAndFrequencyMap = userProductList.stream()
                .map(Product::getCategory)
                .filter(userInterests::contains)
                .collect(Collectors.groupingBy(category -> category,
                        Collectors.counting()));

        return categoryAndFrequencyMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("There is not any ordered products"))
                .getKey();
    }

    private UserProfile getUserProfileById(int userId) {
        Optional<UserProfile> userProfileOptional = userProfileList
                .stream()
                .filter(userProfile -> userProfile.getUserId() == userId)
                .findFirst();

        if (userProfileOptional.isEmpty()) {
            throw new IllegalArgumentException("Could not find user with id: " + userId);
        }

        return userProfileOptional.get();
    }

    private boolean hasMutualElements(List<String> firstList, List<String> secondList) {
        List<String> copyOfFirstList = new ArrayList<>(firstList);
        copyOfFirstList.retainAll(secondList);

        return !copyOfFirstList.isEmpty();
    }
}

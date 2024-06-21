package faang.school.godbless.recomend_sys;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

        Set<Integer> similarPeopleId = getSimilarPeopleId(primaryUserProfile);

        Map<Integer, Long> productIdAndBoughtNumberMapOfSimilarPeople =
                getProductIdAndBoughtNumberMapOfSimilarPeople(similarPeopleId);

        List<Integer> mostBoughtProductIdList =
                getTopNBoughtProductIdList(productIdAndBoughtNumberMapOfSimilarPeople, top);

        return getProductListByProductId(mostBoughtProductIdList);
    }

    public String getCategoryPersonalDiscount(int userId) {
        List<ProductOrder> userProductOrderList = getUserProductOrderList(userId);

        List<Product> userProductList = getUserProductList(userProductOrderList);

        UserProfile userProfile = getUserProfileById(userId);
        List<String> userInterests = userProfile.getInterests();

        Map<String, Long> categoryAndFrequencyMap = getCategoryAndFrequencyMap(userProductList, userInterests);

        return categoryAndFrequencyMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("There is not any ordered products"))
                .getKey();
    }

    private UserProfile getUserProfileById(int userId) {
        Optional<UserProfile> userProfileOptional = userProfileList.stream()
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

    private Set<Integer> getSimilarPeopleId(UserProfile primaryUserProfile) {
        return userProfileList.stream()
                .filter(userProfile -> userProfile.getAge() == primaryUserProfile.getAge() &&
                        userProfile.getGender() == primaryUserProfile.getGender() &&
                        userProfile.getLocation().equals(primaryUserProfile.getLocation()) &&
                        userProfile.getUserId() != primaryUserProfile.getUserId())
                .map(UserProfile::getUserId)
                .collect(Collectors.toSet());
    }

    private Map<Integer, Long> getProductIdAndBoughtNumberMapOfSimilarPeople(Set<Integer> similarPeopleId) {
        return productOrderList.stream()
                .filter(productOrder -> similarPeopleId
                        .contains(productOrder.getProductId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId,
                        Collectors.counting()));
    }

    private List<Integer> getTopNBoughtProductIdList(Map<Integer, Long> productIdAndBoughtNumberMap, int top) {
        return productIdAndBoughtNumberMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    private List<ProductOrder> getUserProductOrderList(int userId) {
        return productOrderList.stream()
                .filter(productOrder -> productOrder.getUserId() == userId)
                .toList();
    }

    private List<Product> getUserProductList(List<ProductOrder> userProductOrderList) {
        return userProductOrderList.stream()
                .map(productOrder -> productList.stream()
                        .filter(product -> productOrder.getProductId() == product.getId())
                        .findFirst().orElseThrow(() ->
                                new RuntimeException("Product with this id is not registered in DataBase")))
                .toList();
    }

    private Map<String, Long> getCategoryAndFrequencyMap(List<Product> userProductList, List<String> userInterests) {
        return userProductList.stream()
                .map(Product::getCategory)
                .filter(userInterests::contains)
                .collect(Collectors.groupingBy(category -> category,
                        Collectors.counting()));
    }

    private List<Optional<Product>> getProductListByProductId(List<Integer> productIdList) {
        return productIdList.stream()
                .map(productId -> productList.stream()
                        .filter(product -> product.getId() == productId)
                        .findFirst())
                .toList();
    }
}

package faang.school.godbless.sprint2.RecommendationSystem;


import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private List<UserProfile> userProfileList;
    private List<Product> productList;
    private List<ProductOrder> productOrders;


    public List<Product> intersList(int userId) {

        List<String> usersInterests = userProfileList.stream()
                .filter(a -> a.getUserId() == userId)
                .findFirst().get().getInterests();

        return productList.stream()
                .filter(product -> product.getTags()
                        .stream().anyMatch(usersInterests::contains)).toList();
    }

    public List<Product> findMostPopularProducts(int userId) {
        UserProfile currentUser = userProfileList.stream().filter(userProfile -> userProfile.getUserId() == userId).findFirst().orElseThrow(IllegalArgumentException::new);

        List<Integer> userProfilesId = userProfileList.stream()
                .filter(userProfile -> userProfile.getAge() == currentUser.getAge()
                        && Objects.equals(userProfile.getGender(), currentUser.getGender())
                        && Objects.equals(userProfile.getLocation(), currentUser.getLocation())
                        && userProfile.getUserId() != currentUser.getUserId()).map(UserProfile::getUserId)
                .toList();

        Map<Product, Long> map = productOrders.stream()
                .filter(product -> userProfilesId.contains(product.getUserId()))
                .map(ProductOrder::getProductId)
                .flatMap(productOrder4 -> productList.stream().filter(product -> product.getProductId() == productOrder4))
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public String findPersonalSale(int userId) {
        List<Product> getProducts = productOrders.stream()
                .filter(c -> c.getUserId() == userId)
                .flatMap(a -> productList.stream().filter(product -> product.getProductId() == a.getProductId())).toList();

        Map<String, Long> map;

        List<String> usersInterests = userProfileList.stream()
                .filter(a -> a.getUserId() == userId)
                .findFirst().get().getInterests();

        List<Product> list2 = getProducts.stream()
                .filter(a -> usersInterests.stream().anyMatch(f -> f.contains(a.getTags().get(0)))).toList();

        map = list2.stream().map(Product::getCategory).collect(Collectors.groupingBy(a -> a, Collectors.counting()));


        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

}

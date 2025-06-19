package school.faang.bjs2_80784;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendationService {
    private final List<UserProfile> profiles;
    private final List<Product> products;
    private final List<ProductOrder> orders;

    public List<Product> recommendByInterests(int userId) {
        return profiles.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .map(user -> {
                    List<String> rawInterests = Objects
                            .requireNonNullElse(user.getInterests(), Collections.emptyList());

                    if (rawInterests.isEmpty()) {
                        return Collections.<Product>emptyList();
                    }

                    List<String> normalizedInterests = rawInterests.stream()
                            .filter(Objects::nonNull)
                            .map(String::toLowerCase)
                            .toList();

                    return products.stream()
                            .filter(product -> {
                                List<String> tags = Objects
                                        .requireNonNullElse(product.getTags(), Collections.emptyList());
                                return tags.stream()
                                        .filter(Objects::nonNull)
                                        .map(String::toLowerCase)
                                        .anyMatch(normalizedInterests::contains);
                            })
                            .toList();
                })
                .orElse(Collections.emptyList());
    }

    public List<Product> recommendPopularAmongSimilarUsers(int userId) {
        Optional<UserProfile> optionalUser = profiles.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst();

        if (optionalUser.isEmpty()) {
            return Collections.emptyList();
        }

        UserProfile target = optionalUser.get();

        List<Integer> similarUserIds = profiles.stream()
                .filter(u -> u.getUserId() != userId) // исключаем самого себя
                .filter(u -> u.getGender().equalsIgnoreCase(target.getGender()))
                .filter(u -> u.getAge() == target.getAge())
                .filter(u -> u.getLocation().equalsIgnoreCase(target.getLocation()))
                .map(UserProfile::getUserId)
                .toList();

        if (similarUserIds.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Integer, Long> productFrequency = orders.stream()
                .filter(o -> similarUserIds.contains(o.getUserId()))
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));

        List<Integer> topProductIds = productFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

        return products.stream()
                .filter(p -> topProductIds.contains(p.getProductId()))
                .toList();
    }

    public Optional<String> suggestDiscountCategory(int userId) {
        Optional<UserProfile> optionalUser = profiles.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst();

        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }

        UserProfile user = optionalUser.get();
        Set<String> normalizedInterests = user.getInterests() == null
                ? Collections.emptySet() :
                user.getInterests().stream()
                        .filter(Objects::nonNull)
                        .map(String::toLowerCase)
                        .collect(Collectors.toSet());

        if (normalizedInterests.isEmpty()) {
            return Optional.empty();
        }

        Set<Integer> orderedProductIds = orders.stream()
                .filter(o -> o.getUserId() == userId)
                .map(ProductOrder::getProductId)
                .collect(Collectors.toSet());

        Map<String, Long> categoryCount = products.stream()
                .filter(p -> orderedProductIds.contains(p.getProductId()))
                .filter(p -> {
                    List<String> tags = p.getTags() == null ? Collections.emptyList() : p.getTags();
                    return tags.stream()
                            .filter(Objects::nonNull)
                            .map(String::toLowerCase)
                            .anyMatch(normalizedInterests::contains);
                })
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        return categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }


}

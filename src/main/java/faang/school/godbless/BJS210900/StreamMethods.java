package faang.school.godbless.BJS210900;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethods {
    public static Set<List<Integer>> getPairsWithSumOf(List<Integer> nums, int sum) {
        Map<Integer, Long> duplicates = nums.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        return duplicates.keySet().stream()
                .map(num -> {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(num);
                    if (num == sum - num && duplicates.get(num) > 1) {
                        innerList.add(num);
                    } else if (duplicates.containsKey(sum - num)) {
                        innerList.add(sum - num);
                    }
                    innerList.sort(null);
                    return innerList;
                })
                .filter(list -> list.size() > 1)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countriesWithCapitals) {
        List<String> capitals = new ArrayList<>(countriesWithCapitals.keySet().stream().toList());
        capitals.sort(null);
        return capitals.stream()
                .map(string -> countriesWithCapitals.get(string))
                .toList();
    }

    public static List<String> sortFilteredStrings(List<String> strings, char filter) {
        return strings.stream()
                .filter(string -> string.startsWith("" + filter))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Set<Set<String>> findStrangersWithCommonFriends(Map<String, List<String>> friends) {
        Map<String, List<String>> friendsCopy = new HashMap<>(friends);
        friends.values().stream()
                        .flatMap(List::stream)
                                .forEach(name -> friendsCopy.computeIfAbsent(name,
                                        k -> friends.keySet().stream()
                                                .filter(friend -> friends.get(friend).contains(name))
                                                .toList()
                                        )
                                );

        Set<Set<String>> result = new HashSet<>();

        friendsCopy.keySet().forEach(commonFriend -> {
            for (int i = 0; i < friendsCopy.get(commonFriend).size(); i++) {
                String nameForSearch = friendsCopy.get(commonFriend).get(i);
                for (int j = i + 1; j < friendsCopy.get(commonFriend).size(); j++) {
                    String possibleFriend = friendsCopy.get(commonFriend).get(j);
                    if (!friendsCopy.get(nameForSearch).contains(possibleFriend)) {
                        result.add(Set.of(nameForSearch, possibleFriend));
                    }
                }
            }
        });

        return result;
    }
}

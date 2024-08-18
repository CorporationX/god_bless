package faang.school.godbless.StreamAPI2;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//#1
//public class Main {
//    public static void main(String[] args) {
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,21);
//        int targetSum = 20;
//        List<List<Integer>> pairs = findPairsWithSum(numbers, targetSum);
//        System.out.println("Pairs: " + pairs);
//    }
//
//    public static List<List<Integer>> findPairsWithSum(List<Integer> numbers, int targetSum) {
//        Set <Integer> seen = new HashSet<>();
//        return numbers.stream()
//                .flatMap(n -> {
//                    int complement = targetSum - n;
//                    if (seen.contains(complement)) {
//                        return Stream.of(Arrays.asList(complement, n));
//                    } else {
//                        seen.add(n);
//                        return Stream.empty();
//                    }
//                })
//                .collect(Collectors.toList());
//    }
//}

//#2
//

//#3
//public class Main {
//    public static void main(String[] args) {
//        Map<String, String> countryCapitals = Map.of(
//                "France", "Paris",
//                "Germany", "Berlin",
//                "Italy", "Rome",
//                "Spain", "Madrid"
//        );
//        List<String> sortedCapitals = getSortedCapitals(countryCapitals);
//        System.out.println("Sorted capitals: " + sortedCapitals);
//    }
//
//    public static List<String> getSortedCapitals(Map<String, String> countryCapitals) {
//        return countryCapitals.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .map(Map.Entry::getValue)
//                .collect(Collectors.toList());
//    }
//}

//#4
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friendsMap = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        Set<Set<String>> pairs = findPairsWithCommonFriends(friendsMap);
        System.out.println("Pairs with common friends: " + pairs);
    }

    public static Set<Set<String>> findPairsWithCommonFriends(Map<String, List<String>> friendsMap) {
        Set<Set<String>> result = new HashSet<>();

        for (String person : friendsMap.keySet()) {
            List<String> friends = friendsMap.get(person);
            for (String friend : friends) {
                List<String> friendsOfFriend = friendsMap.get(friend);
                for (String mutualFriend : friendsOfFriend) {
                    if (!friends.contains(mutualFriend) && !mutualFriend.equals(person)) {
                        Set<String> pair = new HashSet<>(Arrays.asList(person, mutualFriend));
                        result.add(pair);
                    }
                }
            }
        }

        return result;
    }
}
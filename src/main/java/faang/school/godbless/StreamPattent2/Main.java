package faang.school.godbless.StreamPattent2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = findUniqueCombinationsThatEqualsTo(List.of(1, 9, 3, 6, 4, 5), 10);
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
    private static Map<Integer, Integer> findUniqueCombinationsThatEqualsTo(List<Integer> nums, int target) {
        Map<Integer, Integer> pairs = new HashMap<>();
        nums.forEach(num -> {
            int subSum = target - num;
            if (pairs.containsKey(num)) {
                pairs.put(num, subSum);
            } else {
                pairs.put(subSum, null);
            }
        });

        return pairs.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static List<String> sortCountriesAndGetCapitals(HashMap<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> getWordsThatStartsWithCharAndSortByLength(List<String> words, char ch) {
        return words.stream()
                .filter(word -> word.charAt(0) == ch)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static HashMap<String, String> getAllFriendOfFriends(HashMap<String, List<String>> peoplesFriends) {
        return null;
    }
}

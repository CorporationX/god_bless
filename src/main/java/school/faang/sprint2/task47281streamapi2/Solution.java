package school.faang.sprint2.task47281streamapi2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static List<String> sorted(Map<String, String> mapCountry) {
        List<String> capitals =
                mapCountry.entrySet().stream()
                        .sorted(Comparator.comparing(entry -> entry.getKey()))
                        .map(Map.Entry::getValue)
                        .toList();
        return capitals;
    }

    public static List<String> sortedString(List<String> list, Character targetChar) {
        return list.stream()
                .filter(st -> st.charAt(0) == targetChar)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSorted(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.matches("^[" + alphabet + "]+$"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
}
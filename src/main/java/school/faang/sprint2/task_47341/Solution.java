package school.faang.sprint2.task_47341;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> setOfNums = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> setOfNums.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((country1, country2) -> country1.getKey().compareTo(country2.getKey()))
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> findStringsStartsWithChar(List<String> strings, Character firstChar) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(firstChar)))
                .sorted().toList();
    }

    public static List<String> convertNumsToBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> findStringsConsistingOf(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

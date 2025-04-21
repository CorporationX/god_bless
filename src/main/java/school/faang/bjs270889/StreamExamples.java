package school.faang.bjs270889;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExamples {
    public static List<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(Math.min(num, sum - num), Math.max(num, sum - num)))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> sortCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByChar(List<String> strings, char start) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == start)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> changeToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}






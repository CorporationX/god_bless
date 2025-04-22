package stream.practice.two;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsUtility {
    public static Set<Set<Integer>> findPairEqualsTarget(Set<Integer> nums, int target) {
        Set<Set<Integer>> pairs = new HashSet<>();
        for (Integer num : nums) {
            for (Integer i : nums) {
                if (num + i == target && !i.equals(num)) {
                    pairs.add(Set.of(num, i));
                }
            }
        }

        return nums
                .stream()
                .peek(System.out::println)
                .flatMap(num -> nums
                        .stream()
                        .filter(num1 -> num + num1 == target)
                        .filter(num1 -> !num1.equals(num))
                        .map(num1 -> Set.of(num, num1)))
                .collect(Collectors.toSet());
    }

    public static List<String> getCountryCapital(Map<String, String> countries) {
        if (countries == null || countries.isEmpty()) {
            throw new IllegalArgumentException("Parameter is null!");
        }
        return countries
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortStringsBySymbol(List<String> strings, char symbol) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Parameter is null!");
        }
        return strings
                .stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinary(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Parameter is null!");
        }
        return nums
                .stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringByAlphabet(List<String> strings, String alphabet) {
        if (strings == null || strings.isEmpty() || alphabet == null) {
            throw new IllegalArgumentException("Parameter is null!");
        }
        return strings
                .stream()
                .map(String::toLowerCase)
                .filter(str -> str.chars()
                        .allMatch(ch -> alphabet.toLowerCase().indexOf(ch) != -1))
                .sorted()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

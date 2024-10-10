package bjs2_35157;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
    public static Set<List<Integer>> findPairs(List<Integer> list, int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> diff = new HashSet<>();

        list.stream()
                .peek(num -> diff.add(target - num))
                .filter(diff::contains)
                .forEach(num -> pairs.add(
                        Stream.of(num, target - num).sorted().toList()
                ));

        return pairs;
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.keySet().stream()
                .sorted(String::compareTo)
                .map(countries::get)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> integerToBinaryString(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars()
                        .allMatch(symbol -> alphabet.contains(Character.toString(symbol)))
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

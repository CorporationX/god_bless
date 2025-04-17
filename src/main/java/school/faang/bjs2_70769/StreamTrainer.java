package school.faang.bjs2_70769;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTrainer {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> set, int sum) {
        return set.stream()
                .filter(x -> set.contains(sum - x))
                .map(x -> Arrays.asList(x, sum - x))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> map) {
        return map.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> filterSortedStrings(List<String> list, char c) {
        return list.stream()
                .filter(string -> string.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringsViaAlphabet(List<String> list, String s) {
        return list.stream()
                .filter(string -> s.chars().anyMatch(c -> string.equals(String.valueOf(c))))
                .toList();
    }
}

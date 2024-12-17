package school.faang.bjs247317;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Processor {
    public static Set<List<Integer>> uniqueSum(List<Integer> numbers, int sum) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        Set<Integer> added = new HashSet<>();

        return numbers.stream()
                .filter(number -> numberSet.contains(sum - number) && !added.contains(number))
                .map(number -> {
                    added.add(number);
                    added.add(sum - number);
                    return List.of(number, sum - number);
                })
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortStartingWithChar(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(String::compareTo)
                .toList();
    }

    public static List<String> numbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortStartingWithChar(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars().allMatch(letter -> alphabet.contains(String.valueOf((char) letter))))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

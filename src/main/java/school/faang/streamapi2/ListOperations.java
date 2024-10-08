package school.faang.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> pairOfNumbersThatUpNumber(List<Integer> integers, Integer targetNumber) {
        Set<Integer> set = new HashSet<>(integers);
        return integers.stream()
                .filter(num -> set.contains(targetNumber - num))
                .map(num -> Arrays.asList(num, targetNumber - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountiesPrintCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(a -> a.getValue())
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char targerChar) {
        return strings.stream()
                .filter(a -> a.charAt(0) == targerChar)
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public static List<String> numbersToBinaryCode(List<Integer> numbers) {
        return numbers.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .toList();
    }

    public static List<String> filterAndSortToLenghtString(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.matches("[" + alphabet + "]+"))
                .sorted((a, b) -> a.length() - b.length())
                .toList();
    }
}